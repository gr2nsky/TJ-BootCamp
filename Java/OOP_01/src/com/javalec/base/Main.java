package com.javalec.base;

public class Main {
	public static void main(String[] args) {
		//1~10까지의 합을 구하여 출력하고, 그 합이 짝수인지 홀수인지 판단하라.
		int sum = 0;
		for(int i = 1; i < 11; i ++) {
			sum += i;
		}
		System.out.print(sum+"은 ");
		System.out.println(sum%2==0?"홀수이다.":"짝수이다.");
	}
}
