package fr.planandchill.authentification;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.ArrayList;


public class JwtTokenProvider {
        private static final String SECRET_KEY = "123456789ABCDEF123456789ABCDEF123456789ABCDEF123456789ABCDEF";
        private static final long EXPIRATION_TIME = 864_000_000; // 10 days

        public String generateToken(UserDetails userDetails) {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        }

        public boolean validateToken(String token) {
            try {
                Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
                return true;
            } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
                return false;
            }
        }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                getUsernameFromToken(token),
                "",
                new ArrayList<>());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
}
