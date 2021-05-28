package com.example.view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class PanelB extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelB() {
		setLayout(null);
		this.setBackground(Color.orange);
		this.setBounds(0, 0, 300, 272);
		
		JLabel lblNewLabel = new JLabel("This is panelB");
		lblNewLabel.setBounds(100, 94, 103, 82);
		add(lblNewLabel);

	}
	
	public JPanel get(){
		return this;
	}

}
