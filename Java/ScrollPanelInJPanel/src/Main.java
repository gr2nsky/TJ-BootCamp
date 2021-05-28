import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JPanel tagetPanel = new JPanel();
	JScrollPane jsp = new JScrollPane();

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
		frame.getContentPane().setForeground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
//		frame.getContentPane().remove(tagetPanel);
//		SCpanel sc = new SCpanel();
////		tagetPanel = sc.get();
//		tagetPanel.setBounds(89, 0, 355, 266);
//		frame.getContentPane().add(tagetPanel);
//		

//		frame.getContentPane().remove(rightPanel);
//		rightPanel = pb.get();
//		rightPanel.setBounds(100, 0, 400, 272);
//		frame.getContentPane().add(rightPanel);
//		frame.revalidate();
//		frame.repaint();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setForeground(Color.PINK);
		panel_1.setBounds(6, 0, 84, 266);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNomal = new JButton("n");
		btnNomal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSetNomal();
			}
		});
		btnNomal.setBounds(0, 65, 73, 29);
		panel_1.add(btnNomal);
		
		JButton btnScroll = new JButton("sc");
		btnScroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSetScroll();
			}
		});
		btnScroll.setBounds(0, 113, 73, 29);
		panel_1.add(btnScroll);

	}
	
	void panelSetScroll() {
		
		PanelA pa = new PanelA();
		Dimension size = new Dimension();
		
		frame.getContentPane().remove(tagetPanel);
		jsp.setBounds(89, 0, 355, 266);
		frame.getContentPane().add(jsp);
		size.setSize(1000, 1000);
		pa.setPreferredSize(size);
		jsp.setViewportView(pa);
		

		frame.revalidate();
		frame.repaint();
	}
	void panelSetNomal() {
		PanelN pn = new PanelN();
		
		frame.getContentPane().remove(jsp);
		tagetPanel = pn.get();
		tagetPanel.setBounds(100, 0, 400, 272);
		frame.getContentPane().add(tagetPanel);
		frame.revalidate();
		frame.repaint();
	}
}
