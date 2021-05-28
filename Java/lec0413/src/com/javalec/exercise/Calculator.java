package com.javalec.exercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.javalec.model.CalculatorModel;

public class Calculator {

	private JFrame frame;
	private JButton btn0;
	private JButton btnResult;
	private JButton btnSum;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JTextField rfResult;
	private JButton btnClear;
	//static CalculatorModel cm;
	String result = "";

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					//cm.setFrame(window);
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//cm = new CalculatorModel();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtn0());
		frame.getContentPane().add(getBtnResult());
		frame.getContentPane().add(getBtnSum());
		frame.getContentPane().add(getBtn1());
		frame.getContentPane().add(getBtn2());
		frame.getContentPane().add(getBtn3());
		frame.getContentPane().add(getBtn4());
		frame.getContentPane().add(getBtn5());
		frame.getContentPane().add(getBtn6());
		frame.getContentPane().add(getBtn7());
		frame.getContentPane().add(getBtn8());
		frame.getContentPane().add(getBtn9());
		frame.getContentPane().add(getRfResult());
		frame.getContentPane().add(getBtnClear());
	}
	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton("0");
			btn0.addActionListener(new numBtnAction());
			btn0.setBounds(102, 226, 55, 29);
		}
		return btn0;
	}
	private JButton getBtnResult() {
		if (btnResult == null) {
			btnResult = new JButton("=");
			btnResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calResult();
				}
			});
			btnResult.setBounds(169, 226, 55, 29);
		}
		return btnResult;
	}
	private JButton getBtnSum() {
		if (btnSum == null) {
			btnSum = new JButton("+");
			btnSum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sumBtn();
				}
			});
			btnSum.setBounds(236, 226, 55, 29);
			
//			btnSum.addActionListener(new numBtnAction());
//			buttons.add(btnSum);
		}
		return btnSum;
	}
	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("1");
			btn1.setBounds(102, 185, 55, 29);
			btn1.addActionListener(new numBtnAction());
		}
		return btn1;
	}
	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("2");
			btn2.setBounds(169, 185, 55, 29);
			btn2.addActionListener(new numBtnAction());
		}
		return btn2;
	}
	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("3");
			btn3.setBounds(236, 185, 55, 29);
			btn3.addActionListener(new numBtnAction());
		}
		return btn3;
	}
	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("4");
			btn4.setBounds(102, 144, 55, 29);
			btn4.addActionListener(new numBtnAction());
		}
		return btn4;
	}
	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton("5");
			btn5.setBounds(169, 144, 55, 29);
			btn5.addActionListener(new numBtnAction());
		}
		return btn5;
	}
	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton("6");
			btn6.setBounds(236, 144, 55, 29);
			btn6.addActionListener(new numBtnAction());
		}
		return btn6;
	}
	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton("7");
			btn7.setBounds(102, 103, 55, 29);
			btn7.addActionListener(new numBtnAction());
		}
		return btn7;
	}
	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton("8");
			btn8.setBounds(169, 103, 55, 29);
			btn8.addActionListener(new numBtnAction());
		}
		return btn8;
	}
	private JButton getBtn9() {
		if (btn9 == null) {
			btn9 = new JButton("9");
			btn9.setBounds(236, 103, 55, 29);
			btn9.addActionListener(new numBtnAction());
		}
		return btn9;
	}
	private JTextField getRfResult() {
		if (rfResult == null) {
			rfResult = new JTextField();
			rfResult.setBounds(108, 6, 183, 85);
			rfResult.setColumns(10);
			rfResult.setText("0");
		}
		return rfResult;
	}
	

	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("c");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					result = "0";
					printResult();
				}
			});
			btnClear.setBounds(303, 226, 55, 29);
		}
		return btnClear;
	}
	
	void printResult() {
		rfResult.setText(result);
		System.out.println(result);
	}
	
	void sumBtn() {
		String[] s = result.split("");
		if (result.equals("") || s[s.length-1].equals("+") ){
			JOptionPane.showMessageDialog(null, "유효하지 않은 입력입니다.");
		}
		else {
			result += "+";
			printResult();
		}
	}
	
	void calResult() {
		int tot = 0;
		String temp = "";
		int size = 0;
		
		String[] chars = result.split("");
		size = chars.length - 1;
		
		if (chars[chars.length-1].equals("+")){
			size -= 1;
		}
		
		for (int i = 0; i <= size; i++) {
			System.out.println(chars[i]);
			if(!chars[i].equals("+")) {
				temp += chars[i];
			} else {
				tot += Integer.parseInt(temp);
				temp = "";
			}
		}
		tot += Integer.parseInt(temp);
		result = Integer.toString(tot);
		printResult();
	}
	
	class numBtnAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			result += e.getActionCommand();
			printResult();
		}
	}
	
//	class btnAction implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton btn = (JButton) e.getSource();
//			cm.inputBtn(btn.getText());
//		}
//		
//	}
}
