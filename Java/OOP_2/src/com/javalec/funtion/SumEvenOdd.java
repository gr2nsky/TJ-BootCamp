package com.javalec.funtion;

public class SumEvenOdd {
	//property
	
	//constructor
	public SumEvenOdd() {
		
	}
	
	//Method
	public int sumCalc(int num1, int num2) {
		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		return sum;
	}
	
	public String evenOdd(int num) {
		if (num%2 == 0)
			return "짝수";
		else
			return "홀수";
	}
}
