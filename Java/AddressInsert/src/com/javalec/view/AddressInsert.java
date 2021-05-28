package com.javalec.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.modle.DBMS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddressInsert {
	
	DBMS dbms;

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfTelNo;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;
	
	ArrayList<JTextField> inputtf;
	ArrayList<JLabel> jlables;
	

	/**
	 * Launch the application.
	 */
	public static void setView(DBMS dbms) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert window = new AddressInsert(dbms);
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
	public AddressInsert(DBMS dbms) {
		this.dbms = dbms;
		inputtf = new ArrayList<JTextField>();
		jlables = new ArrayList<JLabel>();
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
		
		JLabel lblName = new JLabel("성명");
		lblName.setBounds(19, 19, 61, 16);
		frame.getContentPane().add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(80, 14, 130, 26);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JButton btnSubmit = new JButton("입력");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertAction();
			}
		});
		btnSubmit.setBounds(327, 237, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		tfTelNo = new JTextField();
		tfTelNo.setColumns(10);
		tfTelNo.setBounds(80, 109, 130, 26);
		frame.getContentPane().add(tfTelNo);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(80, 65, 130, 26);
		frame.getContentPane().add(tfAddress);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(80, 154, 130, 26);
		frame.getContentPane().add(tfEmail);
		
		JLabel lblTelNo = new JLabel("전화번호 ");
		lblTelNo.setBounds(19, 114, 61, 16);
		frame.getContentPane().add(lblTelNo);
		
		JLabel lnlAddress = new JLabel("주소");
		lnlAddress.setBounds(19, 70, 61, 16);
		frame.getContentPane().add(lnlAddress);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(19, 159, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblRelation = new JLabel("관계");
		lblRelation.setBounds(19, 210, 61, 16);
		frame.getContentPane().add(lblRelation);
		
		tfRelation = new JTextField();
		tfRelation.setColumns(10);
		tfRelation.setBounds(80, 205, 130, 26);
		frame.getContentPane().add(tfRelation);
		
		
		jlables.add(lblName);
		jlables.add(lblTelNo);
		jlables.add(lnlAddress);
		jlables.add(lblEmail);
		jlables.add(lblRelation);
		
		inputtf.add(tfName);
		inputtf.add(tfTelNo);
		inputtf.add(tfAddress);
		inputtf.add(tfEmail);
		inputtf.add(tfRelation);
		
		JButton btnGoList = new JButton("목록");
		btnGoList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddressQuery aq = new AddressQuery(dbms);
				aq.run(dbms);
			}
		});
		btnGoList.setBounds(327, 14, 75, 29);
		frame.getContentPane().add(btnGoList);
	
		}

	//사용자 정보 입력
	private void insertAction() {
		String[] inputArr = new String[5];
		for (int i = 0; i <= 4; i++) {
			JTextField tf = inputtf.get(i);
			String input = tf.getText().trim();
			if (input.equals("")) {
				String cause = jlables.get(i).getText().toString();
				JOptionPane.showMessageDialog(null, "Input " + cause + " please");
				tf.requestFocus();
				return;
			}
			inputArr[i] = input;
		}
		System.out.println("[insertAction] 수행완료");
		dbms.insertUserInfo(inputArr);
	}
	
	
	
}
