/*
 * 2021 04 06 윤재필
 * string, stringbuilder, stringbuffer실행시간 차이 비
 * 
 */

package com.javalec.base;

public class Main {
	public static void main(String[] args) {
		//String과 StringBuilder 측정
		
		String str1 = "a";
		
		long startTimeString = System.currentTimeMillis();
		for (int i = 0; i <= 50000; i++) {
			str1 = str1 + "a";
		}
		long endTimeString = System.currentTimeMillis();
		System.out.println("Term 1:"+(endTimeString - startTimeString));
		
		//---------------------------------------------------------
		
		StringBuilder stringBuilder = new StringBuilder("a");
		
		long startTimeBuilder = System.currentTimeMillis();
		for (int i = 0; i <= 50000; i++) {
			stringBuilder.append("a");
		}
		long endTimeBuilder = System.currentTimeMillis();
		System.out.println("Term 2:"+(endTimeBuilder - startTimeBuilder));
		
		//---------------------------------------------------------

		StringBuffer stringBuffer = new StringBuffer("a");
		
		long startTimeBuffer = System.currentTimeMillis();
		for (int i = 0; i <= 50000; i++) {
			stringBuffer.append("a");
		}
		long endTimeBuvver= System.currentTimeMillis();
		System.out.println("Term 3:"+(endTimeBuvver - startTimeBuffer));
	}
}
