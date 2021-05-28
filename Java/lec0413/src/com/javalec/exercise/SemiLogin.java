package com.javalec.exercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SemiLogin {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfUserID;
	private JPasswordField pfUserPW;
	private JButton btnOK;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemiLogin window = new SemiLogin();
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
	public SemiLogin() {
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
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getTfUserID());
		frame.getContentPane().add(getPfUserPW());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getTfResult());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("User");
			lblNewLabel.setBounds(44, 35, 30, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setBounds(44, 74, 30, 16);
		}
		return lblPw;
	}
	private JTextField getTfUserID() {
		if (tfUserID == null) {
			tfUserID = new JTextField();
			tfUserID.setBounds(97, 30, 130, 26);
			tfUserID.setColumns(10);
		}
		return tfUserID;
	}
	private JPasswordField getPfUserPW() {
		if (pfUserPW == null) {
			pfUserPW = new JPasswordField();
			pfUserPW.setBounds(97, 69, 130, 26);
		}
		return pfUserPW;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnOK.setBounds(239, 69, 117, 29);
		}
		return btnOK;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setBounds(19, 228, 400, 26);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	
	void login() {
		String inputID;
		char[] pwChar;
		String pwString;
		
		inputID = tfUserID.getText();
		pwChar = pfUserPW.getPassword();
		pwString = new String(pwChar);
		
		if (inputID.equals("abc") && pwString.equals("1234")) {
			tfResult.setText("로그인 성공!");
		} else {
			tfResult.setText("로그인 실패!");
		}
		
		
	}
}
