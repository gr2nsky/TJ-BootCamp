package com.javalec.ingeritance2;

public class Shop1 extends StoreHQ{

	public Shop1() {
		this.name = "체인1";
	}

	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 4,500원");
	}
	
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void oderSoon() {
		System.out.println("판매하지 않습니다.");
	}
}
