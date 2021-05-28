package com.javalec.base;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Exercise0405 ex = new Exercise0405(sc);
		
		ex.exercise_10();
		
	}
	

}

class Exercise0405{
	Scanner sc;
	
	Exercise0405(Scanner sc){
		this.sc = sc;
	}
	
	/*
	 * 10개의 정수 (0~99점)을 입력받아
	 * 점수의 분포를 10점 간격으로 된 히스토그램을 표시하라.
	 * [comment]
	 * low data는 유지할 것. 
	 * <<0405 윤재필>>
	 */
	void exercise_10() {
		int[] score = new int[10];
		int[] histogram = new int[10];
		
		//점수를 입력받아 십의자리수와 동일한 숫자의 histogram 인덱스의 정수값을 +1 
		for (int i = 0; i < 10; i++) {
			int grade = 0;
			
			System.out.print((i + 1) + "의 score : ");
			score[i] = sc.nextInt();
			
			grade = score[i] / 10;
			histogram[grade] += 1;
		}
		
		//histogram의 마지막 인덱스부터 해당 인덱스의 정수값만큼 #을 출력한다.
		System.out.println("-------Histogram--------");
		for (int i = 9; i >= 0; i--) {
			System.out.print((i * 10) + " : ");
			System.out.println("#".repeat(histogram[i]));
		}
		
		
	}
}