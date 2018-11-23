package com.oliveirafernando.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static String generate(String password) {
		return encoder.encode(password);
	}

}
