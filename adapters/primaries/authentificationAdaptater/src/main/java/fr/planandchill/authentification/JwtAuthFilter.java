package fr.planandchill.authentification;

import fr.planandchill.authentification.models.UserInfoDetails;
import fr.planandchill.authentification.service.JwtService;
import fr.planandchill.domain.UserDN;
import fr.planandchill.use.cases.authentification.LoginCustomerUE;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.sql.SQLException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    private final LoginCustomerUE loginCustomerUE;

    public JwtAuthFilter(JwtService jwtService, LoginCustomerUE loginCustomerUE) {
        this.jwtService = jwtService;
        this.loginCustomerUE = loginCustomerUE;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDN userDN = this.loginCustomerUE.execute(username);
            try {
                userDN = this.loginCustomerUE.execute(username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            UserDetails userDetails = new UserInfoDetails(userDN);
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
