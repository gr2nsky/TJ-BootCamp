package com.javalec.ingeritance2;

public class Shop2 extends StoreHQ{
	
	public Shop2() {
		this.name = "체인2";
	}

	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 5,000원");
	}

	@Override
	public void oderSoon() {
		System.out.println("순대국 : 4,0000원");
	}
	
	@Override
	public void orderBob() {
		System.out.println("공기밥 : 무료입니다.");
	}
	
}
