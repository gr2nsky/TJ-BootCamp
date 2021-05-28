/* //CustomListViewItem.java//
 * 
 * 토이프로젝트의 아이템 그대로 복붛 및 주석처리
 * [1.0] 2021-04-29 윤재필
 * 
 */
package com.testProject.main;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomListViewItem extends JPanel {
	private JLabel lblName;
	private JLabel lblImage;
	private JTextField tfContent;
	private JButton btnSubmit;
	
	//패널의 정보들을 저장
	String id;
	String name;
	BufferedImage bufferedImage;
	String content = "";

	//생성시 패널의 아이템을 부착하고 id, name, photo, content를 저장
	public CustomListViewItem(String id, String name, BufferedImage photo, String content) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tfMouseExited();
			}
		});
		setBorder(null);
		this.id = id;
		this.name = name;
		this.bufferedImage = photo;
		this.content = content;
		
		setLayout(null);
		setSize(390,80);
		add(getLblName());
		add(getLblImage());
		add(getTfContent());
		add(getBtnSubmit());
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel(name);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(14, 58, 61, 16);
		}
		return lblName;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel();
			lblImage.setBounds(14, 6, 61, 48);
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imageIcon = new ImageIcon(bufferedImage);
			Image image = imageIcon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
			lblImage.setIcon(new ImageIcon(image));
		}
		return lblImage;
	}
	private JTextField getTfContent() {
		if (tfContent == null) {
			tfContent = new JTextField();
			tfContent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfClieckEvnet();
				}
			});
			tfContent.setBounds(87, 6, 297, 48);
			tfContent.setColumns(10);
			tfContent.setText(content);
		}
		return tfContent;
	}
	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton("등록");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					submitComment();
				}
			});
			btnSubmit.setBackground(Color.DARK_GRAY);
			btnSubmit.setBounds(335, 53, 45, 21);
			btnSubmit.setVisible(false);
		}
		return btnSubmit;
	}
	
	//text feild 클릭시 버튼 가시화
	private void tfClieckEvnet() {
		System.out.println("[해당 패널 정보]" + id + " : " + content);		
		btnSubmit.setVisible(true);
	}
	
	//마우스가 패널 밖으로 갔을 시, content 초가화 및 등록버튼 비가시화
	private void tfMouseExited() {
		tfContent.setText(content);
		btnSubmit.setVisible(false);
	}
	
	//등록바튼 클릭시, 저장된 content값이 없다면 Insert, 있다면 update
	//*sender id받아오도록 수정해야 + 조이름까지
	private void submitComment() {
		GetImage gi = new GetImage();
		String input = tfContent.getText();
		System.out.println("taget : " + id + ", comment = " + input);
		
		if (content == null) {
			System.out.println("run insert");
			//*sender id받아오도록 수정해야 + 조이름까지
			if (gi.commentInsert(id, "dbswovlf2009", input.trim())) {
				JOptionPane.showMessageDialog(null, "코멘트 등록이 완료되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "코멘트 등록에 실패했습니다.");
			}
		} else {
			System.out.println("[run update]");
			//*sender id받아오도록 수정해야 + 조이름까지
			if(gi.commentUpdate(id, "dbswovlf2009", input.trim())) {
				JOptionPane.showMessageDialog(null, "코멘트 등록이 완료되었습니다.");
				content = input.trim();
				tfContent.setText(input.trim());
			} else {
				JOptionPane.showMessageDialog(null, "코멘트 등록에 실패했습니다.");
			}
		}
	}
}
