import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SCpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SCpanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 288);
		add(scrollPane);
		
		PanelA pa = new PanelA();
		Dimension size = new Dimension();
		size.setSize(1000, 1000);
		pa.setPreferredSize(size);
		scrollPane.setViewportView(pa);
//		JScrollPane jScrollPane = new JScrollPane();//스크롤팬 생성
//		JPanel panel_ex = new JPanel();//스크롤팬에 붙일 패널 생성
//		Dimension size = new Dimension();//사이즈를 지정하기 위한 객체 생성
//		size.setSize(1000, 1000);//객체의 사이즈를 지정
//		panel_ex.setPreferredSize(size);//사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정
//		jScrollPane.setViewportView(panel_ex);//스크롤 팬 위에 패널을 올린다
	}
	
	public JPanel get() {
		return this;
	}

}
