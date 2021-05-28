package com.javalec.base;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GUI0001 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField resultField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	void run_base01(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI0001 window = new GUI0001();
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
	public GUI0001() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("더하기");
		frame.setBounds(100, 100, 500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTextField1());
		frame.getContentPane().add(getTextField2());
		frame.getContentPane().add(getResultField());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("더하기");
			lblNewLabel.setBounds(18, 25, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTextField1() {
		if (textField1 == null) {
			textField1 = new JTextField();
			textField1.setHorizontalAlignment(SwingConstants.TRAILING);
			textField1.setBounds(18, 53, 105, 26);
			textField1.setColumns(10);
		}
		return textField1;
	}
	private JTextField getTextField2() {
		if (textField2 == null) {
			textField2 = new JTextField();
			textField2.setHorizontalAlignment(SwingConstants.TRAILING);
			textField2.setColumns(10);
			textField2.setBounds(160, 53, 95, 26);
		}
		return textField2;
	}
	private JTextField getResultField() {
		if (resultField == null) {
			resultField = new JTextField();
			resultField.setHorizontalAlignment(SwingConstants.TRAILING);
			resultField.setEditable(false);
			resultField.setColumns(10);
			resultField.setBounds(287, 53, 117, 26);
		}
		return resultField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("+");
			lblNewLabel_1.setBounds(135, 58, 20, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("=");
			lblNewLabel_1_1.setBounds(267, 58, 20, 16);
		}
		return lblNewLabel_1_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("더하기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addSum();
					
				}
			});
			btnNewButton.setBounds(399, 53, 95, 29);
		}
		return btnNewButton;
	}
	
	private void addSum() {
		int a = Integer.parseInt(textField1.getText());
		int b = Integer.parseInt(textField2.getText());
		String result = Integer.toString(a+b);
		System.out.println("[event1]" + a + " + " + b + " = " + result);
		resultField.setText(result);
		
		JOptionPane.showMessageDialog(null, result);
	}
	
}//---------------------------------------------------------------------------------------
