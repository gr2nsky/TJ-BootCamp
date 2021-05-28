package com.javalec.collection.base;

import java.util.HashMap;

public class HashMapLec {
	public void lec() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(0, "str0");
		hashMap.put(1, "str1");
		hashMap.put(2, "str2");
		hashMap.put(3, "str3");
		
		System.out.println(hashMap); //{0=str0}
		
		System.out.println(hashMap.get(1));
	}
}
