package com.javalec.funtion;

public class SumEvenOdd2 {
	//property
	int num1;
	int num2;
	int sum;
	
	//constructor
	public SumEvenOdd2(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		this.sum = 0;
	}
	
	//Method
	public void sumCalc() {
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.println(num1 + " ~ " + num2 + "의 합은 " + sum + "입니다.");
	}
	
	public void evenOdd() {
		String chk = "";
		if (sum%2 == 0)
			chk = "짝수";
		else
			chk = "홀수";
		
		System.out.println(chk + "입니다.");
	}
}
