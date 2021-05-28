package com.javalec.classlec;

import java.util.Calendar;
import java.util.Scanner;

public class Base {
	
	Scanner sc;
	
	public Base(Scanner sc){
		this.sc = sc;
	}
	
	public void base_3() {
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
	}
	
	//String의 문제점을 해결하기 위해 나온 문자열 선언자들.
	//버퍼보단 빌더가 좀 빠르긴 함
	public void base_2(){
		String string = new String("abcdef");
		
		StringBuilder stringBuilder = new StringBuilder("abcdef");
		stringBuilder.append("hijklmn");
		System.out.println(stringBuilder);
		
		stringBuilder.insert(3, "zzz");
		System.out.println(stringBuilder);

		stringBuilder.delete(3, 6);
		System.out.println(stringBuilder);
		//---------------------------------------------------------------------
		StringBuffer stringBuffer = new StringBuffer("abcdef");
		stringBuffer.append("hijklmn");
		System.out.println(stringBuffer);
		
		stringBuffer.insert(3, "zzz");
		System.out.println(stringBuffer);
		
		stringBuffer.delete(3, 6);
		System.out.println(stringBuffer);
	}
	
	public void base_1() {
		String str1 = "abCdefg";
		String str2 = "hijklmno";
		String str3 = "a  b  d e";
		
		System.out.println(str1.concat(str2));
		System.out.println(str1.substring(3));
		System.out.println(str1.substring(3,5));
		System.out.println(str1.length());
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		System.out.println(str1.charAt(3));
		
		//str 하나씩 출력하기
		for(int i = 0; i < str1.length(); i++) {
			System.out.println(str1.charAt(i));
		}
		
		System.out.println(str1.indexOf('b'));
		System.out.println(str1.equals(str2));
		System.out.println(str3.trim());
		System.out.println(str1.replace('a', 'Z'));
		System.out.println(str1);
		System.out.println(str1.replaceAll("abC", "ZZZZZZZZZZZZ"));
	}
}
