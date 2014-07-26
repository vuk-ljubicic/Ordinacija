package com.wsoft.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.PatientServicesCtrl;
import com.wsoft.view.action.EventHandle;


public class PatientServices extends BaseGrid {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public PatientServices() {
		deleteBtn.addActionListener(new EventHandle() {
			public void handleEvent(ActionEvent e) {
				PatientServicesCtrl ctrl = (PatientServicesCtrl)CtrlCache.getCtrl(PatientServicesCtrl.class);
				ctrl.delete();
			}
		});
		changeBtn.addActionListener(new EventHandle() {
			public void handleEvent(ActionEvent e) {
				PatientServicesCtrl ctrl = (PatientServicesCtrl)CtrlCache.getCtrl(PatientServicesCtrl.class);
				ctrl.change();
			}
		});
		newBtn.addActionListener(new EventHandle() {
			public void handleEvent(ActionEvent e) {
				PatientServicesCtrl ctrl = (PatientServicesCtrl)CtrlCache.getCtrl(PatientServicesCtrl.class);
				ctrl.create();
			}
		});
		setTitle("Izvr\u0161ene intervencije");
		CtrlCache.addView(PatientServicesCtrl.class, this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
