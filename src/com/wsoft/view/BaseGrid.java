package com.wsoft.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class BaseGrid extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JMenuBar basicOperationsBar;
	public JButton newBtn;
	public JButton changeBtn;
	public JButton deleteBtn;
	/**
	 * Create the frame.
	 */
	public BaseGrid() {
		setBounds(100, 100, 889, 466);

		this.basicOperationsBar = new JMenuBar();
		this.setJMenuBar(this.basicOperationsBar);

		this.newBtn = new JButton("Napravi");
		newBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newBtn.setIcon(new ImageIcon(BaseForm.class.getResource("/icons/plus.png")));
		this.basicOperationsBar.add(this.newBtn);

		this.changeBtn = new JButton("Promeni");
		changeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		changeBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/pencil.png")));
		basicOperationsBar.add(changeBtn);

		this.deleteBtn = new JButton("Obri\u0161i");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/sad.png")));
		basicOperationsBar.add(deleteBtn);

	}

}
