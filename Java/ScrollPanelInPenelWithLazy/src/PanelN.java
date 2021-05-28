import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelN extends JPanel {
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PanelN() {
		setLayout(null);
		add(getLblNewLabel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("나는 일반 패널");
			lblNewLabel.setBounds(150, 140, 118, 16);
		}
		return lblNewLabel;
	}
	
	public JPanel get() {
		return this;
	}
}
