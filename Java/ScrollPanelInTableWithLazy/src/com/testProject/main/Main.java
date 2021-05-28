package com.testProject.main;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JScrollPane scrollPane;
	private gridPanel gp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		{
			JButton btnGO = new JButton("GO");
			btnGO.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					attacheGridPanel();
				}
			});
			btnGO.setBounds(181, 28, 117, 29);
			frame.getContentPane().add(btnGO);
		}
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(42, 186, 415, 180);
			scrollPane.setViewportView(getGridPanel());
		}
		return scrollPane;
	}
	private JPanel getGridPanel() {
		gp = new gridPanel();
		return gp;
	}
	
	
	public void attacheGridPanel() {
		System.out.println("버튼 클릭됨");
		JPanel jp = gp.attachePanel();
		
		Dimension size = new Dimension();
		size.setSize(300, 80 * gp.panelCount);
		jp.setPreferredSize(size);
		

		scrollPane.setViewportView(jp);
	
	}
}


