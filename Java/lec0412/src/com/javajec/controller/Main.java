package com.javajec.controller;

import java.util.Scanner;

import com.javalec.base.UseCheckBox01;
import com.javalec.base.UseComboBox01;
import com.javalec.exercise.Exercise01;
import com.javalec.exercise.Exercise02;
import com.javalec.exercise.Exersice03;
import com.javalec.exercise.model02;

public class Main {
	
	public static void main(String[] args) {
		Running r = new Running();
		r.exer_03();

	}
	
	static class Running{
		
		void lec_01() {
			UseComboBox01 useComboBox01 = new UseComboBox01();
			useComboBox01.run();
		}
		
		void lec_02() {
			UseCheckBox01 useCheckBox01 = new UseCheckBox01();
			useCheckBox01.run();
		}
		
		void exer_01( ) {
			Exercise01 ex1 = new Exercise01();
			ex1.run();
		}
		
		void exer_02() {
			Exercise02 ex2 = new Exercise02();
			ex2.run();
		}
		
		void exer_03() {
			Exersice03 ex3 = new Exersice03();
			ex3.run();
		}
	}
}
