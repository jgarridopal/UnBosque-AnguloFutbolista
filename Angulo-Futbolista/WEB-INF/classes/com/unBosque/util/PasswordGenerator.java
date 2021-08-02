package com.unBosque.util;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {

	public static String generateRandomPassword() {
		
		String random;
		
		char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()=+[{]}\\|\'\"<>/?")).toCharArray();
		random = RandomStringUtils.random(10, 0, possibleCharacters.length-1, false, false, possibleCharacters, new SecureRandom() );
		
		return random;
		
	}
	
}
