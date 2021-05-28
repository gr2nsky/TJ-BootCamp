import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JPanel panel;
	private JPanel nomalPanel;
	private JScrollPane scrollPane;
	private JButton btnN;
	private JButton btnS;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(nomalPanel());
		frame.getContentPane().add(getScrollPane());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.PINK);
			panel.setBounds(6, 6, 90, 260);
			panel.setLayout(null);
			panel.add(getBtnN());
			panel.add(getBtnS());
		}
		return panel;
	}
	private JPanel nomalPanel() {
		PanelN pn = new PanelN();
		if (nomalPanel == null) {
			nomalPanel = pn.get();
			nomalPanel.setBounds(95, 6, 349, 260);
		}
		return nomalPanel;
	}
	private JScrollPane getScrollPane() {
		PanelS ps = new PanelS();
		//아래 세줄 없으면 안됨.
		Dimension size = new Dimension();
		size.setSize(418, 564);
		ps.setPreferredSize(size);
		
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(95, 6, 349, 260);
			scrollPane.setViewportView(ps);
		}
		return scrollPane;
	}
	private JButton getBtnN() {
		if (btnN == null) {
			btnN = new JButton("n");
			btnN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setNomal();
				}
			});
			btnN.setBounds(6, 38, 78, 29);
		}
		return btnN;
	}
	private JButton getBtnS() {
		if (btnS == null) {
			btnS = new JButton("s");
			btnS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setScroll();
				}
			});
			btnS.setBounds(6, 104, 78, 29);
		}
		return btnS;
	}
	
	void setScroll() {
		nomalPanel.setVisible(false);
		scrollPane.setVisible(true);
	}
	void setNomal() {
		nomalPanel.setVisible(true);
		scrollPane.setVisible(false);
	}
}
