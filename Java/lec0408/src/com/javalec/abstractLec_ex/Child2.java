package com.javalec.abstractLec_ex;

public class Child2 extends Lunch{

	public Child2(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
	}

	@Override
	public int calc() {
		return rice + bulgogi + milk + almond;
	}

}
