package com.bill_soft.security;

import java.util.Base64;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.bill_soft.entity.Role;
import com.bill_soft.exception.CustomException;
@Component
public class JwtTokenProvider 
{
	@Value("${security.jwt.token.secret-key:secret-key}")
private String secretKey;

@Value("${security.jwt.token.expire-length:3600000}")
private long validityInMilliseconds = 3600000; // 1h

@Value("${billsoft.jwtRefreshExpirationMs}")
private long refreshValidityMs;
@Autowired
private MyUserDetails myUserDetails;

@PostConstruct
protected void init() {
  secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
}

public String createToken(String username, List<Role> roles) {

  Claims claims = Jwts.claims().setSubject(username);
  claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));

  Date now = new Date();
  Date validity = new Date(now.getTime() + validityInMilliseconds);

  return Jwts.builder()//
      .setClaims(claims)//
      .setIssuedAt(now)//
      .setExpiration(validity)//
      .signWith(SignatureAlgorithm.HS256, secretKey)//
      .compact();
}
public String createRefreshToken(String username) {

	Claims claims = Jwts.claims().setSubject(username);
	claims.setAudience("Refresh");
	Date now = new Date();
	Date validity = new Date(now.getTime() + refreshValidityMs);

	return Jwts.builder()//
			.setClaims(claims)//
			.setIssuedAt(now)//
			.setExpiration(validity)//
			.signWith(SignatureAlgorithm.HS256, secretKey)//
			.compact();
}
public UsernamePasswordAuthenticationToken getAuthentication(String token) {		  
  UserDetails userDetails = myUserDetails.loadUserByUsername(getUsername(token));
  return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
}

public String getUsername(String token) {
  return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
}

public String resolveToken(HttpServletRequest req) {
  String bearerToken = req.getHeader("Authorization");
  if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
    return bearerToken.substring(7);
  }
  return null;
}

public boolean validateToken(String token) {
  try {
    Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    return true;
  } catch (JwtException | IllegalArgumentException e) {
    throw new CustomException("Expired or invalid JWT token", HttpStatus.UNAUTHORIZED);
  }
}
public boolean validateRefreshToken(String token) {
	try {
		Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
		return true;
	} catch (JwtException | IllegalArgumentException e) {
		throw new CustomException("Expired or invalid JWT token", HttpStatus.UNAUTHORIZED);
	}
}

}

