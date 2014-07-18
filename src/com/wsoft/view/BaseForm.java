package com.wsoft.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public abstract class BaseForm extends BaseFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JMenuBar basicOperationsBar;
	public JButton newBtn;
	public JButton changeBtn;
	public JButton saveBtn;
	public JButton deleteBtn;
	public JButton searchBtn;
	public JButton firstBtn;
	public JButton previousBtn;
	public JButton nextBtn;
	public JButton lastBtn;

	public BaseForm() {
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

		this.saveBtn = new JButton("Sa\u010Duvaj");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setIcon(new ImageIcon(BaseForm.class.getResource("/icons/disk.png")));
		basicOperationsBar.add(saveBtn);

		this.deleteBtn = new JButton("Obri\u0161i");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/sad.png")));
		basicOperationsBar.add(deleteBtn);

		this.searchBtn = new JButton("Pretra\u017Ei");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/cog.png")));
		basicOperationsBar.add(searchBtn);

		this.firstBtn = new JButton("Prvi");
		firstBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/page-first.gif")));
		basicOperationsBar.add(firstBtn);

		this.previousBtn = new JButton("Prethodni");
		previousBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		previousBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/page-prev.gif")));
		basicOperationsBar.add(previousBtn);

		this.nextBtn = new JButton("Slede\u0107i");
		nextBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nextBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/page-next.gif")));
		basicOperationsBar.add(nextBtn);

		this.lastBtn = new JButton("Poslednji");
		lastBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/page-last.gif")));
		basicOperationsBar.add(lastBtn);

	}

}
