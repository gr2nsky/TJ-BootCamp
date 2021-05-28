package com.javalec.exercise2;

public class Gugudan {
	int floor;

	public Gugudan(int floor) {
		super();
		this.floor = floor;
	}


	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.println( floor + " X " + i + " = " + (i * floor));
		}
	}
	
	public void run2() {
		for (int i = 1; i < 10; i++) {
			System.out.println( floor + " X " + (i%2==0?"*":Integer.toString(i)) + " = " + (i * floor));
		}
	}
}
