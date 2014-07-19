package com.wsoft.view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.PatientCtrl;


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
		CtrlCache.addView("com.wsoft.controller.PatientCtrl", this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(this.getViewId());
		table = new JTable(ctrl.patientServicesTableData, ctrl.patientServicesColumnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public String getViewId() {
		return "patientServicesFrm";
	}

}
