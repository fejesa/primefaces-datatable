package com.foo.service;

import java.util.Locale;
import java.util.Random;

public class RandomString {

	private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final String lower = upper.toLowerCase(Locale.ROOT);

	private static final String digits = "0123456789";

	private static final String alphanum = upper + lower + digits;

	private final Random random;

	private final char[] symbols;

	private final char[] buf;

	public RandomString(int length, Random random) {
		this.random = random;
		this.symbols = alphanum.toCharArray();
		this.buf = new char[length];
	}

	/**
	 * Generate a random string.
	 */
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx) {
			buf[idx] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}
}
