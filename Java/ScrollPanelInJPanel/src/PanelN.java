import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelN extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelN() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("나는 정상");
		lblNewLabel.setBounds(71, 109, 61, 16);
		add(lblNewLabel);

	}
	
	public JPanel get() {
		return this;
	}

}
