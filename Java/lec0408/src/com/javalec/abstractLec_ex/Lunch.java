package com.javalec.abstractLec_ex;

public abstract class Lunch {
	
	public int rice;
	public int bulgogi;
	public int banana;
	public int milk;
	public int almond;
	
	public Lunch(int rice, int bulgogi, int banana, int milk, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.banana = banana;
		this.milk = milk;
		this.almond = almond;
	}
	

	public abstract int calc();
	
	
}
