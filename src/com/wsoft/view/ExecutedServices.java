package com.wsoft.view;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;
import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.DefaultCtrl;


public class ExecutedServices extends BaseForm {

	private static final long serialVersionUID = 1L;
	private JTextField patient;
	private JDatePickerImpl date;
	private JTextField tooth;
	private JTextField diagnosis;
	private JTextField intervention;
	private JTextField material;
	private JTextField surface;
	private JTextField note;
	private JTextField dentist;

	public ExecutedServices() {
		CtrlCache.addView(DefaultCtrl.class, this);
		setTitle("Izvr\u0161ene usluge");
		BorderLayout border = new BorderLayout(0, 0);
		getContentPane().setLayout(border);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("150px", true), Sizes.constant("160px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("130px", true), Sizes.constant("130px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("10px", true), Sizes.constant("15px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("120px", true), Sizes.constant("130px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("160px", true), Sizes.constant("170px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("150px", true), Sizes.constant("160px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("20px", true), Sizes.constant("30px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("100px", true), Sizes.constant("110px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("100px", true), Sizes.constant("110px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Pacijent");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel, "2, 2");
		
		JLabel lblNewLabel_1 = new JLabel("Datum");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1, "4, 2");
		
		JLabel lblNewLabel_2 = new JLabel("Zub");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_2, "6, 2");
		
		JLabel lblNewLabel_3 = new JLabel("Dijagnoza");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_3, "8, 2");
		
		JLabel lblNewLabel_4 = new JLabel("Intervencija");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_4, "10, 2");
		
		JLabel lblNewLabel_5 = new JLabel("Materijal");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_5, "12, 2");
		
		JLabel lblNewLabel_6 = new JLabel("Povr\u0161ine");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_6, "14, 2");
		
		JLabel lblNewLabel_7 = new JLabel("Napomena");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_7, "16, 2");
		
		JLabel lblNewLabel_8 = new JLabel("Stomatolog");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_8, "18, 2");
		
		patient = new JTextField();
		patient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(patient, "2, 4, fill, default");
		patient.setColumns(6);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		
		date = new JDatePickerImpl(datePanel);
		panel.add(date, "4, 4, fill, default");
		
		tooth = new JTextField();
		tooth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(tooth, "6, 4, fill, default");
		tooth.setColumns(1);
		
		diagnosis = new JTextField();
		diagnosis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(diagnosis, "8, 4, fill, default");
		diagnosis.setColumns(4);
		
		intervention = new JTextField();
		intervention.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(intervention, "10, 4, fill, default");
		intervention.setColumns(6);
		
		material = new JTextField();
		material.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(material, "12, 4, fill, default");
		material.setColumns(5);
		
		surface = new JTextField();
		surface.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(surface, "14, 4, fill, default");
		surface.setColumns(2);
		
		note = new JTextField();
		note.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(note, "16, 4, fill, default");
		note.setColumns(5);
		
		dentist = new JTextField();
		dentist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(dentist, "18, 4, fill, default");
		dentist.setColumns(4);

	}

}
