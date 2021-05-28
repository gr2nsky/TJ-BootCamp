/*
 	작성 : 2021.3.31
 	작성자 : 윤재필
 	기능 : 입력한 숫자의 짝수/홀수를 판별해출력
 	comment: 구체적인 주석, 입력 처리 출력을 구분해 작
 */

package com.javalec.base;

import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		//--선언문--
		Scanner sc = new Scanner(System.in);
		
		ifToSwitch(sc);
		
	}
	
	public static void swicthBasic(Scanner sc) {
		//--선언부--
		int inputNum = 0;
		String result = "";
		
		//--처리--
		System.out.println("숫자를 입력하세요");
		inputNum = sc.nextInt();
		//홀수-짝수 판별
		
		/*//case if
		if (inputNum % 2 == 0) result = "짝수";
		else result = "홀수";
		*/
		
		//case switch - case
		switch (inputNum % 2) {
		case 0:
			result = "홀수";
			break;
		case 1:
			result = "짝수";
			break;
		default:
			result = "에러";
			break;
		}
		
		
		//--출력--
		System.out.println("입력하신 숫자 "+inputNum+"은 "+result+"입니다.");
	}
	
	public static void ifToSwitch(Scanner sc) {
		/*
		 성적을 입력하세요 :90 
		 귀하의 학점은 A학점 입니다.
		 90 : B, 80 : C, 40 : F
			
		 */
		String grade = "";
		
		while(true) {
			
			System.out.print("성적을 입력하세요 : ");
			int input = sc.nextInt();
			
			/*
			//<<case - if >>
			if (input == 0) 
				break;
			if (input > 100 || input < 0) grade = "error";
			else if ( input >= 90)  grade = "A";
			else if (input >= 80) grade = "B";
			else if (input >= 70) grade = "C";
			else grade = "D";
			 */
			
			//<<case - switch >>
			//java switch-case구문은 범위지정이 불가하므로,
			//성적을 10으로 나눠 십의자릿수 단위로 유사범위지정 하였음.
			if( input > 100 || input < 0) 
				grade = "error";
			else {
				switch ( (int)input/10) {
				case 10:
					grade = "A";
					break;
				case 9:
					grade = "A";
					break;
				case 8:
					grade = "B";
					break;
				case 7:
					grade = "C";
					break;
				case 6:
					grade = "D";
					break;
				case 0:
					return;
				default:
					grade = "F";
					break;
				}
			}
			
			if (grade.equals("error")) System.out.println("올바르지 않은 입력입니다.");
			else System.out.println("귀하의 학점은 "+grade+"학점 입니다.");
		}
	}
}
