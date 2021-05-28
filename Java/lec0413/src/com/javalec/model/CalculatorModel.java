package com.javalec.model;

import com.javalec.exercise.Calculator;

public class CalculatorModel {
	
	Calculator cal;
	CalStack stack = new CalStack();
	
	public void setFrame(Calculator cal) {
		this.cal = cal;
	}
	
	public void inputBtn(String input) {
		if (stack.isEmpty())
			stack.push(input);
	}
}
