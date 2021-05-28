package com.javalec.controller;

import com.javalec.modle.DBMS;
import com.javalec.view.AddressInsert;

public class Main {
	
	public static DBMS dbms;
	
	public static void main(String[] args) {
		dbms = new DBMS();
		
		AddressInsert ai = new AddressInsert(dbms);
		ai.setView(dbms);
	}
}