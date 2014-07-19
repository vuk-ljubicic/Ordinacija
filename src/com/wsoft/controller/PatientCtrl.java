package com.wsoft.controller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.JTextComponent;

import org.hibernate.Query;

import com.wsoft.model.BaseModel;
import com.wsoft.model.ExecutedService;
import com.wsoft.model.HibernateProxy;
import com.wsoft.model.Patient;
import com.wsoft.view.Main;
import com.wsoft.view.PatientFrame;
import com.wsoft.view.PatientServices;

public class PatientCtrl extends FormCtrl {

	public String[] patientServicesColumnNames = { "Datum", "Zub", "Dijagnoza",
			"Intervencija", "Materijal", "Povrsine", "Napomena", "Stomatolog" };
	public Object[][] patientServicesTableData = {{"","","","","","","",""}};

	@Override
	public void create() {
		this.create("patientFrm");
		Patient patient = new Patient();
		HibernateProxy.beginTransaction();
		HibernateProxy.merge(patient);
		HibernateProxy.persist(patient);
		HibernateProxy.commitTransaction();
		HibernateProxy.session().close();
		this.loadToView(patient);
	}

	@Override
	public void delete() {
		Patient patient = (Patient) this.unloadSingleFromView();
		HibernateProxy.beginTransaction();
		HibernateProxy.delete(patient);
		HibernateProxy.commitTransaction();
		this.previous();
		this.next();
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		this.save("patientFrm");
		Patient patient = (Patient) this.unloadSingleFromView();
		HibernateProxy.beginTransaction();
		HibernateProxy.merge(patient);
		HibernateProxy.commitTransaction();
		this.loadToView(patient);

	}

	@Override
	public void change() {
		this.change("patientFrm");
	}

	@Override
	public void first() {
		this.loadView("patientFrm");

	}

	@Override
	public void previous() {
		Patient patient = (Patient) this.unloadSingleFromView();
		Long idPac = patient.getIdPac();
		Query query = HibernateProxy
				.session()
				.createQuery(
						"from com.wsoft.model.Patient p where p.idPac in (select max(p1.idPac) "
								+ "from com.wsoft.model.Patient p1 where p1.idPac < :idPac)");
		query.setLong("idPac", idPac);
		List<Patient> patients = query.list();
		if (patients != null && !patients.isEmpty()) {
			loadToView(patients.get(0));
		}

	}

	@Override
	public void next() {
		Patient patient = (Patient) this.unloadSingleFromView();
		Long idPac = patient.getIdPac();
		Query query = HibernateProxy
				.session()
				.createQuery(
						"from com.wsoft.model.Patient p where p.idPac in (select min(p1.idPac) "
								+ "from com.wsoft.model.Patient p1 where p1.idPac > :idPac)");
		query.setLong("idPac", idPac);
		List<Patient> patients = query.list();
		if (patients != null && !patients.isEmpty()) {
			loadToView(patients.get(0));
		}
	}

	@Override
	public void last() {
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Patient p where p.idPac in (select max(p1.idPac) "
						+ "from com.wsoft.model.Patient p1)");
		List<Patient> patients = query.list();
		if (patients != null && !patients.isEmpty()) {
			loadToView(patients.get(0));
		}

	}

	@Override
	public void loadView(String viewId) {
		if (viewId.equals("patientFrm")) {
			this.loadPatientView();
		}
		if (viewId.equals("patientServicesFrm")) {
			this.loadPatientServicesView();
		}

	}
	
	public void loadPatientServicesView(){
		PatientServices frame = (PatientServices)this.view.get("patientServicesFrm");
		Patient patient = (Patient) this.unloadSingleFromView();
		Long idPac = patient.getIdPac();
		Query query = HibernateProxy.session().createQuery("from com.wsoft.model.ExecutedService s where "
				+ "s.idPac = :idPac");
		query.setLong("idPac", idPac);
		List<ExecutedService> services = query.list();
		if (services != null && !services.isEmpty()) {
			this.patientServicesTableData = new Object[services.size()][];
			for(int i=0; i<services.size(); i++){
				this.patientServicesTableData[i] = new Object[8];
				this.patientServicesTableData[i][0] = services.get(i).getDatum();
				this.patientServicesTableData[i][1] = services.get(i).getIdZuba();
				this.patientServicesTableData[i][2] = services.get(i).getDijagnoza();
				this.patientServicesTableData[i][3] = services.get(i).getUsluga();
				this.patientServicesTableData[i][4] = services.get(i).getMaterijal();
				this.patientServicesTableData[i][5] = services.get(i).getPovrsine();
				this.patientServicesTableData[i][6] = services.get(i).getNapomena();
				this.patientServicesTableData[i][7] = services.get(i).getIdStom();
			}
		}
		frame.table = new JTable(patientServicesTableData, patientServicesColumnNames);
		frame.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		frame.scrollPane.getViewport().add(frame.table);
		frame.scrollPane.repaint();
		AbstractTableModel tableModel = (AbstractTableModel)frame.table.getModel();
		tableModel.fireTableDataChanged();
	}
	
	public void loadPatientView(){
		this.first("patientFrm");
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Patient p where p.idPac in (select min(p1.idPac) "
						+ "from com.wsoft.model.Patient p1)");
		List<Patient> patients = query.list();
		if (patients != null && !patients.isEmpty()) {
			loadToView(patients.get(0));
		}
	}

	public void showExecutedServices() {
		Main.openFrame("com.wsoft.view.PatientServices", 400, 500);
	}

	@Override
	public List<JTextComponent> alwaysLocked() {
		List<JTextComponent> lockedComponents = new ArrayList<JTextComponent>();
		PatientFrame frame = (PatientFrame) this.view.get("patientFrm");
		lockedComponents.add(frame.idPac);
		return lockedComponents;
	}

	@Override
	public void loadToView(BaseModel model) {
		Patient patient = (Patient) model;
		PatientFrame frame = (PatientFrame) this.view.get("patientFrm");
		frame.adr.setText(patient.getAdr());
		frame.idPac.setText(patient.getIdPac().toString());
		frame.akutOb.setSelected(patient.getAkutOb());
		frame.akutObNap.setText(patient.getAkutObNap());
		frame.alerg.setSelected(patient.getAlerg());
		frame.alergNap.setText(patient.getAlergNap());
		frame.model.setValue(patient.getDatUp());
		frame.godRod.setText(patient.getGodRod().toString());
		frame.hroOb.setSelected(patient.getHroOb());
		frame.hroObNap.setText(patient.getHroObNap());
		frame.ime.setText(patient.getIme());
		frame.lek.setSelected(patient.getLek());
		frame.lekNap.setText(patient.getLekNap());
		frame.licniBroj.setText(patient.getLicniBroj());
		frame.maksSin.setSelected(patient.getMaksSin());
		frame.opt.setSelected(patient.getOpt());
		frame.pager.setText(patient.getPager());
		frame.prez.setText(patient.getPrez());
		frame.teleRtg.setSelected(patient.getTeleRtg());
		frame.telMob.setText(patient.getTelMob());
		frame.telPri.setText(patient.getTelPri());
		frame.telSlu.setText(patient.getTelSlu());
		frame.vilZglob.setSelected(patient.getVilZglob());
		frame.zan.setText(patient.getZan());
	}

	@Override
	public BaseModel unloadSingleFromView() {
		Patient patient = new Patient();
		PatientFrame frame = (PatientFrame) this.view.get("patientFrm");
		patient.setAdr(frame.adr.getText());
		patient.setIdPac(new Long(frame.idPac.getText()));
		patient.setAkutOb(frame.akutOb.isSelected());
		patient.setAkutObNap(frame.akutObNap.getText());
		patient.setAlerg(frame.alerg.isSelected());
		patient.setAlergNap(frame.alergNap.getText());
		patient.setDatUp(frame.model.getValue());
		patient.setGodRod(new Long(frame.godRod.getText()));
		patient.setHroOb(frame.hroOb.isSelected());
		patient.setHroObNap(frame.hroObNap.getText());
		patient.setIme(frame.ime.getText());
		patient.setLek(frame.lek.isSelected());
		patient.setLekNap(frame.lekNap.getText());
		patient.setLicniBroj(frame.licniBroj.getText());
		patient.setMaksSin(frame.maksSin.isSelected());
		patient.setOpt(frame.opt.isSelected());
		patient.setPager(frame.pager.getText());
		patient.setPrez(frame.prez.getText());
		patient.setTeleRtg(frame.teleRtg.isSelected());
		patient.setTelMob(frame.telMob.getText());
		patient.setTelPri(frame.telPri.getText());
		patient.setTelSlu(frame.telSlu.getText());
		patient.setVilZglob(frame.vilZglob.isSelected());
		patient.setZan(frame.zan.getText());
		return patient;
	}

	@Override
	public void loadToView(List<BaseModel> models) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BaseModel> unloadListFromView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadToView(HashMap<String, List<BaseModel>> models) {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, List<BaseModel>> unloadFromView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JToggleButton> alwaysDisabled() {
		// TODO Auto-generated method stub
		return null;
	}

}
