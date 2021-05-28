package com.javalec.base;

import java.util.Scanner;

import com.javalec.exercis4.Gagam;
import com.javalec.exercise.Add;
import com.javalec.exercise.Calc;
import com.javalec.exercise.Div;
import com.javalec.exercise.Mul;
import com.javalec.exercise.Sub;
import com.javalec.exercise2.Gugudan;
import com.javalec.exercise3.Sumsum;
import com.javalec.function.AddNum;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Running running = new Running(sc);
		running.exercise_4();
	}	
	

}

class Running{
	
	Scanner sc;
	
	public Running(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	void exercise_4() {
		Gagam gagam;
		int num1 = 0, num2 = 0;
		
		System.out.println("첫번째 숫자를 입력하세요.");
		num1 = sc.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		num2 = sc.nextInt();
		
		gagam = new Gagam(num1, num2);
		gagam.run();
	}
	
	void exercise_3() {
		int input;
		int result;
		System.out.print("Enter an integer(0~9) : ");
		input = sc.nextInt();
		
		Sumsum ss = new Sumsum(input);
		result = ss.run();
		System.out.println("Sum of digits = " + result);
		
	}

	void exercise_2() {
		int floor = 0;
		System.out.print("구구단을 출력할 숫자를 입력하세요:");
		floor = sc.nextInt();
		
		Gugudan gu = new Gugudan(floor);
		gu.run2();
		
		
	}
	
	void exercise_1_1() {
		int i = 0;
		int j = 0;
		Calc cal;
		
		
		while(true) {
			i = sc.nextInt();
			j = sc.nextInt();
			
			cal = new Calc(i, j);
			cal.add(true);
			cal.sub(true);
			cal.mul(true);
			cal.div(true);
			
			cal.gPrint();
		}
		
	}
	
	 static void exercise(){
		Add ad = new Add();
		Sub su = new Sub();
		Mul mu = new Mul();
		Div di = new Div();
		Scanner sc = new Scanner(System.in);
		int i, j;
		
		i = sc.nextInt();
		j = sc.nextInt();
		
		System.out.println("i + j : " + ad.add(i ,j));
		System.out.println("i - j : " + su.sub(i, j));
		System.out.println("i * j : " + mu.mul(i, j));
		System.out.println("i / j : " + di.div(i, j));
		
	}
	
	static void lec() {
		AddNum an = new AddNum();
		int num1 = 10, num2 = 20;
		
		int resultNum = an.addAction(num1, num2);
		System.out.println(resultNum);
		
		an.addPrinf(num1, num2);
		
		num1 = 30;
		num2 = 40;
		
		//Constructor로 호출
		AddNum an2 = new AddNum(num1, num2);
		System.out.println(an2.addAction());
		an2.addPrinf();
	}
}
