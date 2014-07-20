package com.wsoft.view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.PatientServicesCtrl;


public class PatientServices extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public PatientServices() {
		CtrlCache.addView(PatientServicesCtrl.class, this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
