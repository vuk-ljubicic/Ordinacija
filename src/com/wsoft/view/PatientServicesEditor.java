package com.wsoft.view;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.PatientServicesEditorCtrl;
import com.wsoft.view.action.EventHandle;


public class PatientServicesEditor extends BaseGridEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UtilDateModel model;
	public JDatePickerImpl datum;
	public JTextField idZuba;
	public JTextField povrsine;
	public JTextField napomena;
	public JComboBox idStom;
	public JComboBox dijagnoza;
	public JComboBox usluga;
	public JComboBox materijal;
	private JLabel lblId;
	public JTextField increment;

	public PatientServicesEditor() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.addActionListener(new EventHandle() {
			public void handleEvent(ActionEvent e) throws Exception{
				PatientServicesEditorCtrl ctrl = (PatientServicesEditorCtrl)CtrlCache.getCtrl(PatientServicesEditorCtrl.class);
				ctrl.save();
			}
		});
		setBounds(100, 100, 918, 492);
		setTitle("Izvr\u0161ena intervencija");
		CtrlCache.addView(PatientServicesEditorCtrl.class, this);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblId, "2, 2, right, default");
		
		increment = new JTextField();
		increment.setEditable(false);
		getContentPane().add(increment, "4, 2, fill, default");
		increment.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Stomatolog");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel, "2, 4, right, default");
		
		idStom = new JComboBox();
		idStom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idStom.setEditable(true);
		getContentPane().add(idStom, "4, 4, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Datum");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_1, "2, 6, right, default");
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datum = new JDatePickerImpl(datePanel);
		datum.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(datum, "4, 6, fill, default");
		
		JLabel lblNewLabel_2 = new JLabel("Zub");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_2, "2, 8, right, default");
		
		idZuba = new JTextField();
		idZuba.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(idZuba, "4, 8, fill, default");
		idZuba.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dijagnoza");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_3, "2, 10, right, default");
		
		dijagnoza = new JComboBox();
		dijagnoza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dijagnoza.setEditable(true);
		getContentPane().add(dijagnoza, "4, 10, fill, default");
		
		JLabel lblNewLabel_4 = new JLabel("Intervencija");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_4, "2, 12, right, default");
		
		usluga = new JComboBox();
		usluga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usluga.setEditable(true);
		getContentPane().add(usluga, "4, 12, fill, default");
		
		JLabel lblMaterijal = new JLabel("Materijal");
		lblMaterijal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblMaterijal, "2, 14, right, default");
		
		materijal = new JComboBox();
		materijal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		materijal.setEditable(true);
		getContentPane().add(materijal, "4, 14, fill, default");
		
		JLabel lblPovrine = new JLabel("Povr\u0161ine");
		lblPovrine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblPovrine, "2, 16, right, default");
		
		povrsine = new JTextField();
		povrsine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(povrsine, "4, 16, fill, default");
		povrsine.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Napomena");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_5, "2, 18, right, default");
		
		napomena = new JTextField();
		napomena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(napomena, "4, 18, fill, default");
		napomena.setColumns(10);

	}
}
