package com.javalec.exercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercise01 {

	private JFrame frmExercise;
	JComboBox num1;
	JComboBox num2;
	JComboBox operator;
	JTextField tfResult;
	model02 modle;
	static Exercise01 ex01;
	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise01 window = new Exercise01();
					window.frmExercise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exercise01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmExercise = new JFrame();
		frmExercise.setTitle("exercise01");
		frmExercise.setBounds(100, 100, 450, 300);
		frmExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExercise.getContentPane().setLayout(null);
		
		num1 = new JComboBox();
		num1.addActionListener(new clac());
		num1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		num1.setBounds(6, 39, 104, 27);
		frmExercise.getContentPane().add(num1);
		
		operator = new JComboBox();
		operator.addActionListener(new clac());
		operator.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "x", "/"}));
		operator.setBounds(122, 39, 67, 27);
		frmExercise.getContentPane().add(operator);
		
		num2 = new JComboBox();
		num2.addActionListener(new clac());
		num2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		num2.setBounds(201, 39, 104, 27);
		frmExercise.getContentPane().add(num2);
		
		tfResult = new JTextField();
		tfResult.setEditable(false);
		tfResult.setBounds(320, 38, 113, 26);
		frmExercise.getContentPane().add(tfResult);
		tfResult.setColumns(10);
	}
	class clac implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int x = Integer.parseInt(num1.getSelectedItem().toString()); 
			int y = Integer.parseInt(num2.getSelectedItem().toString()); 
			int result = 0;
			
			switch (operator.getSelectedItem().toString()) {
			case "+":
				result = x + y;
				break;
			case "-":
				result = x - y;
				break;
			case "x":
				result = x * y;
				break;
			case "/":
				double doubleResult = x / (y * 1.0);
				doubleResult = Math.round(doubleResult*1000)/1000.0;
				tfResult.setText(Double.toString(doubleResult));
				return;
			}
			tfResult.setText(Integer.toString(result));
			
		}
		
	}
}
