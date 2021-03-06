package com.notas.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.notas.core.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/login", "/nota/all", "/v1/notas").permitAll() //permitimos el acceso a /login a cualquiera
		.anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
		.and()
		//Las peticiones /login pasaran por este filtro
		.addFilterBefore(new LoginFilter("/login", authenticationManager()), 
				UsernamePasswordAuthenticationFilter.class)
		//Las demas peticiones pasaran por este filtro para validar el token
		.addFilterBefore(new JwtFilter(), 
				UsernamePasswordAuthenticationFilter.class);
	}

}
