package com.javalec.variable_3;

public class variable_3 {
	public static void main(String[] args) {
		int i = 10;
		int j = 2, k = 5;
		
		System.out.println("<-- 산술 연산자 -->");
		System.out.println("덧셈:" + i + " + " + j + " = " + (i + j));
		System.out.println("뺄셈:" + i + " - " + j + " = " + (i - j));
		System.out.println("곱셈:" + i + " * " + j + " = " + (i * j));
		System.out.println("나눈 몫:" + i + " / " + j + " = " + (i / j));
		System.out.println("나눈 나머지:" + i + " % " + j + " = " + (i % j));
		
		
		System.out.println("<-- 자동 증감 연산자 -->");
		i = i + 1;
		i += 1;
		i ++;
		System.out.println(i);
		j = j - 1;
		j -= 1;
		j --;
		System.out.println(j);
		
		System.out.println("<-- 동등 비교 관계 연산자 -->");
		System.out.println(" i == j :" + (i == j));
		System.out.println(" i != j :" + (i != j));
		System.out.println(" i > j :" + (i > j));
		System.out.println(" i < j :" + (i < j));
		System.out.println(" i <= j :" + (i < j));
		System.out.println(" i >=j :" + (i < j));
		
		System.out.println("<-- 동등 관계 연산자 -->");
		System.out.println((i > j) || (i > k));
		System.out.println((i > j) && (i > k));
		
		
		System.out.println("<-- 삼항 연산자 -->");
		System.out.println(k == 5 ? "k==5" : "k=5 아님");
		
		//exercise : i가 홀수인지 아닌지
		System.out.println(i % 2 == 1 ? "홀수" : "짝수");
	}
}
