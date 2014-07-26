package com.wsoft.controller;

import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.wsoft.goodies.AutoCompletion;
import com.wsoft.model.BaseModel;
import com.wsoft.model.Dentist;
import com.wsoft.model.Diagnosis;
import com.wsoft.model.ExecutedService;
import com.wsoft.model.HibernateProxy;
import com.wsoft.model.Material;
import com.wsoft.model.Service;
import com.wsoft.view.PatientServices;
import com.wsoft.view.PatientServicesEditor;
import com.wsoft.view.action.EventHandle;

public class PatientServicesEditorCtrl extends BaseCtrl implements
		ModelLoadable {

	public Long idPac;
	public Long idZuba;
	public Long usluga;
	public Date datum;
	private ExecutedService executedService = null;

	private void nullifyParams() {
		this.idPac = null;
		this.idZuba = null;
		this.usluga = null;
		this.datum = null;
		this.executedService= null; 
	}

	private boolean checkifParamsSet() {
		return this.idPac != null && this.idZuba != null && this.usluga != null
				&& this.datum != null;
	}

	@Override
	public void loadView() {
		PatientServicesEditor view = (PatientServicesEditor) this.view;
		this.loadDentists(view);
		this.loadDiagnosis(view);
		this.loadIntervention(view);
		this.loadMaterial(view);
		this.loadData(view);
	}

	private void loadData(PatientServicesEditor view) {
		if(executedService == null) {
			if(checkifParamsSet()){
				Query query = HibernateProxy
						.session()
						.createQuery(
								"from com.wsoft.model.ExecutedService where datum = :dat and "
										+ "usluga = :usl and idZuba = :idZub and idPac = :idPa");
				query.setDate("dat", this.datum);
				query.setLong("usl", this.usluga);
				query.setLong("idZub", this.idZuba);
				query.setLong("idPa", this.idPac);
				List<ExecutedService> data = query.list();
				executedService = data.get(0);
			} else {
				executedService = new ExecutedService();
				executedService.setIdPac(this.idPac);
				HibernateProxy.session().save(executedService);
				HibernateProxy.commitTransaction();
				HibernateProxy.beginTransaction();
				executedService = this.selectWithMaxId();
			}
		}
		this.loadToView(executedService);
	}
	
	public ExecutedService selectWithMaxId(){
		Query query = HibernateProxy
				.session()
				.createQuery(
						"from com.wsoft.model.ExecutedService e where e.increment in (select max(e1.increment) "
								+ "from com.wsoft.model.ExecutedService e1)");
		List<ExecutedService> services = query.list();
		if (services != null && !services.isEmpty()) {
			return services.get(0);
		} else{
			return null;
		}
	}

	private void loadDentists(PatientServicesEditor view) {
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Dentist");
		List<Dentist> data = query.list();
		view.idStom.removeAllItems();
		for (Dentist dentist : data) {
			view.idStom.addItem(dentist);
		}
		AutoCompletion.enable(view.idStom);
	}

	private void loadDiagnosis(PatientServicesEditor view) {
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Diagnosis");
		List<Diagnosis> data = query.list();
		view.dijagnoza.removeAllItems();
		for (Diagnosis diagnosis : data) {
			view.dijagnoza.addItem(diagnosis);
		}
		AutoCompletion.enable(view.dijagnoza);
	}

	private void loadIntervention(PatientServicesEditor view) {
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Service");
		List<Service> data = query.list();
		view.usluga.removeAllItems();
		for (Service service : data) {
			view.usluga.addItem(service);
		}
		AutoCompletion.enable(view.usluga);
	}

	private void loadMaterial(PatientServicesEditor view) {
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.Material");
		List<Material> data = query.list();
		view.materijal.removeAllItems();
		for (Material material : data) {
			view.materijal.addItem(material);
		}
		AutoCompletion.enable(view.materijal);
	}

	public void save() throws Exception{
		ExecutedService executedService = (ExecutedService)this.unloadFromView();
		HibernateProxy.session().merge(executedService);
		PatientServicesCtrl ctrl = (PatientServicesCtrl)CtrlCache.getCtrl(PatientServicesCtrl.class);
		ctrl.view.setClosed(true);
		try {
			this.view.setClosed(true);
		} catch (PropertyVetoException e) {

		}
		this.nullifyParams();
		EventHandle.baseFrame = PatientServices.class;
		EventHandle.x = 10;
		EventHandle.y = 250;
	}

	@Override
	public void loadToView(BaseModel model) {
		ExecutedService executedService = (ExecutedService)model;
		PatientServicesEditor view = (PatientServicesEditor) this.view;
		view.model.setValue(executedService.getDatum());
		for(int i = 0; i<view.dijagnoza.getItemCount(); i++) {
			Diagnosis diagnosis = (Diagnosis)view.dijagnoza.getItemAt(i);
			if(diagnosis.getIdDijagnoze().longValue() == executedService.getDijagnoza().longValue())
				view.dijagnoza.setSelectedItem(diagnosis);
		}
		for(int i = 0; i<view.idStom.getItemCount(); i++) {
			Dentist dentist = (Dentist)view.idStom.getItemAt(i);
			if(dentist.getIdStom().longValue() == executedService.getIdStom().longValue())
				view.idStom.setSelectedItem(dentist);
		}
		for(int i = 0; i<view.materijal.getItemCount(); i++) {
			Material material = (Material)view.materijal.getItemAt(i);
			if(material.getIdMat().longValue() == executedService.getMaterijal().longValue())
				view.materijal.setSelectedItem(material);
		}
		for(int i = 0; i<view.usluga.getItemCount(); i++) {
			Service service = (Service)view.usluga.getItemAt(i);
			if(service.getIdUsl().longValue() == executedService.getUsluga().longValue())
				view.usluga.setSelectedItem(service);
		}
		view.napomena.setText(executedService.getNapomena());
		view.povrsine.setText(executedService.getPovrsine());
		view.idZuba.setText(executedService.getIdZuba().toString());
		view.increment.setText(String.valueOf(executedService.getIncrement()));
		
	}

	@Override
	public BaseModel unloadFromView() {
		PatientServicesEditor view = (PatientServicesEditor) this.view;
		ExecutedService executedService = new ExecutedService();
		executedService.setDatum(view.model.getValue());
		Diagnosis diagnosis = (Diagnosis)view.dijagnoza.getSelectedItem();
		executedService.setDijagnoza(diagnosis.getIdDijagnoze());
		executedService.setIdPac(this.idPac);
		Dentist dentist = (Dentist)view.idStom.getSelectedItem();
		executedService.setIdStom(dentist.getIdStom());
		executedService.setIdZuba(new Long(view.idZuba.getText()));
		Material material = (Material)view.materijal.getSelectedItem();
		executedService.setMaterijal(material.getIdMat());
		executedService.setNapomena(view.napomena.getText());
		executedService.setPovrsine(view.povrsine.getText());
		Service service = (Service)view.usluga.getSelectedItem();
		executedService.setUsluga(service.getIdUsl());
		executedService.setIncrement(new Long(view.increment.getText()));
		return executedService;
	}

}
