package com.javalec.base;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = {"가위", "바위", "보"};
		int win = 0;
		int lose = 0;
		
		while(true) {
			int ran = 0;
			int choose = 0;
			int result = 0; //0비김 1승리 2패배 
			System.out.println("-----------------------------------------------");
			System.out.println("1. 가위  2. 바위   3. 보 중 하나를 입력하세요 [종료:0]");
			choose = sc.nextInt();
			if (choose == 0)
				break;
			
			ran = (int)((Math.random()*3)+1);
			switch (choose) {
			case 1: {
				if (ran == 3) 
					result = 1;
				else if (ran == 2) 
					result = 2;
			break;
			}
			case 2: {
				if (ran == 3) 
					result = 1;
				else if (ran == 3) 
					result = 2;
				break;
			}
			case 3: {
				if (ran == 2) 
					result = 1;
				else if (ran == 1) 
					result = 2;
				break;
			}
			}
			
			System.out.println("당신은 " + names[choose - 1] + "를 냈습니다.");
			System.out.print("컴퓨터는 " + names[ran - 1] + "를 냈습니다.\n결과 : ");
			System.out.println(result ==1?"승리":result ==2?"패배":"비김");
		}
	}
}
