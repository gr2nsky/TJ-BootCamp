package com.javalec.interfacelec.base;

public class CPhone implements SmartPhone{
	
	@Override
	public void callSenderReceiver() {
		// TODO Auto-generated method stub
		System.out.println("C phone : Possible");

	}

	@Override
	public void telMethod() {
		// TODO Auto-generated method stub
		System.out.println("C phone : 4G");
		

	}

	@Override
	public void tvRemoteController() {
		// TODO Auto-generated method stub
		System.out.println("B phone : applied");

	}

}
