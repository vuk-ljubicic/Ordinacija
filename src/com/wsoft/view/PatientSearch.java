package com.wsoft.view;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.PatientSearchCtrl;
import com.wsoft.view.action.EventHandle;
import java.awt.Font;


public class PatientSearch extends BaseSearch {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField ime;
	private JTextField prez;

	public PatientSearch() {
		clearBtn.addActionListener(new EventHandle() {
			public void handleEvent(ActionEvent e) {
				PatientSearchCtrl ctrl = (PatientSearchCtrl)CtrlCache.getCtrl(PatientSearchCtrl.class);
				ctrl.clear();
			}
		});
		searchBtn.addActionListener(new EventHandle() {
			public void handleEvent(ActionEvent e) {
				PatientSearchCtrl ctrl = (PatientSearchCtrl)CtrlCache.getCtrl(PatientSearchCtrl.class);
				ctrl.search();
			}
		});
		setTitle("Prona\u0111i pacijenta");
		setBounds(100, 100, 450, 300);
		CtrlCache.addView(PatientSearchCtrl.class, this);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel, "2, 4, right, default");
		
		ime = new JTextField();
		ime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(ime, "4, 4, fill, default");
		ime.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_1, "2, 6, right, default");
		
		prez = new JTextField();
		prez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(prez, "4, 6, fill, default");
		prez.setColumns(10);

	}

}
