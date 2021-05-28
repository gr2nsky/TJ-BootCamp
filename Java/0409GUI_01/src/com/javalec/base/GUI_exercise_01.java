package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_exercise_01 {

	private JFrame frame;
	private JTextField inputField1;
	private JTextField inputField2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnSum;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JTextField editField1;
	private JTextField editField2;
	private JTextField editField3;
	private JLabel operatorLabel;
	private JLabel lblNewLabel_2_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_exercise_01 window = new GUI_exercise_01();
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
	public GUI_exercise_01() {
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
		frame.getContentPane().add(getInputField1());
		frame.getContentPane().add(getInputField2());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnSum());
		frame.getContentPane().add(getBtnSub());
		frame.getContentPane().add(getBtnMul());
		frame.getContentPane().add(getBtnDiv());
		frame.getContentPane().add(getEditField1());
		frame.getContentPane().add(getEditField2());
		frame.getContentPane().add(getEditField3());
		frame.getContentPane().add(getOperatorLabel());
		frame.getContentPane().add(getLblNewLabel_2_1());
	}

	private JTextField getInputField1() {
		if (inputField1 == null) {
			inputField1 = new JTextField();
			inputField1.setHorizontalAlignment(SwingConstants.TRAILING);
			inputField1.setBounds(59, 20, 107, 26);
			inputField1.setColumns(10);
		}
		return inputField1;
	}
	private JTextField getInputField2() {
		if (inputField2 == null) {
			inputField2 = new JTextField();
			inputField2.setHorizontalAlignment(SwingConstants.TRAILING);
			inputField2.setColumns(10);
			inputField2.setBounds(59, 58, 107, 26);
		}
		return inputField2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("숫자1");
			lblNewLabel.setBounds(24, 25, 37, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("숫자2");
			lblNewLabel_1.setBounds(24, 63, 37, 16);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnSum() {
		if (btnSum == null) {
			btnSum = new JButton("+");
			btnSum.addActionListener(new calcBtnEvent());
			btnSum.setBounds(196, 20, 49, 29);
		}
		return btnSum;
	}
	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("-");
			btnSub.addActionListener(new calcBtnEvent());
			btnSub.setBounds(257, 20, 49, 29);
		}
		return btnSub;
	}
	private JButton getBtnMul() {
		if (btnMul == null) {
			btnMul = new JButton("X");
			btnMul.addActionListener(new calcBtnEvent());
			btnMul.setBounds(318, 20, 49, 29);
		}
		return btnMul;
	}
	private JButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new JButton("/");
			btnDiv.addActionListener(new calcBtnEvent());
			btnDiv.setBounds(379, 20, 49, 29);
		}
		return btnDiv;
	}
	private JTextField getEditField1() {
		if (editField1 == null) {
			editField1 = new JTextField();
			editField1.setEditable(false);
			editField1.setHorizontalAlignment(SwingConstants.TRAILING);
			editField1.setBounds(24, 196, 95, 26);
			editField1.setColumns(10);
		}
		return editField1;
	}
	private JTextField getEditField2() {
		if (editField2 == null) {
			editField2 = new JTextField();
			editField2.setEditable(false);
			editField2.setHorizontalAlignment(SwingConstants.TRAILING);
			editField2.setBounds(157, 196, 95, 26);
			editField2.setColumns(10);
		}
		return editField2;
	}
	private JTextField getEditField3() {
		if (editField3 == null) {
			editField3 = new JTextField();
			editField3.setEditable(false);
			editField3.setHorizontalAlignment(SwingConstants.TRAILING);
			editField3.setBounds(293, 196, 95, 26);
			editField3.setColumns(10);
		}
		return editField3;
	}
	private JLabel getOperatorLabel() {
		if (operatorLabel == null) {
			operatorLabel = new JLabel("+");
			operatorLabel.setBounds(131, 201, 23, 16);
		}
		return operatorLabel;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("=");
			lblNewLabel_2_1.setBounds(258, 201, 23, 16);
		}
		return lblNewLabel_2_1;
	}


class calcBtnEvent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int num_1;
		int num_2;
		String result = "";
		
		if(inputField1.getText().equals("")) {
			inputField1.setText("0");
		}
		if(inputField2.getText().equals("")) {
			inputField2.setText("0");
		}
		
		num_1 = Integer.parseInt(inputField1.getText());
		num_2 = Integer.parseInt(inputField2.getText());

		editField1.setText(inputField1.getText());
		editField2.setText(inputField2.getText());
		
		if(e.getSource() == btnSum) {
			operatorLabel.setText("+");
			result = Integer.toString(num_1 + num_2);
		} else if(e.getSource() == btnSub) {
			operatorLabel.setText("-");
			result = Integer.toString(num_1 - num_2);
		} else if(e.getSource() == btnMul) {
			operatorLabel.setText("X");
			result = Integer.toString(num_1 * num_2);
		}else {
			operatorLabel.setText("/");
			if (num_1 == 0 || num_2 == 0) 
				result = "0";
			else {
				result = Double.toString(num_1 / (num_2 * 1.0));
			}
		}
		editField3.setText(result);
		
	}
}
}
