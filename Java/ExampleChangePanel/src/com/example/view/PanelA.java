package com.example.view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class PanelA extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelA() {
		setLayout(null);
		this.setBackground(Color.pink);
		this.setBounds(0, 0, 300, 272);
		
		JLabel lblNewLabel = new JLabel("This is panelA");
		lblNewLabel.setBounds(96, 114, 98, 47);
		add(lblNewLabel);

	}
	
	public JPanel get(){
		return this;
	}

}
