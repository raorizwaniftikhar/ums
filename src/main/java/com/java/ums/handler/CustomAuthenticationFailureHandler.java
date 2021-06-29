package com.java.ums.handler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.java.ums.exception.OAuth2AuthenticationProcessingException;
import com.java.ums.service.MessageService;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Resource
	private MessageService messageService;

	@Override
	public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception)
			throws IOException, ServletException {
		String msg = messageService.getMessage("message.badCredentials");
		if (exception instanceof OAuth2AuthenticationProcessingException) {
			msg = exception.getMessage() == null ? "OAuth error occurred" : exception.getMessage();
		}
		setDefaultFailureUrl("/login?error=" + msg);
		super.onAuthenticationFailure(request, response, exception);
	}
}