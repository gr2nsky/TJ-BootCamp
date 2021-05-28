package com.javalec.exercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginEx {

	private JFrame frame;
	private JTextField tfUser;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JButton btnOK;
	private JPasswordField tfPW;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEx window = new LoginEx();
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
	public LoginEx() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 156);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfUser());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getTfPW());
	}

	private JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setBounds(61, 44, 130, 26);
			tfUser.setColumns(10);
		}
		return tfUser;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("User");
			lblNewLabel.setBounds(28, 49, 36, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setBounds(28, 87, 36, 16);
		}
		return lblPw;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnOK.setBounds(203, 82, 117, 29);
		}
		return btnOK;
	}

	private JPasswordField getTfPW() {
		if (tfPW == null) {
			tfPW = new JPasswordField();
			tfPW.setBounds(61, 82, 130, 26);
		}
		return tfPW;
	}
	
	void login() {
//		private JTextField tfUser;
//		private JTextField tfPW;
		String inputID = tfUser.getText();
		char[] pwChar = tfPW.getPassword();
		String pwString = new String(pwChar);
		
		if(inputID.equals("abc") && pwString.equals("123")) {
			LoginDialog ld = new LoginDialog();
			ld.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패");
		}
	}
}
