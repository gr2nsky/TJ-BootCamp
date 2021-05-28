package com.javalec.clac;

import java.util.Scanner;

public class calc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		cal3(sc);
		

	}
	
	public static void cal3(Scanner sc) {
		while(true) {
			int inputNum;
			
			while (true) {
				System.out.print("숫자를 입력해 주세요 :");
				inputNum = sc.nextInt();
				if (inputNum == 0)
					return;
				
				System.out.println(inputNum % 2 == 0 ? "2의 배수" : inputNum % 3 == 0 ? "3의 배수" :"모올라");
				
			}

		}
	}
	
	public static void cal2(Scanner sc) {
		while(true) {
			int inputNum;
			int divNum = 3;
			
			while (true) {
				System.out.print("숫자를 입력해 주세요 :");
				inputNum = sc.nextInt();
				if (inputNum == 0)
					return;
				
				System.out.print("입력하신 숫자는 " + divNum +"의 배수 ");
				System.out.println(inputNum % divNum == 0?"입니다":"아닙니다");
				
			}

		}
	}

	public static void cal1(Scanner sc) {
		while(true) {
			int inputNum = sc.nextInt();
			
			if (inputNum == 0)
				return;
			
			
			System.out.println(inputNum % 2 == 0? "짝수" : "홀수");
		}
	}
	
}
