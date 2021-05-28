package com.javalec.exercise;

public class Calc {
	
	int i, j;
	String result;
	
	
	public Calc(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	public String add() {
		result = Integer.toString(i+j);
		return result;
	}
	
	public String sub() {
		result = Integer.toString(i-j);
		return result;
	}
	
	public String mul() {
		result = Integer.toString(i*j);
		return result;
	}
	public String div() {
		if( i == 0 || j == 0)
			result = "0";
		result = Double.toString(i/(j*1.0));
		return result;
	}
	
	public void add(boolean b) {
		System.out.println(i + "+" + j + "=" +add()); 
	}
	
	public void sub(boolean k) {
		System.out.println(i + "-" + j + "=" +sub()); 
	}
	
	public void mul(boolean k) {
		System.out.println(i + "*" + j + "=" +mul()); 
	}
	public void div(boolean k) {
		System.out.println(i + "/" + j + "=" +div()); 
	}
	
	public void gPrint() {
		System.out.println("저장된 결과 : " + result);
	}
	
}

