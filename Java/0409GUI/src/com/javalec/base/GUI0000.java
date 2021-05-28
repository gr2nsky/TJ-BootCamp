/*
 * 0409 윤재필
 * 자바프로젝트 생성 -> 클래스는 swing - application window로 생성
 * 소스코드창 하단 Design으로 GUI 구현 가능
 * 이클립스-프리퍼런스-윈도우빌더-스윙-코드제네레이션-레이지 로 설정해야 에러가 안남
 * 아이템-우클릭-이벤트 핸들러로 간단히 이벤트 등록 가능
 */

package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI0000 {

	private JFrame frmJavalec;
	private JLabel lblTest;
	private JButton Button1;
	private JButton btnButton2;
	private JButton btnButton3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI0000 window = new GUI0000();
					window.frmJavalec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI0000() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJavalec = new JFrame();
		frmJavalec.setTitle("button test");
		frmJavalec.setBounds(100, 100, 450, 300);
		frmJavalec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJavalec.getContentPane().setLayout(null);
		frmJavalec.getContentPane().add(getLblTest());
		frmJavalec.getContentPane().add(getButton1());
		frmJavalec.getContentPane().add(getBtnButton2());
		frmJavalec.getContentPane().add(getBtnButton3());
	}

	private JLabel getLblTest() {
		if (lblTest == null) {
			lblTest = new JLabel("java swing button test");
			lblTest.setBounds(128, 88, 185, 38);
			lblTest.setEnabled(false);
		}
		return lblTest;
	}
	private JButton getButton1() {
		if (Button1 == null) {
			Button1 = new JButton("Button1");
			Button1.setBounds(31, 221, 83, 29);
			Button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("button1을 click 했습니다.");
					JOptionPane.showMessageDialog(null, "button1을 click 했습니다.");
					lblTest.setText("button1을 click 했습니다.");
				}
			});
		}
		return Button1;
	}
	private JButton getBtnButton2() {
		if (btnButton2 == null) {
			btnButton2 = new JButton("Button2");
			btnButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("button2을 click 했습니다.");
					JOptionPane.showMessageDialog(null, "button2을 click 했습니다.");
					lblTest.setText("button2을 click 했습니다.");
				}
			});
			btnButton2.setBounds(174, 221, 83, 29);
		}
		return btnButton2;
	}
	private JButton getBtnButton3() {
		if (btnButton3 == null) {
			btnButton3 = new JButton("Button3");
			btnButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("button3을 click 했습니다.");
					JOptionPane.showMessageDialog(null, "button3+을 click 했습니다.");
					lblTest.setText("button3을 click 했습니다.");
				}
			});
			btnButton3.setBounds(330, 221, 83, 29);
		}
		return btnButton3;
	}
}
