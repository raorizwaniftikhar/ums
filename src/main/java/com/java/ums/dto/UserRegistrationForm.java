package com.java.ums.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.javac.ums.validator.PasswordMatches;


@PasswordMatches
public class UserRegistrationForm {

	private Long userID;

	private String providerUserId;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String email;

	private SocialProvider socialProvider;

	@Size(min = 8, message = "{Size.userDto.password}")
	private String password;

	@NotEmpty
	private String matchingPassword;

	private String companyName;

	private String companyUrl;

	public UserRegistrationForm() {
	}

	/**
	 * @param userID
	 * @param displayName
	 * @param firstName
	 * @param lastName
	 * @param phoneno
	 * @param email
	 * @param password
	 * @param socialProvider
	 * @param companyName
	 * @param comapnyUrl
	 */
	public UserRegistrationForm(String providerUserId, String firstName, String lastName, String email, String password,
			String companyName, String companyUrl, SocialProvider socialProvider) {
		this.providerUserId = providerUserId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.companyName = companyName;
		this.companyUrl = companyUrl;
		this.socialProvider = socialProvider;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public SocialProvider getSocialProvider() {
		return socialProvider;
	}

	public void setSocialProvider(final SocialProvider socialProvider) {
		this.socialProvider = socialProvider;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public static class Builder {
		private String providerUserID;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String companyName;
		private String companyUrl;
		private SocialProvider socialProvider;

		public Builder addProviderUserID(final String userID) {
			this.providerUserID = userID;
			return this;
		}

		public Builder addFirstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder addLastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder addEmail(final String email) {
			this.email = email;
			return this;
		}

		public Builder addPassword(final String password) {
			this.password = password;
			return this;
		}

		public Builder addComapnyName(final String companyName) {
			this.companyName = companyName;
			return this;
		}

		public Builder addCompanyUrl(final String companyUrl) {
			this.companyUrl = companyUrl;
			return this;
		}

		public Builder addSocialProvider(final SocialProvider socialProvider) {
			this.socialProvider = socialProvider;
			return this;
		}

		public UserRegistrationForm build() {
			return new UserRegistrationForm(providerUserID, firstName, lastName, email, password, companyName,
					companyUrl, socialProvider);
		}
	}
}
