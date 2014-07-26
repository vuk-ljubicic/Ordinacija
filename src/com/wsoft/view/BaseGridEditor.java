package com.wsoft.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;


public class BaseGridEditor extends BaseFrame {

	private static final long serialVersionUID = 1L;
	protected JMenuBar basicOperationsBar;
	public JButton saveBtn;
	public BaseGridEditor() {
		setBounds(100, 100, 450, 300);
		this.basicOperationsBar = new JMenuBar();
		this.setJMenuBar(this.basicOperationsBar);
		
		this.saveBtn = new JButton("Sa\u010Duvaj");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setIcon(new ImageIcon(BaseForm.class.getResource("/icons/disk.png")));
		basicOperationsBar.add(saveBtn);
	}

}
