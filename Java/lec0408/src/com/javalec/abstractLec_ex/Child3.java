package com.javalec.abstractLec_ex;

public class Child3 extends Lunch {

	public Child3(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
	}

	@Override
	public int calc() {
		return rice + bulgogi;
	}
	

}
