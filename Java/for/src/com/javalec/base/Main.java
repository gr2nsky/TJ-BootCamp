/*
 2021.3.31
 윤재필
 for문 수업
 */

package com.javalec.base;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ExpertFor  ex = new ExpertFor(sc);
		ex.exercise_3();
	}
}

class ExpertFor {
	
	Scanner sc;
	
	ExpertFor(Scanner sc){
		this.sc = sc;
	}
	
	void exercise_3() {
		int inputNum = 0;
		
		System.out.println("단을 입력하세요 :");
		inputNum = sc.nextInt();
		
		for(int i = 1; i <=9; i += 3) {
			System.out.println(inputNum + " X " + i + " = "+ (inputNum * 1) + "\t");
			System.out.println(inputNum + " X " + i + " = "+ (inputNum * 2) + "\t");
			System.out.println(inputNum + " X " + i + " = "+ (inputNum * 3) + "\t");
		}
	}
	
	void exercise_2() {
		int startPoint = 0;
		int endPoint = 0;
		int low = 1;
		
		System.out.print("Input your number : ");
		startPoint = sc.nextInt();
		endPoint = startPoint + 3;
		
		for (int i = startPoint; i <= endPoint; i ++) {
			System.out.print(i + " X " + low + " = " + ( i * low ) + "\t");
			
			if ( low < 9 && i == endPoint ) {
				low ++;
				i = startPoint - 1;
				System.out.println();
			}
		}
	}
	
	void expertFor() {
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + " X " + i + " = " + ( j * i ) + "\t");
			}
			System.out.println();
		}
	}
	
}

class Exercise_05 {
	Scanner sc;
	
	Exercise_05(Scanner sc){
		this.sc = sc;
	}
	//입력한 한 자릿수 정수의 합을 구하는 프로그램
	void exercise_05(){
		int inputNum = 0;
		int result = 0;
		
		System.out.print("Enter an integer(0~9) : ");
		inputNum = sc.nextInt();
		//10으로 나눈 나머지값으로 숫자열을 분리해 각각 result에 더한다.
		for (int i = inputNum; i > 0; i /= 10) {
			result += i % 10;
		}
		
		System.out.println("Sum of digits = " + result);
	}
	
}

class Gugu{
	Scanner sc;
	
	Gugu(Scanner sc){
		this.sc = sc;
	}
	//구구단 출력하는데 홀수는 "_"로 출력되도록 
	void gugu() {
		int dan = 0;
		
		System.out.print("원하시는 단을 입력하세요 : ");
		dan = sc.nextInt();
		
		for (int i = 1; i < 10; i ++) {
			System.out.println(dan + " x " + (i % 2 == 0 ? i : "_")
					+ " = " + (dan * i ));
		}
	}
	//for문 중첩해서 구구단 풀 출
	void fullGugu() {
		for (int i = 1; i < 10; i ++) {
			System.out.println("[" + i + "단]");
			for (int j = 1; j < 10; j ++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
		}
	}
	
}


class BaseOfFor {
	Scanner sc;
	
	BaseOfFor(Scanner sc){
		this.sc = sc;
	}
	//for문 기
	void base() {
		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}
	}
	//for문을 이용한 연
	void total() {
		int tot = 0;
	
		for (int i = 1; i < 1001; i++) {
			tot ++;
		}
		
		System.out.println("1부터 1000까지의 합은 "+tot+"입니다.");
	}
	
	//1~100중 짝수의 총합 구하기
	void exercise_1() {
		int tot = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0)
				tot += i;
		}
		System.out.println("1부터 100중 짝수의 총 합은 "+tot+"입니다.");
		
	}
	//1~100중 짝수와 홀수의 합을 각각 구한다.
	void exercise_2() {
		int totEven = 0;
		int totOdd = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0)
				totEven += i;
			else 
				totOdd += i;
		}
		System.out.println("짝수의 합 = " + totEven + "," + "홀수의 합 = " + totOdd);
	}
	//입력한 수의 팩토리얼값을 출력한다.
	void factorial() {
		int input = 0;
		long result = 1;
		
		System.out.print("Input your decimal no. : ");
		
		input = sc.nextInt();
		for (long i = input; i > 1; i--) {
			result *= i;
		}
		
		System.out.println(input+"'s factorial value = " + result);
	}

}
