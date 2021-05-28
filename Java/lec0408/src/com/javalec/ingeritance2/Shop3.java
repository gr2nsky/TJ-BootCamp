package com.javalec.ingeritance2;

public class Shop3 extends StoreHQ{
	
	public Shop3() {
		this.name = "체인3";
	}
	
	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 6,000원");
	}
	
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 7,000원");
	}
	
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 7,000원");
	}

	@Override
	public void oderSoon() {
		System.out.println("순대국 : 6,0000원");
	}
	
	@Override
	public void orderBob() {
		System.out.println("공기밥(HQ) : 1,000원");
	}
}
