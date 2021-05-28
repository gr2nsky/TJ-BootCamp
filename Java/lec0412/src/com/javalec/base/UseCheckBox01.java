package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class UseCheckBox01 {

	private JFrame frame;
	
	private JTextField tfResult;
	JCheckBox cbBanana = new JCheckBox();
	JCheckBox cbApple = new JCheckBox();;
	JButton btnOK;
	
	private JTextField tfBoard;
	JRadioButton rdbtnKBS;
	JRadioButton rdbtnMBC;
	JButton btnBroadOK;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseCheckBox01 window = new UseCheckBox01();
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
	public UseCheckBox01() {
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
		
		cbBanana = new JCheckBox("Banana");
		cbBanana.setBounds(20, 60, 128, 23);
		frame.getContentPane().add(cbBanana);
		
		cbApple = new JCheckBox("Apple");
		cbApple.setBounds(20, 27, 128, 23);
		frame.getContentPane().add(cbApple);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fruitCheck();
			}
		});
		btnOK.setBounds(30, 95, 117, 29);
		frame.getContentPane().add(btnOK);
		
		tfResult = new JTextField();
		tfResult.setEditable(false);
		tfResult.setBounds(20, 136, 185, 26);
		frame.getContentPane().add(tfResult);
		tfResult.setColumns(10);
		
		JRadioButton rdbtnKBS = new JRadioButton("KBS");
		rdbtnKBS.setBounds(281, 27, 141, 23);
		frame.getContentPane().add(rdbtnKBS);
		
		JRadioButton rdbtnMBC = new JRadioButton("MBC");
		rdbtnMBC.setBounds(281, 60, 141, 23);
		frame.getContentPane().add(rdbtnMBC);
		
		tfBoard = new JTextField();
		tfBoard.setEditable(false);
		tfBoard.setColumns(10);
		tfBoard.setBounds(259, 136, 185, 26);
		frame.getContentPane().add(tfBoard);
		
		JButton btnBroadOK = new JButton("OK");
		btnBroadOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnKBS.isSelected() == true) {
					tfBoard.setText(rdbtnKBS.getText());
				}
				else if(rdbtnMBC.isSelected() == true) {
					tfBoard.setText(rdbtnMBC.getText());
				}
				
			}
		});
		btnBroadOK.setBounds(281, 95, 117, 29);
		frame.getContentPane().add(btnBroadOK);
	}
	
	private void fruitCheck() {
		if (cbApple.isSelected() == true && cbBanana.isSelected() == true) {
			tfResult.setText("모두 선택되었습니다.");
		}
		else if (cbApple.isSelected() == true) {
			tfResult.setText(cbApple.getText());
		}
		else if (cbBanana.isSelected() == true) {
			tfResult.setText(cbBanana.getText());
		}
	}
}
