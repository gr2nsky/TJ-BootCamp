package com.javalec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.db.DBAction;
import com.javalec.modle.Bean;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddressBook {

	private JFrame frame;
	private JTextField tfSearchBar;
	private JTextField tfCount;
	private JTable tbAddress;
	private JTextField tfSeqNo;
	private JTextField tfName;
	private JTextField tfTelNo;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JTextField tfRelation;
	private JButton btnOK;
	
	private ButtonGroup radioBtnGroup;

	//하단 TF 묶음
	private ArrayList<JTextField> tfs;
	
	//테이블 설정
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	
	//tbAddress 클릭이벤트 on/off (1/0)
	int tbAddressClieckEvent = 1;
	
	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBook window = new AddressBook();
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
	public AddressBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAll();
				//default : search
				tfSetOff();
				tbAddress.setEnabled(true);
				btnOK.setVisible(false);
			}
		});
		frame.setBounds(100, 100, 412, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		radioBtnGroup = new ButtonGroup();
		tfs = new ArrayList<JTextField>();
		
		JRadioButton rdbtnInsert = new JRadioButton("입력");
		rdbtnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlledRadioBtn(e);
			}
		});
		rdbtnInsert.setBounds(52, 6, 56, 23);
		radioBtnGroup.add(rdbtnInsert);
		frame.getContentPane().add(rdbtnInsert);
		
		JRadioButton rdbtnUpdate = new JRadioButton("수정");
		rdbtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlledRadioBtn(e);
			}
		});
		rdbtnUpdate.setBounds(120, 6, 56, 23);
		radioBtnGroup.add(rdbtnUpdate);
		frame.getContentPane().add(rdbtnUpdate);
		
		JRadioButton rdbtnDelete = new JRadioButton("삭제");
		rdbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlledRadioBtn(e);
			}
		});
		rdbtnDelete.setBounds(198, 6, 56, 23);
		radioBtnGroup.add(rdbtnDelete);
		frame.getContentPane().add(rdbtnDelete);
		
		JRadioButton rdbtnSelect = new JRadioButton("검색");
		rdbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlledRadioBtn(e);
			}
		});
		rdbtnSelect.setSelected(true);
		rdbtnSelect.setBounds(266, 6, 56, 23);
		radioBtnGroup.add(rdbtnSelect);
		frame.getContentPane().add(rdbtnSelect);
		
		JComboBox cbCondition = new JComboBox();
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
		cbCondition.setBounds(6, 41, 78, 27);
		frame.getContentPane().add(cbCondition);
		
		tfSearchBar = new JTextField();
		tfSearchBar.setBounds(81, 41, 255, 26);
		frame.getContentPane().add(tfSearchBar);
		tfSearchBar.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(328, 41, 78, 29);
		frame.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 68, 400, 126);
		frame.getContentPane().add(scrollPane);
		
		tbAddress = new JTable();
		tbAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		tbAddress.setModel(Outer_Table);
		scrollPane.setViewportView(tbAddress);
		
		tfCount = new JTextField();
		tfCount.setEditable(false);
		tfCount.setBounds(321, 196, 50, 26);
		frame.getContentPane().add(tfCount);
		tfCount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("명");
		lblNewLabel.setBounds(376, 201, 17, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seq No");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(6, 235, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfSeqNo = new JTextField();
		tfSeqNo.setEditable(false);
		tfSeqNo.setBounds(81, 230, 61, 26);
		frame.getContentPane().add(tfSeqNo);
		tfSeqNo.setColumns(10);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(81, 263, 95, 26);
		frame.getContentPane().add(tfName);
		
		JLabel lblNewLabel_1_1 = new JLabel("이름");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(6, 268, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tfTelNo = new JTextField();
		tfTelNo.setColumns(10);
		tfTelNo.setBounds(81, 301, 130, 26);
		frame.getContentPane().add(tfTelNo);
		
		JLabel lblNewLabel_1_2 = new JLabel("전화번호");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(6, 306, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(81, 339, 130, 26);
		frame.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_1_3 = new JLabel("이메일");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setBounds(6, 344, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(81, 377, 213, 26);
		frame.getContentPane().add(tfAddress);
		
		JLabel lblNewLabel_1_4 = new JLabel("주소");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setBounds(6, 382, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		tfRelation = new JTextField();
		tfRelation.setColumns(10);
		tfRelation.setBounds(81, 415, 130, 26);
		frame.getContentPane().add(tfRelation);
		
		JLabel lblNewLabel_1_5 = new JLabel("관계");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setBounds(6, 420, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classification();
			}
		});
		btnOK.setBounds(289, 478, 117, 29);
		frame.getContentPane().add(btnOK);
		
		
		tfs.add(tfSeqNo);
		tfs.add(tfName);
		tfs.add(tfTelNo);
		tfs.add(tfAddress);
		tfs.add(tfEmail);
		tfs.add(tfRelation);
	}
	
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4);
		
		int rowCount = Outer_Table.getRowCount();
		for (int i = 0; i <rowCount; i++) {
			//0번째 row를 제거 
			Outer_Table.removeRow(0);
		}
		tbAddress.setAutoResizeMode(tbAddress.AUTO_RESIZE_OFF);
		
		//컬럼의 순서에 크기값 지정
		TableColumn col;
		
		//seqno 칼은 width30
		col= tbAddress.getColumnModel().getColumn(0);
		col.setPreferredWidth(30);
		//나머지 컬럼은 width100
		for (int i = 1; i <= 3; i++) {
			col = tbAddress.getColumnModel().getColumn(i);
			col.setPreferredWidth(100);
		}
	}
	
	private void searchAll(){
		DBAction dba = new DBAction();
		ArrayList<Bean> beanList = dba.searchAll();
		int listCount = beanList.size();
		
		for(Bean bean : beanList) {
			String[] qTxt = { Integer.toString(bean.getSeqno()), bean.getName(), bean.getTelno(), bean.getRelation() };
			Outer_Table.addRow(qTxt);
		}
		
		tfCount.setText(Integer.toString(listCount));
	}
	
	private void tableClick() {
		if (tbAddressClieckEvent == 0) return;
		
		DBAction dba;
		int row = tbAddress.getSelectedRow();
		String stringWkSeq = (String) tbAddress.getValueAt(row, 0);
		int intWkSeq = (int) Integer.parseInt(stringWkSeq);
		System.out.println("[tableClick] 선택된 seqNo : " + intWkSeq);
		dba = new DBAction(intWkSeq);
		
		Bean bean = dba.tableClick();
		tfSeqNo.setText(Integer.toString(bean.getSeqno()));
        tfName.setText(bean.getName());
        tfTelNo.setText(bean.getTelno());
        tfAddress.setText(bean.getAddress());
        tfEmail.setText(bean.getEmail());
        tfRelation.setText(bean.getRelation());
	}
	
	//btnOK 대응
	private void classification() {
		switch (btnOK.getText().toString()) {
		case "추가":
			insertAction();
			break;
		case "수정":
			updateAddress();
			break;
		case "삭제":
			deleteAddress(); 
			break;
		default:
			break;
		}
		System.out.println("clicked btn is " + btnOK.getText().toString());
	}
	
	//radioBtn selection에 대응
	private void controlledRadioBtn(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "입력":
			clearColumn();
			tfSetOn();
			tbAddressClieckEvent = 0;
			btnOK.setText("추가");
			btnOK.setVisible(true);
			break;
		case "수정":
			tfSetOn();
			tbAddressClieckEvent = 1;
			btnOK.setText("수정");
			btnOK.setVisible(true);
			break;
		case "삭제":
			tfSetOff();
			tbAddressClieckEvent = 1;
			btnOK.setText("삭제");
			btnOK.setVisible(true);
			break;
		case "검색":
			tfSetOff();
			tbAddressClieckEvent = 1;
			btnOK.setVisible(false);
			break;
		}
	}
	
	//하단 tf 클리어
	private void clearColumn() {
		for (JTextField tf : tfs) {
			tf.setText("");
		}
	}
	//하단 tf 사용 off
	private void tfSetOff() {
		for (int i = 1; i < tfs.size(); i++) {
			tfs.get(i).setEnabled(false);
		}
	}
	//하단 tf 사용 on
	private void tfSetOn() {
		for (int i = 1; i < tfs.size(); i++) {
			tfs.get(i).setEnabled(true);
		}
	}
	
}
