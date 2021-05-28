package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class UseComboBox01 {

	private JFrame frmCombobox;
	private JTextField tfFruits;
	private JTextField tfInput;
	private JComboBox cbInput;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseComboBox01 window = new UseComboBox01();
					window.frmCombobox.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UseComboBox01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCombobox = new JFrame();
		frmCombobox.setTitle("ComboBox");
		frmCombobox.setBounds(100, 100, 450, 300);
		frmCombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombobox.getContentPane().setLayout(null);
		
		JComboBox cbFruits = new JComboBox();
		cbFruits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stFruits = cbFruits.getSelectedItem().toString();
				tfFruits.setText(stFruits);
			}
		});
		cbFruits.setModel(new DefaultComboBoxModel(new String[] {"Aapple", "Banana", "Grape", "Mango", "Melon"}));
		cbFruits.setBounds(23, 17, 108, 27);
		frmCombobox.getContentPane().add(cbFruits);
		
		tfFruits = new JTextField();
		tfFruits.setBounds(151, 16, 182, 26);
		frmCombobox.getContentPane().add(tfFruits);
		tfFruits.setColumns(10);
		
		tfInput = new JTextField();
		tfInput.setBounds(23, 84, 130, 26);
		frmCombobox.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		cbInput = new JComboBox();
		cbInput.setBounds(191, 85, 143, 27);
		frmCombobox.getContentPane().add(cbInput);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCombo();
			}
		});
		addBtn.setBounds(23, 122, 117, 29);
		frmCombobox.getContentPane().add(addBtn);
	}
	
	private void addCombo() {
		String stTemp = tfInput.getText();
		if (!stTemp.equals("")) {
			cbInput.addItem(stTemp);
			tfInput.setText("");
		}
	}
}
