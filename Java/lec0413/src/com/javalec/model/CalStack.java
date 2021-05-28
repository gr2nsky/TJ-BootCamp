package com.javalec.model;

import java.util.ArrayList;

public class CalStack {
	
	ArrayList<String> stack;
	
	public CalStack(){
		stack = new ArrayList<String>();
	}
	
	
	public void push(String input) {
		stack.add(input);
	}
	
;
	
	public String peek() {
		if( isEmpty() ) {
			return "null";
		}
		String pop = stack.get(stack.size() - 1);
		return pop;
	}
	
	public int size() {
		return stack.size();	
	}
	
	public void removeAll() {
		stack.clear();
	}
	
	public String returnAll() {
		String result = "";
		for (String s : stack)
			result += s;
		return result;
	}
	
	boolean isEmpty() {
		return stack.isEmpty();
	}
	
	

}
