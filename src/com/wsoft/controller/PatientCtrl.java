package com.wsoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JToggleButton;
import javax.swing.text.JTextComponent;

import org.hibernate.Query;

import com.wsoft.model.BaseModel;
import com.wsoft.model.HibernateProxy;
import com.wsoft.model.Patient;
import com.wsoft.view.Main;
import com.wsoft.view.PatientFrame;
import com.wsoft.view.PatientServices;

public class PatientCtrl extends FormCtrl implements ModelLoadable{

	@Override
	public void create() {
		super.create();
		Patient patient = new Patient();
		HibernateProxy.session().save(patient);
		HibernateProxy.commitTransaction();
		HibernateProxy.beginTransaction();
		this.loadToView(this.selectWithMaxId());
	}

	public Patient selectWithMaxId(){
		Query query = HibernateProxy
				.session()
				.createQuery(
						"from com.wsoft.model.Patient p where p.idPac in (select max(p1.idPac) "
								+ "from com.wsoft.model.Patient p1)");
		List<Patient> patients = query.list();
		if (patients != null && !patients.isEmpty()) {
			return patients.get(0);
		} else{
			return null;
		}
	}
	
	@Override
	public void delete() {
		Patient patient = (Patient) this.unloadFromView();
		HibernateProxy.delete(patient);
		this.previous();
		this.next();
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		super.save();
		Patient patient = (Patient) this.unloadFromView();
		HibernateProxy.merge(patient);
		this.loadToView(patient);

	}

	@Override
	public void change() {
		super.change();
	}

	@Override
	public void first() {
		super.first();
		this.load();
	}

	@Override
	public void previous() {
		Patient patient = (Patient) this.unloadFromView();
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
		Patient patient = (Patient) this.unloadFromView();
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
	public void loadView() {
		this.first();
		this.load();
	}
	
	public void load(){
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Patient p where p.idPac in (select min(p1.idPac) "
						+ "from com.wsoft.model.Patient p1)");
		List<Patient> patients = query.list();
		if (patients != null && !patients.isEmpty()) {
			loadToView(patients.get(0));
		}
	}

	public void showExecutedServices() {
		Patient patient = (Patient) this.unloadFromView();
		Long idPac = patient.getIdPac();
		PatientServicesCtrl patientServicesCtrl = (PatientServicesCtrl)CtrlCache.getCtrl(PatientServicesCtrl.class);
		patientServicesCtrl.idPac = idPac;
		Main.openFrame(PatientServices.class, 10, 250);
	}

	@Override
	public List<JTextComponent> alwaysLocked() {
		List<JTextComponent> lockedComponents = new ArrayList<JTextComponent>();
		PatientFrame frame = (PatientFrame) this.view;
		lockedComponents.add(frame.idPac);
		return lockedComponents;
	}

	@Override
	public void loadToView(BaseModel model) {
		Patient patient = (Patient) model;
		PatientFrame frame = (PatientFrame) this.view;
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
	public BaseModel unloadFromView() {
		Patient patient = new Patient();
		PatientFrame frame = (PatientFrame) this.view;
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
	public List<JToggleButton> alwaysDisabled() {
		return null;
	}

}
