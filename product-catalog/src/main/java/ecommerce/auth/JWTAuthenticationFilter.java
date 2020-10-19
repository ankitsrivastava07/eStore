
package ecommerce.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestTokenHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		if (Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith("Bearer ")) {
			token = requestTokenHeader.substring(7);
			//HTTP call to auth server, that will return user details
			//if user details found then only proceed next
			if (Objects.nonNull(token) && Objects.nonNull(userName)) {
				
				if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication())) {
					filterChain.doFilter(request, response);
				} else {
					UserDetails userDetails = null;
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, userDetails.getUsername(),new ArrayList<>());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					filterChain.doFilter(request, response);
				}
			}
		}
	}
}
