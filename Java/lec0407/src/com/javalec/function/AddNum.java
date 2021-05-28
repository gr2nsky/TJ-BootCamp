package com.javalec.function;

public class AddNum {
	
	int num1, num2;
	
	public AddNum() {
		
	}
	
	
	public AddNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public int addAction(int i, int j) {
		int addResult = i + j;
		return addResult;
	}
	
	public void addPrinf(int i, int j) {
		System.out.println(i + j);
	}
	
	public int addAction() {
		int addResult = num1 + num2;
		return addResult;
	}
	
	public void addPrinf() {
		System.out.println(num1 + num2);
	}
}
