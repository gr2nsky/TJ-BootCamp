package com.javalec.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.modle.DBMS;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class AddressQuery {

	private DBMS dbms;
	
	private JFrame frame;
	private JTextField tfSearch;
	private JTable Inner_Table;
	private JTextField tfSeqNo;
	private JTextField tfTelNo;
	private JTextField tfAddress;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfRelation;
	private JTextField tfCount;
	private JComboBox cbSelection;
	private JButton btnOk;
	private ButtonGroup radioBtns = new ButtonGroup();
	
	ArrayList<JTextField> tfArr;
	
	int maxSeqNo = 0;
	
	//Table 설정
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void run(DBMS dbms) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressQuery window = new AddressQuery(dbms);
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
	public AddressQuery(DBMS dbms) {
		this.dbms = dbms;
		tfArr = new ArrayList<JTextField>();
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
				searchAction();
			}
		});
		frame.setBounds(100, 100, 450, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cbSelection = new JComboBox();
		cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
		cbSelection.setBounds(27, 46, 85, 27);
		frame.getContentPane().add(cbSelection);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(110, 45, 238, 26);
		frame.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSeach = new JButton("검색");
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionQuery();
			}
		});
		btnSeach.setBounds(345, 45, 75, 29);
		frame.getContentPane().add(btnSeach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 82, 382, 106);
		frame.getContentPane().add(scrollPane);
		
		Inner_Table = new JTable();
		Inner_Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//테이블 설정 부착
		Inner_Table.setModel(Outer_Table);
		scrollPane.setViewportView(Inner_Table);
		
		JLabel lblNewLabel = new JLabel("Seq No");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(27, 200, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		tfSeqNo = new JTextField();
		tfSeqNo.setEditable(false);
		tfSeqNo.setBounds(93, 195, 75, 26);
		frame.getContentPane().add(tfSeqNo);
		tfSeqNo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(27, 261, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfTelNo = new JTextField();
		tfTelNo.setEnabled(false);
		tfTelNo.setColumns(10);
		tfTelNo.setBounds(91, 256, 130, 26);
		frame.getContentPane().add(tfTelNo);
		
		JLabel lblNewLabel_2 = new JLabel("주소");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(27, 321, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfAddress = new JTextField();
		tfAddress.setEnabled(false);
		tfAddress.setColumns(10);
		tfAddress.setBounds(91, 316, 280, 26);
		frame.getContentPane().add(tfAddress);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(27, 228, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfName = new JTextField();
		tfName.setEnabled(false);
		tfName.setColumns(10);
		tfName.setBounds(93, 223, 130, 26);
		frame.getContentPane().add(tfName);
		
		JLabel lblNewLabel_4 = new JLabel("이메일");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(27, 293, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfEmail = new JTextField();
		tfEmail.setEnabled(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(91, 288, 130, 26);
		frame.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_2_1 = new JLabel("관계");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(27, 349, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		tfRelation = new JTextField();
		tfRelation.setEnabled(false);
		tfRelation.setColumns(10);
		tfRelation.setBounds(91, 344, 130, 26);
		frame.getContentPane().add(tfRelation);
		
		tfCount = new JTextField();
		tfCount.setEditable(false);
		tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
		tfCount.setColumns(10);
		tfCount.setBounds(345, 190, 51, 26);
		frame.getContentPane().add(tfCount);
		
		JLabel lblNewLabel_5 = new JLabel("명");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(386, 195, 24, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfArr.add(tfSeqNo);
		tfArr.add(tfName);
		tfArr.add(tfTelNo);
		tfArr.add(tfAddress);
		tfArr.add(tfEmail);
		tfArr.add(tfRelation);
		
		JRadioButton rdbtnInsert = new JRadioButton("입력");
		rdbtnInsert.addActionListener(new radioCliecked());
		rdbtnInsert.setBounds(38, 11, 61, 23);
		frame.getContentPane().add(rdbtnInsert);
		radioBtns.add(rdbtnInsert);
		
		JRadioButton rdbtnUpdate = new JRadioButton("수정");
		rdbtnUpdate.addActionListener(new radioCliecked());
		rdbtnUpdate.setBounds(107, 11, 61, 23);
		frame.getContentPane().add(rdbtnUpdate);
		radioBtns.add(rdbtnUpdate);
		
		JRadioButton rdbtnDelete = new JRadioButton("삭제");
		rdbtnDelete.addActionListener(new radioCliecked());
		rdbtnDelete.setBounds(180, 10, 61, 23);
		frame.getContentPane().add(rdbtnDelete);
		radioBtns.add(rdbtnDelete);
		
		JRadioButton rdbtnSearch = new JRadioButton("검색");
		rdbtnSearch.setSelected(true);
		rdbtnSearch.addActionListener(new radioCliecked());
		rdbtnSearch.setBounds(263, 11, 61, 23);
		frame.getContentPane().add(rdbtnSearch);
		radioBtns.add(rdbtnSearch);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classification();
			}
		});
		btnOk.setBounds(313, 391, 117, 29);
		frame.getContentPane().add(btnOk);
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
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
		//컬럼의 순서에 크기값 지정
		TableColumn col;
		
		col= Inner_Table.getColumnModel().getColumn(0);
		col.setPreferredWidth(30);
		
		col = Inner_Table.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);
		
		col = Inner_Table.getColumnModel().getColumn(2);
		col.setPreferredWidth(100);
		
		col = Inner_Table.getColumnModel().getColumn(3);
		col.setPreferredWidth(200);
	}
	//최초 모든 데이터를 테이블에 출력
	private void searchAction(){
		ArrayList<String[]> rsArr = dbms.searchUser();
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table.addRow(rsArr.get(i));
		}
		tfCount.setText(Integer.toString(rsArr.size()));
		
		//rsArr.size()번째 로우의 seqno를 가져와 maxSeqNo에 입력해야 함
		String wkSeq = (String) Inner_Table.getValueAt(rsArr.size() - 1, 0);
		maxSeqNo = Integer.parseInt(wkSeq);
		System.out.println("[searchAction]maxSeqNo = " + maxSeqNo);
	}
	
	//테이플의 아이템을 클릭시 하단 tf에 상세내용 출력
	private void tableClick() {
		ArrayList<String> rsArr = new ArrayList<String>();
		int row = Inner_Table.getSelectedRow();
		String wkSeq = (String) Inner_Table.getValueAt(row, 0);
		System.out.println("선택된 열 : " + row + " // seq번호 :" + wkSeq);
		
		//seqno, name, telno, address, email, relation
		rsArr = dbms.searchOneUser(wkSeq);
		
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			tfArr.get(i).setText( rsArr.get(i) );
		}
	}
	
	//입력
	private void insertAction() {
		String[] inputArr = new String[5];
		for (int i = 1; i <= 5; i++) {
			JTextField tf = tfArr.get(i);
			String input = tf.getText().trim();
			if (input.equals("")) {
				JOptionPane.showMessageDialog(null, "항목을 모두 작성해 주세요.");
				tf.requestFocus();
				return;
			}
			inputArr[i - 1] = input;
		}
		System.out.println("[insertAction] 수행완료");
		if (dbms.insertUserInfo(inputArr)) {
			JOptionPane.showMessageDialog(null, "입력 성공");
			Outer_Table.addRow(getTableDataFromTFArray(1));
			int newSeq = Integer.parseInt(tfCount.getText().toString()) + 1;
			tfCount.setText(Integer.toString(newSeq));
			clearColumn();
		} else {
			JOptionPane.showMessageDialog(null, "입력실패");
		}
	}
	
	//조건검색
	private void conditionQuery() {
		ArrayList<String[]> rsArr = new ArrayList<String[]>();
		int type = cbSelection.getSelectedIndex();
		String conditionQueryColumn = "";
		String search = tfSearch.getText();
		
		switch (type) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "address";
			break;
		case 2:
			conditionQueryColumn = "relation";
			break;
		default:
			break;
		}
		System.out.println(conditionQueryColumn);
		tableInit();
		clearColumn();
		rsArr = dbms.conditionQueryAction(conditionQueryColumn, search);
		
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table.addRow(rsArr.get(i));
		}
		tfCount.setText(Integer.toString(rsArr.size()));
	}
	
	
	//하단 tf 클리어
	private void clearColumn() {
		for (int i = 0; i < tfArr.size(); i++) {
			tfArr.get(i).setText("");
		}
	}
	
	//해당 컬럼을 삭제하고, 카운트 1감소
	private void deleteColumn(int row) {
		int count = Integer.parseInt(tfCount.getText());
		Outer_Table.removeRow(row);
		tfCount.setText(Integer.toString(count - 1));
	}
	
	//수정된 칼럼을 기본 컬럼 앞에 추가
	private void updateColumn(int row, String[] updateDatas) {
		Outer_Table.insertRow(row, updateDatas);
	}
	
	//정보 삭제
	private void deleteAddress() {
		//선택된 행번호 추출
		int row = Inner_Table.getSelectedRow();
		//선택하지 않았을 경우 예외처리
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 항목이 없습니다.");
			return;
		}
		String wkSeq = (String) Inner_Table.getValueAt(row, 0);
		System.out.println("선택된 열 : " + row + " // seq번호 :" + wkSeq);

		if (dbms.deleteAddress(wkSeq)) {
			JOptionPane.showMessageDialog(null, "삭제 성공");
			deleteColumn(row);
			clearColumn();
		} else {
			JOptionPane.showMessageDialog(null, "삭제 실패");
		}
	}
	
	//정보 수정
	private void updateAddress() {
		ArrayList<String> updateData = new ArrayList<String>();
		//선택된 행번호 추출
		int row = Inner_Table.getSelectedRow();
		//선택하지 않았을 경우 예외처리
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 항목이 없습니다.");
			return;
		}
		//선택된테이블 아이템의 seqno 추출
		String wkSeq = (String) Inner_Table.getValueAt(row, 0);
		System.out.println("선택된 열 : " + row + " // seq번호 :" + wkSeq);
		
		for(JTextField tf : tfArr) {
			updateData.add(tf.getText());
		}
		if (dbms.updateAddress(wkSeq, updateData)) {
			JOptionPane.showMessageDialog(null, "수정 성공");
			//해당 row에 아이템이 추가되므로, row+1번째 행을 삭제해야 기존 데이터를 지울 수 있다.
			updateColumn(row, getTableDataFromTFArray(0));
			deleteColumn(row + 1);
			clearColumn();
		} else {
			JOptionPane.showMessageDialog(null, "수정 실패");
		}
	}
	
	//tf의 arraylist에서 테이블에 입력할 값만 추출해 배열로 반환
	//type 0이 디폴트, 1은 입력
	private String[] getTableDataFromTFArray(int type) {
		if (type == 0) {
			String[] data = {tfArr.get(0).getText(), tfArr.get(1).getText(), tfArr.get(2).getText(), tfArr.get(5).getText()};
			return data;
		} else {
			String[] data = {Integer.toString(maxSeqNo + 1), tfArr.get(1).getText(), tfArr.get(2).getText(), tfArr.get(5).getText()};
			System.out.println("[getTableDataFromTFArray] 입력값 : " + data);
			return data;
		}

	}
	
	private void classification() {
		switch (btnOk.getText().toString()) {
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
		System.out.println("clicked btn is " + btnOk.getText().toString());
	}
	
	class radioCliecked implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "입력":
				clearColumn();
				tfSetOn();
				Inner_Table.setEnabled(false);
				btnOk.setText("추가");
				btnOk.setVisible(true);
				break;
			case "수정":
				tfSetOn();
				Inner_Table.setEnabled(true);
				btnOk.setText("수정");
				btnOk.setVisible(true);
				break;
			case "삭제":
				tfSetOff();
				Inner_Table.setEnabled(true);
				btnOk.setText("삭제");
				btnOk.setVisible(true);
				break;
			case "검색":
				tfSetOff();
				Inner_Table.setEnabled(true);
				btnOk.setVisible(false);
				break;

			default:
				break;
			}
			
		}
		
		void tfSetOff() {
			for (int i = 1; i < tfArr.size(); i++) {
				tfArr.get(i).setEnabled(false);
			}
		}
		
		void tfSetOn() {
			for (int i = 1; i < tfArr.size(); i++) {
				tfArr.get(i).setEnabled(true);
			}
		}
	}

}
