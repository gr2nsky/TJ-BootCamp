package com.javalec.base;

import com.javalec.funtion.SumEvenOdd;
import com.javalec.funtion.SumEvenOdd2;

public class Main {
	public static void main(String[] args) {
		int i = 1, j = 10;
		
//		SumEvenOdd so = new SumEvenOdd();
//		int sum = so.sumCalc(i, j);
//		String chk = so.evenOdd(sum);
//		
//		System.out.println(i + " ~ " + j + "의 합은 " + sum + "입니다.");
//		System.out.println(chk+"입니다.");
//	
		
		SumEvenOdd2 so2 = new SumEvenOdd2(i, j);
		so2.sumCalc();
		so2.evenOdd();
	}
	
}
