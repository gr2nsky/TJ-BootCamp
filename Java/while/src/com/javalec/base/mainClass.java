package com.javalec.base;

import java.util.Scanner;

public class mainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Exersise ex = new Exersise(sc);
		ex.ex_2();
	}

}


class Exersise{
	Scanner sc;
	
	Exersise(Scanner sc){
		this.sc = sc;
	}
	
	void ex_2() {
		//더하기 할 숫자들의 개수를 정한 후
		//숫자를 입력받아 입력한 숫자의 합을 구하는 프로그램
		int numOfNum = 0;
		int sum = 0;
		
		System.out.print("몇개의 숫자를 더할까요? :");
		numOfNum = sc.nextInt();
		System.out.println(numOfNum+ "개의 숫자를 입력하세요.");
		while (numOfNum > 0) {
			sum += sc.nextInt();
			numOfNum -= 1;
		}
		
		System.out.println("입력한 숫자의 합은 +" + sum + "입니다.");
	}
	
	void ex_1() {
		int inputNum;
		int sum = 0;
		
		System.out.print("Enter an integer :");
		inputNum = sc.nextInt();
		
		while(inputNum != 0) {
			sum += inputNum % 10;
			inputNum /= 10;
		}
		
		System.out.println(sum);
	}
	
	
}