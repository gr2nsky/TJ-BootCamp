package com.javalec.ingeritance2;

public class StoreHQ {
	
	String name = "본사";
	
	public void orderKim() {
		System.out.println("김치찌개(HQ) : 5,000원");
	}
	
	public void orderBu() {
		System.out.println("부대찌개(HQ) : 6,000원");
	}
	
	public void orderBi() {
		System.out.println("비빔밥(HQ) : 6,000원");
	}

	public void oderSoon() {
		System.out.println("순대국(HQ) : 5,0000원");
	}
	
	public void orderBob() {
		System.out.println("공기밥(HQ) : 1,000원");
	}
	
	public void print() {
		System.out.println("----------- "+ name + " --------------");
		orderKim();
		orderBu();
		orderBi();
		oderSoon();
		orderBob();
	}
	
}
