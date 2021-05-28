import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelS extends JPanel {
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PanelS() {
		setLayout(null);
		add(getLblNewLabel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("<html>나는<br>컵나큰<br>패너어어얼<br>입니다<br>아시겟<br>습니가>????</html>");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 76));
			lblNewLabel.setBounds(6, 6, 410, 552);
		}
		return lblNewLabel;
	}
	
	public JPanel get() { 
		return this;
	}
}
