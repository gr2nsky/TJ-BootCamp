package com.library.rental.View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class retalMenuBar {
	
	
	public void JMenuBar setJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 369, 22);
//		frame.getContentPane().add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("home");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("학생 관리");
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("도서관리");
		menuBar.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu = new JMenu("대출관리");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("대출");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("반납");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("help");
		menuBar.add(mntmNewMenuItem_4);
		
		return menuBar;
	}
}
