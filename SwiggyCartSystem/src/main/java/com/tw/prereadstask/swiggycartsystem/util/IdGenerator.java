package com.tw.prereadstask.swiggycartsystem.util;

public class IdGenerator {
	private static long userId = 1000L;
	private static long cartItemId = 2000L;
	
	public static long getUserId() {
		return userId;
	}
	
	public static void generateUserId() {
		userId += 1;
	}
	
	public static long getCartItemId() {
		return cartItemId;
	}
	
	public static void generateCartItemId() {
		cartItemId += 1;
	}
}
