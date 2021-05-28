package com.javalec.base;

public class Variable_01 {
	public static void main(String[] args) {
		// 변수 (Variable)
		// 문자열 변수 선언
		String str = "Hello, World!";
		
		System.out.println(str);
		System.out.println(str);
		
		str = "abc";
		System.out.println(str);
		
		//
		
		
		
		//----- Exercise
		
		int startNum = 30, endNum = 40;
		
		/*
		 30과 40의 덧셈 결과는 70입니다.
		 30과 40의 뺄셈 결과는 -10입니다.
		 30과 40의 곱셈 결과는 1200입니다.
		 30과 40의 나눗셈 중 몫은 0입니다.
		 30과 40의 나눗셈 결과는 __입니다.
		 30과 40의 덧셈결과와 뺄셈 결과의 곱은 ___  입니다.
		 */
		int result1 = startNum + endNum;
		int result2 = startNum - endNum;
		int result3 = startNum * endNum;
		int result4 = startNum / endNum;
		float result5 = startNum / endNum;
		int result6 = result1 * result2;
		
		
		System.out.println(startNum + "과 " + endNum + "의 덧셈 결과는 " + result1 + "입니다." );
		System.out.println(startNum + "과 " + endNum + "의 뺄셈 결과는 " + result2 + "입니다." );
		System.out.println(startNum + "과 " + endNum + "의 곱셈 결과는 " + result3 + "입니다." );
		System.out.println(startNum + "과 " + endNum + "의 나눗셈 중 몫은 " + result4 + "입니다." );
		System.out.println(startNum + "과 " + endNum + "의 나눗셤 결과는 " + result5 + "입니다." );
		System.out.println(startNum + "과 " + endNum + "의 덧셈결과와 뺄셈결과의 곱은  " + result6 + "입니다." );
	}
}
