package com.javalec.inheritance.ex1;

public class ChildMenu extends ParentMenu{

	
	public ChildMenu() {
		
	}
	
	public void makeBeefChung() {
		System.out.println("소고기 청국");
	}
	
	public void makeHotDoen(){
		System.out.println("얼큰 된장");
	}
	
	@Override
	public void makeChung() {
		System.out.println("냄새없는 청국장");
		
	}
}
