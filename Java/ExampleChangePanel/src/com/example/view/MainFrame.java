package com.example.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainFrame {

	private JFrame frame;
	JPanel rightPanel;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.gray);
		leftPanel.setBounds(0, 0, 100, 272);
		frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		JButton btnShowPanelA = new JButton("PanelA");
		btnShowPanelA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanelA();
			}
		});
		btnShowPanelA.setBounds(6, 44, 88, 29);
		leftPanel.add(btnShowPanelA);
		
		JButton btnShowPanelB = new JButton("PanelB");
		btnShowPanelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanelB();
			}
		});
		btnShowPanelB.setBounds(0, 191, 94, 29);
		leftPanel.add(btnShowPanelB);
		
		rightPanel = new JPanel();
		rightPanel.setBounds(100, 0, 400, 272);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("기본 패널");
		lblNewLabel.setBounds(168, 123, 61, 16);
		rightPanel.add(lblNewLabel);
	}
	
	private void showPanelA() {
		PanelA pa = new PanelA();
		frame.getContentPane().remove(rightPanel);
		
		rightPanel = pa.get();
		rightPanel.setBounds(100, 0, 400, 272);
		frame.getContentPane().add(rightPanel);
		frame.revalidate();
		frame.repaint();
		
	}
	
	private void showPanelB() {
		PanelB pb = new PanelB();
		frame.getContentPane().remove(rightPanel);
		
		rightPanel = pb.get();
		rightPanel.setBounds(100, 0, 400, 272);
		frame.getContentPane().add(rightPanel);
		frame.revalidate();
		frame.repaint();
	}

}
