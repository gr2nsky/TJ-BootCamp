import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelA extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelA() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>나는<br>컵나큰<br>패너어어얼<br>입니다<br>아시겟<br>습니가>????</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 71));
		lblNewLabel.setBounds(6, 6, 544, 633);
		add(lblNewLabel);

	}
}
