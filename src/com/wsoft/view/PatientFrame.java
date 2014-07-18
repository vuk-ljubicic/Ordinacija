package com.wsoft.view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
import com.wsoft.controller.PatientCtrl;


public class PatientFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton workPlanBtn;
	public JButton dentalRecordsBtn;
	public JButton executedServicesBtn;
	public JTextField idPac;
	public JDatePickerImpl datUp;
	public JTextField prez;
	public JTextField ime;
	public JTextField godRod;
	public JTextField licniBroj;
	public JTextField zan;
	public JTextField adr;
	public JTextField telPri;
	public JTextField telMob;
	public JTextField telSlu;
	public JTextField pager;
	public JTextField akutObNap;
	public JTextField alergNap;
	public JTextField hroObNap;
	public JTextField lekNap;
	public JCheckBox akutOb;
	public JCheckBox alerg;
	public JCheckBox hroOb;
	public JCheckBox lek;
	public JCheckBox opt;
	public JCheckBox maksSin;
	public JButton scanedImagesbtn;
	public JCheckBox teleRtg;
	public JCheckBox vilZglob;
	public UtilDateModel model;

	/**
	 * Create the frame.
	 */
	public PatientFrame() {
		setTitle("Pacijent");
		final PatientFrame patientFrame = this;
		lastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.last();
			}
		});
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.next();
			}
		});
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.previous();
			}
		});
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.first();
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.search();
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.delete();
			}
		});
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.save();
			}
		});
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.change();
			}
		});
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.create();
			}
		});
		CtrlCache.addView("com.wsoft.controller.PatientCtrl", this);
		setBounds(100, 100, 885, 494);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("ID broj");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel, "2, 2, right, default");
		
		idPac = new JTextField();
		idPac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(idPac, "4, 2, fill, default");
		idPac.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Datum upisivanja");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_1, "6, 2, right, default");
		
		
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		
		datUp = new JDatePickerImpl(datePanel);
		datUp.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));

		panel_3.add(datUp, "8, 2, fill, default");
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_2, "2, 4, right, default");
		
		prez = new JTextField();
		prez.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(prez, "4, 4, fill, default");
		prez.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ime");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_3, "6, 4, right, default");
		
		ime = new JTextField();
		ime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(ime, "8, 4, fill, default");
		ime.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Godina ro\u0111enja");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_4, "2, 6, right, default");
		
		godRod = new JTextField();
		godRod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(godRod, "4, 6, fill, default");
		godRod.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Li\u010Dni broj");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_5, "2, 8, right, default");
		
		licniBroj = new JTextField();
		licniBroj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(licniBroj, "4, 8, fill, default");
		licniBroj.setColumns(10);
		
		JLabel lblZanimanje = new JLabel("Zanimanje");
		lblZanimanje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblZanimanje, "2, 10, right, default");
		
		zan = new JTextField();
		zan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(zan, "4, 10, fill, default");
		zan.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblAdresa, "2, 12, right, default");
		
		adr = new JTextField();
		adr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(adr, "4, 12, fill, default");
		adr.setColumns(10);
		
		workPlanBtn = new JButton("Plan rada");
		workPlanBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(workPlanBtn, "2, 16");
		
		dentalRecordsBtn = new JButton("Zubna kartoteka");
		dentalRecordsBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(dentalRecordsBtn, "4, 16");
		
		executedServicesBtn = new JButton("Izvr\u0161ene intervencije");
		executedServicesBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		executedServicesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCtrl ctrl = (PatientCtrl)CtrlCache.getCtrl(patientFrame.getViewId());
				ctrl.showExecutedServices();
			}
		});
		panel_3.add(executedServicesBtn, "6, 16");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Kontakt", null, panel, null);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("150px", true), Sizes.constant("160px", true)), 1),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_6 = new JLabel("Privatni telefon");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_6, "6, 2, right, default");
		
		telPri = new JTextField();
		telPri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(telPri, "8, 2, fill, default");
		telPri.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mobilni telefon");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_7, "6, 4, right, default");
		
		telMob = new JTextField();
		telMob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(telMob, "8, 4, fill, default");
		telMob.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Slu\u017Ebeni telefon");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_8, "6, 6, right, default");
		
		telSlu = new JTextField();
		telSlu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(telSlu, "8, 6, fill, default");
		telSlu.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Pejd\u017Eer");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_9, "6, 8, right, default");
		
		pager = new JTextField();
		pager.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(pager, "8, 8, fill, default");
		pager.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Medicinska upozorenja", null, panel_1, null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		akutOb = new JCheckBox("Akutna oboljenja");
		akutOb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(akutOb, "8, 4");
		
		JLabel lblNewLabel_10 = new JLabel("Navesti detalje");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_10, "10, 4, right, default");
		
		akutObNap = new JTextField();
		akutObNap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(akutObNap, "12, 4, fill, default");
		akutObNap.setColumns(10);
		
		alerg = new JCheckBox("Alergija na medikamente");
		alerg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(alerg, "8, 6");
		
		JLabel lblNewLabel_11 = new JLabel("Navesti detalje");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_11, "10, 6, right, default");
		
		alergNap = new JTextField();
		alergNap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(alergNap, "12, 6, fill, default");
		alergNap.setColumns(10);
		
		hroOb = new JCheckBox("Hroni\u010Dna oboljenja");
		hroOb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(hroOb, "8, 8");
		
		JLabel lblNewLabel_12 = new JLabel("Navesti detalje");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_12, "10, 8, right, default");
		
		hroObNap = new JTextField();
		hroObNap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(hroObNap, "12, 8, fill, default");
		hroObNap.setColumns(10);
		
		lek = new JCheckBox("Uzima lekove");
		lek.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lek, "8, 10");
		
		JLabel lblNewLabel_13 = new JLabel("Navesti detalje");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_13, "10, 10, right, default");
		
		lekNap = new JTextField();
		lekNap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lekNap, "12, 10, fill, default");
		lekNap.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Snimci", null, panel_2, null);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		opt = new JCheckBox("OPT");
		opt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(opt, "12, 4");
		
		maksSin = new JCheckBox("Maksilarni sinusi");
		maksSin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(maksSin, "18, 4, default, center");
		
		scanedImagesbtn= new JButton("Skenirani snimci");
		scanedImagesbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(scanedImagesbtn, "22, 6");
		
		teleRtg = new JCheckBox("Telerentgen");
		teleRtg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(teleRtg, "12, 8");
		
		vilZglob = new JCheckBox("Vili\u010Dni zglob");
		vilZglob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(vilZglob, "18, 8");
	}

	@Override
	public String getViewId() {
		// TODO Auto-generated method stub
		return "patientFrm";
	}

}
