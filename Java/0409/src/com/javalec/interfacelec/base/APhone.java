package com.javalec.interfacelec.base;

public class APhone implements SmartPhone {

	@Override
	public void callSenderReceiver() {
		// TODO Auto-generated method stub
		System.out.println("A phone : Possible");

	}

	@Override
	public void telMethod() {
		// TODO Auto-generated method stub
		System.out.println("A phone : 3G");
		

	}

	@Override
	public void tvRemoteController() {
		// TODO Auto-generated method stub
		System.out.println("A phone : Not applied");

	}

}
