package com.jacalec.base;

import java.util.Scanner;

public class practiceIf_1 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BMICalculation(sc);

	}
	
	public static void BMICalculation(Scanner sc) {
		
		double height;
		double weight;
		double bmi;
		String bmiType = "";
		
		System.out.println("키를 입력해 주세요.");
		height = sc.nextInt();
		System.out.println("몸무게를 입력해 주세요.");
		weight = sc.nextInt();
		
		//산출된 값이 18.5 이하면 저체중, 18.5~23은 정상, 23~25는 과체중, 25~30은 비만, 30이상은 고도비만
		bmi = (weight / (height * height))*10000;
		bmi = Math.round(bmi*10)/10.0;
		
		if (bmi < 0 && bmi > 100 ) bmiType = "error";
		else if (bmi < 18.5) bmiType = "저체중";
		else if (bmi < 23) bmiType = "정상";
		else if (bmi < 25) bmiType = "과체중";
		else if (bmi < 30) bmiType = "비만";
		else bmiType = "고도비만";
		
		if (bmiType.equals("error")) System.out.println("잘못된 입력입니다.");
		else System.out.println("당신의 BMI지수는 "+bmi+"이고, "+bmiType+"입니다.");
		
		
	}
	
	public static void pracIf4(Scanner sc) {
		
		int[] scores = new int[3];
		String[] subject = { "국어", "영어", "수학" };
		double mean = 0;
		
		while(true) {
			for (int i = 0; i < 3; i++){
				System.out.println(subject[i] + " 점수를 입력하세요.");
				scores[i] = sc.nextInt();
				mean += scores[i];
			}
			
			mean /= 3;
			
			for (int i = 0; i < 3; i++) {
				System.out.print(subject[i] + " 점수는 평균");
				if (scores[i] > mean) System.out.println("보다 높습니다.");
				else if (scores[i] < mean) System.out.println("보다 낮습니다.");
				else System.out.println("점수 입니다.");
			}
			System.out.println("------------------------------");
		}
		
	}
	
	public static void pracIf3(Scanner sc) {
		/*
		 성적을 입력하세요 :90 
		 귀하의 학점은 A학점 입니다.
		 90 : B, 80 : C, 40 : F
			
		 */
		String grade = "";
		
		while(true) {
			
			System.out.print("성적을 입력하세요 : ");
			int input = sc.nextInt();
			
			if (input == 0) 
				break;
			/*
			if (input > 100 || input < 0) {
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			*/
			if (input > 100 || input < 0) grade = "error";
			else if ( input >= 90)  grade = "A";
			else if (input >= 80) grade = "B";
			else if (input >= 70) grade = "C";
			else grade = "D";
			
			if (grade.equals("error")) System.out.println("올바르지 않은 입력입니다.");
			else System.out.println("귀하의 학점은 "+grade+"학점 입니다.");
		}
		
	}
	
	public static void pracIf2() {
		int price = 5000;
		
		if( price > 8000 ) {
			System.out.println("너무 비쌉니다");
		} else if (price > 5000) {
			System.out.println("조금 비싼편입니다.");			
		}else if (price > 3000) {
			System.out.println("적당한 금액 입니다.");
		}else {
			System.out.println("싼편 입니다.");			
		}
		System.out.println("구매 하시겠습니까?");	
	}
	
	public static void pracIf1() {
		int i = 10;
		int j = 20;
		int k = 10;
		// if #1
		
		
		// if #2
		if (i > j) {
			System.out.println("i는 j보다"+ (i-j) +" 만큼 큽니다.");
		} else if (i < j) {
			System.out.println("j는 i보다"+ (j-i) +" 만큼 큽니다.");
		} else {
			System.out.println("i와 j는 같습니다.");
		}
		
		System.out.println(">>> End <<<");
	}

}
