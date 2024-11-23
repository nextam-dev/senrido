package jp.co.senrido.handlers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class LogoutPostProcess implements LogoutHandler {
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		try {
			RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
			redirectStrategy.sendRedirect(request, response, "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
