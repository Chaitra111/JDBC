package com.bridgelabz.JdbcPwdCheck;

import java.util.regex.Pattern;

public class ValidPwd {

	public static boolean is_Valid_Password(String password) {

		final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

		final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

		// Validate an password
		if (PASSWORD_PATTERN.matcher(password).matches()) {
			return true;
		}
		else {
			return false;
		}
	}
}