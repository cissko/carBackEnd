package com.melgar.service;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 864_000_00; //Un día en milisegundos
	static final String SIGNINGKEY="SecretKey"; //Clave de firma para firmar digital de JWT
	static final String PREFIX="Bearer";
	
	//Añade el token de autorización en el header:
	static public void addToken(HttpServletResponse res, String username) {
		String JwtToken = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis()+ EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGNINGKEY ).compact();
		res.addHeader("Authorization", PREFIX +" "+ JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	static public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token !=null) {
			String user = Jwts.parser()
				.setSigningKey(SIGNINGKEY)
				.parseClaimsJws(token.replace(PREFIX, ""))
				.getBody()
				.getSubject();
			if(user!=null) {
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}
		
		
		return null;
				
	}
}
