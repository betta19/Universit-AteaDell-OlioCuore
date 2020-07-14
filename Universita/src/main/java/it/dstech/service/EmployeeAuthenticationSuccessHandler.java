package it.dstech.service;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		boolean hasStudente = false;
		boolean hasDocente = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("STUDENTE")) {
				hasStudente = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("DOCENTE")) {
				hasDocente = true;
				break;
			}
		}

		if (hasStudente) {
			redirectStrategy.sendRedirect(request, response, "/studente/home");
		} else if (hasDocente) {
			redirectStrategy.sendRedirect(request, response, "/docente/home");
		} else {
			throw new IllegalStateException();
		}
	}

}