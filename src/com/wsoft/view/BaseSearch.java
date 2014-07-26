package com.wsoft.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class BaseSearch extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton clearBtn;
	public JButton searchBtn;
	protected JMenuBar basicOperationsBar;
	public BaseSearch() {
		setBounds(100, 100, 450, 300);
		this.basicOperationsBar = new JMenuBar();
		this.setJMenuBar(this.basicOperationsBar);
		
		this.searchBtn = new JButton("Pretra\u017Ei");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/cog.png")));
		basicOperationsBar.add(searchBtn);
		
		this.clearBtn = new JButton("Poni\u0161ti pretragu");
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clearBtn.setIcon(new ImageIcon(BaseForm.class
				.getResource("/icons/integration.png")));
		basicOperationsBar.add(clearBtn);
	}

}
