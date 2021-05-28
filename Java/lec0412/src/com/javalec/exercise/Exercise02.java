/*
 *0412윤재필 - 라디오 버튼을 사용한 사칙연
 *combo박스를 단순히 design탭에서 추가했을시, buttonGroup가 생성이 되지 않아
 *직접 생성해 그룹을 묶어줘야 했다.
 */

package com.javalec.exercise;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise02 {

	JFrame frame;
	private JTextField tfNum1;
	private JTextField tfNum2;
	ButtonGroup radioGroup;
	JRadioButton rdbtnSUB;
	JRadioButton rdbtnADD;
	JRadioButton rdbtnMUL;
	JRadioButton rdbtnDIV;
	JLabel lblResult;
	static model02 model;
	
	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise02 window = new Exercise02();
					model = new model02(window);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exercise02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(6, 6, 130, 26);
		frame.getContentPane().add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(6, 44, 130, 26);
		frame.getContentPane().add(tfNum2);
		tfNum2.setColumns(10);
		
		radioGroup = new ButtonGroup();
		
		rdbtnSUB = new JRadioButton("-");
		//rdbtnSUB.addActionListener(model);
		rdbtnSUB.addActionListener(new calc());
		rdbtnSUB.setBounds(221, 32, 141, 23);
		frame.getContentPane().add(rdbtnSUB);
		
		rdbtnADD = new JRadioButton("+");
		//rdbtnADD.addActionListener(model);
		rdbtnADD.addActionListener(new calc());
		rdbtnADD.setBounds(221, 7, 141, 23);
		frame.getContentPane().add(rdbtnADD);
		
		rdbtnMUL = new JRadioButton("x");
		//rdbtnMUL.addActionListener(model);
		rdbtnMUL.addActionListener(new calc());
		rdbtnMUL.setBounds(221, 56, 141, 23);
		frame.getContentPane().add(rdbtnMUL);
		
		rdbtnDIV = new JRadioButton("/");
		//rdbtnDIV.addActionListener(model);
		rdbtnDIV.addActionListener(new calc());
		rdbtnDIV.setBounds(221, 81, 141, 23);
		frame.getContentPane().add(rdbtnDIV);
		
		lblResult = new JLabel("0");
		lblResult.setBounds(18, 181, 426, 31);
		frame.getContentPane().add(lblResult);
		
		radioGroup.add(rdbtnADD);
		radioGroup.add(rdbtnSUB);
		radioGroup.add(rdbtnMUL);
		radioGroup.add(rdbtnDIV);
	}
	
	class calc implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int x = Integer.parseInt(tfNum1.getText()); 
			int y = Integer.parseInt(tfNum2.getText()); 
			String operator = "";
			int result = 0;
			
			if (e.getSource() == rdbtnADD) {
				operator = "+";
				result = x + y;
			}else if (e.getSource() == rdbtnSUB) {
				operator = "-";
				result = x - y;
			}else if (e.getSource() == rdbtnMUL) {
				operator = "x";
				result = x * y;
			}else {
				operator = "/";
				double doubleResult = x / (y * 1.0);
				doubleResult = Math.round(doubleResult*1000)/1000.0;
				lblResult.setText(x + operator + y + " = " +
						Double.toString(doubleResult));
				return;
			}
			lblResult.setText(x + operator + y + " = " +
					Integer.toString(result));
		}
		
	}
	
}
