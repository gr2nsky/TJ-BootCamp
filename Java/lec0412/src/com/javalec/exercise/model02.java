/*
 * 0412 윤재필 
 * 아이에 새 클래스를 생성해서 진행하려고 했는데
 * 구조적 생각이 부족해서 아이에 펑크가 나버렸다.
 */

package com.javalec.exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class model02 implements ActionListener {
	
	Exercise02 view;
	int num1 = 0;
	int num2 = 0;
	String operator = "";
	ArrayList<JRadioButton> radioArr = new ArrayList<JRadioButton>();
	
	public model02(Exercise02 view) {
		this.view = view;
		radioArr.add(view.rdbtnSUB);
		radioArr.add(view.rdbtnADD);
		radioArr.add(view.rdbtnMUL);
		radioArr.add(view.rdbtnDIV);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		num1 = Integer.parseInt(view.tfNum1.getText());
		num1 = Integer.parseInt(view.tfNum2.getText());
		
		turnOn(e);
		operator = setOperator(e);
		calc();
	}
	
	public String setOperator(ActionEvent e) {
		for (JRadioButton rb : radioArr) {
			if (e.getSource() == rb) {
				return rb.getText();
			}
		}
		return "";
	}
	
	public void turnOn(ActionEvent e) {
		for (JRadioButton rb : radioArr) {
			if (e.getSource() == rb && rb.isSelected() == true) {
				rb.setSelected(true);
			} else {
				rb.setSelected(false);
			}
		}
	}
	
	public void calc() {
		int result = 0;
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "x":
			result = num1 * num2;
			break;
		case "/":
			double doubleResult = num1 / (num2 * 1.0);
			doubleResult = Math.round(doubleResult*1000)/1000.0;
			view.lblResult.setText(Double.toString(doubleResult));
			return;
		default:
			break;
		}
		view.lblResult.setText(Integer.toString(result));
	}
	
}