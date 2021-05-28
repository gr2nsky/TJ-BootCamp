/*
 * 2021 04 06 윤재필
 * 강의내용대로 프로그램 작 
 */

package com.javalec.array;

import java.util.Scanner;

import com.javalec.classlec.Base;

public class MainClass {
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String agrs[]) {
		Exercise ex = new Exercise(sc);
		Base base = new Base(sc);
		base.base_2();
		
	}
}

class Exercise{
	Scanner sc;
	Exercise(Scanner sc){
		this.sc= sc;
	}
	
	//고객의 입/출금현황을 관리하는 프로그램(고객은 1,2,3,4,5)
	void exercise_14() {
		int[] customer = new int[5];
		
		while(true) {
			System.out.println("1.입금\n2.출금\n3.현황\n4.종료");
			System.out.print("번호를 선택하세요! :");
			int choose = sc.nextInt();
			
			if (choose == 4)
				break;
			
			switch (choose) {
			case 1: {
				int inputCustomer = 0;
				
				System.out.print("고객 번호 : ");
				inputCustomer = sc.nextInt() - 1;
				System.out.print("금액 : ");
				customer[inputCustomer] += sc.nextInt();
				
				System.out.println("입금결과 : 고객번호 : " + (inputCustomer + 1) + " 잔액 " + customer[inputCustomer]);
				System.out.println("--------------------------------------------------");
				break;
			}
			case 2: {
				int inputCustomer = 0;
				int inputMoney = 0;
				
				System.out.print("고객 번호 : ");
				inputCustomer = sc.nextInt() - 1;
				System.out.print("금액 : ");
				inputMoney = sc.nextInt();
				if (customer[inputCustomer] < inputMoney) {
					System.out.println("잔액이 모자랍니다!");
				} else {
					customer[inputCustomer] -= inputMoney;
				}
				System.out.println("--------------------------------------------------");
				break;
			}
			case 3: {
				System.out.println("\t\t 고객명 \t 잔액");
				System.out.println("\t\t ---- \t ---");
			
				for (int i = 0; i < customer.length; i++) {
					System.out.printf("\t\t%d \t %-3d\n", i+1, customer[i]);
				}
				System.out.println("--------------------------------------------------");
				break;
			}
			
			default:
				System.out.println("잘못된 입력입니다.");
			}
			
		}
		System.out.println(">>>> Thank you <<<<");
	}
	
	
	
	
	
	
	
	
	
	
	
}