package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordField {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JPasswordField pfPW;
	private JButton btnOK;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordField window = new PasswordField();
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
	public PasswordField() {
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
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getPfPW());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getTfResult());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Password");
			lblNewLabel.setBounds(21, 39, 61, 16);
		}
		return lblNewLabel;
	}
	private JPasswordField getPfPW() {
		if (pfPW == null) {
			pfPW = new JPasswordField();
			pfPW.setBounds(94, 34, 204, 26);
		}
		return pfPW;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
				}
			});
			btnOK.setBounds(310, 34, 117, 29);
		}
		return btnOK;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setBounds(21, 166, 280, 26);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	/*
	 * 다짜고짜 PasswordField.getString이 아니라 아래처럼 써야 함.
	 */
	void checkPassword() {
		char[] passChar = pfPW.getPassword();
		String passString = new String(passChar);
		tfResult.setText(passString);
	}
}
