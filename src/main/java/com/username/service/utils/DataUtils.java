package com.username.service.utils;

import java.util.Random;

public class DataUtils {
	private static String PATTERN_CHARS = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static int EMAIL_SIZE = 10;
	
	
	public static String getEmailUtils(String index, String email) {
		StringBuffer sIndex = new StringBuffer(index);
		for (int i = 0; i < EMAIL_SIZE; i++) {
			sIndex.append(PATTERN_CHARS.charAt(getRandom(PATTERN_CHARS.length())));
		}
		sIndex.append(email);
		return sIndex.toString();
	}
	
	private static int getRandom(int size) {
		return new Random().nextInt(size);
	}

}
