package com.notas.core.configuration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

public class JwtUtil {

	//Metodo para crear el JWT y enviarle al cliente en el header de la respuesta
	static void addAuthentication(HttpServletResponse response, String userName) {
		
		String token = Jwts.builder()
				.setSubject(userName)
				
				// Vamos a asignar un tiempo de expiracion de 1 minuto
				
				// Hash con el que firmaremos la clave
				.signWith(SignatureAlgorithm.HS512, "P@tit0")
				.compact();
		
		// Agregamos al encabezado el token
		response.addHeader("Authorization", "Bearer " + token);
	}

	// Metodo para validar el token envido por el cliente
	public static Authentication getAuthentication(HttpServletRequest request) {
		
		// Obtenemos el token que viene en el encabezado de la petcion
		String token = request.getHeader("Authorization");
		
		// Si hay un token presente entonces lo validamos
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					.parseClaimsJws(token.replace("Bearer", "")) // Este metodo es el que valida
					.getBody()
					.getSubject();
			
			// Recordamos que para las demas peticiones que no sean /login
			// no requerimos una autenticacion por username/password
			// por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
			return user != null ?
					new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
						null;
		}
		return null;
	}

	
	
}
