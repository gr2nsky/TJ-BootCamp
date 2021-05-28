package com.javalec.base;

public class Main {
	public static void main(String[] args) {
		int num = 123;
		String str1 = "12345";
		String str2 = "abcde";
		
		String str3 = Integer.toString(num); // int to String
		System.out.println(str3 + str1);
		
		int num2 = Integer.parseInt(str1);
		System.out.println(num + num2);
	}
}
