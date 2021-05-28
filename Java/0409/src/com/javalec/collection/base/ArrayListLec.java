package com.javalec.collection.base;

import java.util.ArrayList;

public class ArrayListLec {
	
	
	public void lec() {
		//선언
		ArrayList<String> arr = new ArrayList<String>();
		
		//불러오기
		System.out.println(arr.get(1));
		//수정하기
		arr.set(1,"str22222");
		System.out.println(arr);
		//크기확인하기
		System.out.println(arr.size());
		//삭제하기
		arr.remove(1);
		System.out.println(arr);
		
	}
}
