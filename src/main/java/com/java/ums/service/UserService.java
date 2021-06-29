package com.java.ums.service;

import java.util.Map;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import com.java.ums.dto.LocalUser;
import com.java.ums.dto.UserRegistrationForm;
import com.java.ums.exception.UserAlreadyExistAuthenticationException;
import com.java.ums.model.User;


public interface UserService {

	public User registerNewUser(UserRegistrationForm UserRegistrationForm) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
