package com.library.rental.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class retalViewMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retalViewMain window = new retalViewMain();
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
	public retalViewMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 369, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("대출");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(44, 223, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1_1 = new JButton("반납");
		btnNewButton_1_1_1.setBounds(209, 223, 117, 29);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 369, 22);
		frame.getContentPane().add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("home");
		menuBar.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		menuBar.add(separator_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("학생 관리");
		menuBar.add(mntmNewMenuItem_2);
		
		JSeparator separator_2 = new JSeparator();
		menuBar.add(separator_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("도서관리");
		menuBar.add(mntmNewMenuItem_3);
		
		JSeparator separator_3 = new JSeparator();
		menuBar.add(separator_3);
		
		JMenu mnNewMenu = new JMenu("대출관리");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("대출");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("반납");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator_4 = new JSeparator();
		menuBar.add(separator_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("help");
		menuBar.add(mntmNewMenuItem_4);
	}
}
