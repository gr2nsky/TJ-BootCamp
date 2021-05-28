package com.testProject.main;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class gridPanel extends JPanel {
	
	JButton[] bt = new JButton[10];
	int panelCount = 0;
	

	/**
	 * Create the panel.
	 */
	public gridPanel() {
		//(행, 열)
		setLayout(new GridLayout(10,1));
		
	    for (int i = 0; i < bt.length; i++) {
	        bt[i] = new JButton("Button" + i);
	        bt[i].setBounds(0, 0, 200, 200);
	        add(bt[i]);
	    }
	}
	
	public gridPanel get() {
		return this;
	}
	
	public JPanel attachePanel() {
		JPanel jp = new JPanel();
		int count = 0;
		GetImage gi = new GetImage();
		ArrayList<CommentBean> cbs = gi.getStudentImage();
		count = cbs.size();
		panelCount = count;
		
		jp.setLayout(new GridLayout(count,1));
		
	    for (int i = 0; i < count; i++) {
	    	CustomListViewItem  customListViewItem = new CustomListViewItem(
	    			cbs.get(i).id, cbs.get(i).name, cbs.get(i).photo, cbs.get(i).content);
	    	jp.add(customListViewItem);
	    }
	    
	    return jp;
	}
	
	

}
