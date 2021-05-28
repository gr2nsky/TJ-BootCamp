package com.javalec.collection.exercise;

import java.util.ArrayList;

public class ArrayListEx {
	
	public void lec() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int sum = 0;
		
		for (int i = 2; i <=100; i++)
			if (i % 2 == 0)
				arr.add(i);
		
		for (int i : arr)
			sum += i;
		
		System.out.println(sum);
	}
}
