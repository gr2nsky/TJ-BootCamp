package com.javalec.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.javalec.collection.base.HashMapLec;
import com.javalec.collection.base.Student;
import com.javalec.collection.exercise.ArrayListEx;
import com.javalec.interfacelec.base.APhone;
import com.javalec.interfacelec.base.BPhone;
import com.javalec.interfacelec.base.CPhone;
import com.javalec.interfacelec.base.SmartPhone;

public class Main {
	public static void main(String[] args) {
		
		Running run = new Running();
		run.hashMapLec();
		
	}
}

class Running {
	Scanner sc = new Scanner(System.in);
	
	void hashMapLec() {
		HashMapLec hml = new HashMapLec();
		hml.lec();
	}
	
	void coolection_lec02() {
		ArrayList<Student> arr = new ArrayList<Student>();
		
		arr.add(new Student("James", 100));
		arr.add(new Student("Roberts", 90));
		arr.add(new Student("Cathy", 95));
		
		for(Student s : arr)
			System.out.println(s.getName() + " : " + s.getScore());
	}
	
	void arrayListLec() {
		ArrayListEx alb = new ArrayListEx();
		alb.lec();
	}
	
	void exercise_1() {
		ArrayListEx ale = new ArrayListEx();
		
		ale.lec();
	}
	
	void interfaceLec() {
		
		SmartPhone aPhone = new APhone();
		SmartPhone bPhone = new BPhone();
		SmartPhone cPhone = new CPhone();
		
		SmartPhone[] smartPhones = {aPhone, bPhone, cPhone};
		for (SmartPhone phone :smartPhones) {
			phone.callSenderReceiver();
			phone.telMethod();
			phone.tvRemoteController();
			System.out.println("--------------------------");
		}
	}
}
