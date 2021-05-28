package com.javalec.exercis4;

public class Gagam {
	//두개의 정수를 입력받아 가감승제를 출력하는 프로그램.
	
	int num1;
	int num2;
	
	public Gagam(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public void run() {
		double[] arr = new double[4];
		int result = 0;
		double result2 = 0;

		arr[0] = num1 + num2;
		arr[1] = num1 - num2;
		arr[2] = num1 * num2;
		if (num1 == 0 || num2 == 0 ) {
			arr[3] = 0;
		} else {
			arr[3] = num1 / (num2 * 1.0);
		}
		
		print(arr);
	}
	
	public void print(double[] result) {
		String[] arr = { "덧셈", "뺄셈", "곱셈", "나눗셈" };
		
		System.out.println(">>>>>>>> 결과 <<<<<<<");
		for(int i = 0; i < 4; i++) {
			System.out.print(arr[i] + " : ");
			if( i != 3) {
				System.out.println(Math.round(result[i]));
			} else {
				System.out.println(result[i]);
			}
		}
	}
}
