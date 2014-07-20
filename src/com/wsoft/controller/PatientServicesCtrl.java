package com.wsoft.controller;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.hibernate.Query;

import com.wsoft.model.ExecutedService;
import com.wsoft.model.HibernateProxy;
import com.wsoft.view.PatientServices;

public class PatientServicesCtrl extends GridCtrl {

	public String[] patientServicesColumnNames = { "Datum", "Zub", "Dijagnoza",
			"Intervencija", "Materijal", "Povrsine", "Napomena", "Stomatolog" };
	public Object[][] patientServicesTableData = {{"","","","","","","",""}};
	
	public Long idPac;
	
	@Override
	public void loadView() {
		PatientServices frame = (PatientServices)this.view;
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

}
