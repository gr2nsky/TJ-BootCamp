package com.javalec.staticLec;

public class SecondSon {
	public void takeChoco() {
//		Mamabag mamaBag = new Mamabag();
//		mamaBag.choco -= 1;
		Mamabag.choco -= 1;
		if(Mamabag.choco < 0) {
			System.out.println("둘째는 초코파이 먹고 싶어요");
		} else {
			System.out.println("둘째는 맛있게 먹었어");
		}
	}
}
