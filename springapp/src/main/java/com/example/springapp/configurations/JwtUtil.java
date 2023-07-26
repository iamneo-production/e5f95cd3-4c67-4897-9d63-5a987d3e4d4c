package com.example.springapp.configurations;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
    //sign the JSON Web Tokens
    private final String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";

    //takes a JWT token as input and extracts the username (subject) from the token's claims
    public String extractUsername(String token) {

        //method to retrieve the subject from the token.
        return extractClaim(token, Claims::getSubject);
    }

    // method takes a JWT token as input, extracts the expiration date from the token's claims
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //generic method that takes a JWT token, Function to resolve a specific claim from the token's claims
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);

        //retrieve the desired claim.
        return claimsResolver.apply(claims);
    }

    //method takes jwt token resolve it returns all claims from token,
    //the SECRET_KEY to validate the token's signature
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    //WT token is expired by comparing its expiration date with the current date
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //generates a new JWT token based on the provided UserDetails object
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

//    private String createToken(Map<String, Object> claims, String subject) {
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
//    }


//creates a new JWT token by setting the provided claims (payload) and the subject (username) in the token's header.
    private String createToken(Map<String, Object> claims, String subject) 
    {
    	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
    	        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
    	        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

    }

    //validates the token by checking the username extracted from the token matches the username from the UserDetails object 
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}