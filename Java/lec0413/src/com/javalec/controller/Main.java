/*
 * 0413 수업
 * 스윙 마지막 수업
 */


package com.javalec.controller;

import com.javalec.base.MainPage;
import com.javalec.base.Menu2;
import com.javalec.base.PasswordField;
import com.javalec.exercise.Calculator;
import com.javalec.exercise.LoginEx;
import com.javalec.exercise.SemiLogin;

public class Main {
	public static void main(String[] args) {
		Running r = new Running();
		r.ex_02();
	}
	
	
	static class Running{
		//패스워드 필드의 사용법 로그인 검
		void lec_01() {
			PasswordField pf = new PasswordField();
			pf.run();
		}
		//상단 메뉴바 만들기
		void lec_02() {
			Menu2 m2 = new Menu2();
			m2.run();	
		}
		//다른 패널 띄우기
		void lec_03(){
			MainPage mp = new MainPage();
			mp.run();
		}
		//로그인 작업
		void ex_01() {
			SemiLogin sl = new SemiLogin();
			sl.run();
		}
		//계산기 만들어보기 (add연산만)
		void ex_02() {
			Calculator cc = new Calculator();
			cc.run();
		}
		//로그인 작업 - 새 패널까지 띄우
		void ex_03() {
			LoginEx le = new LoginEx();
			le.run();
		}
	}
}
