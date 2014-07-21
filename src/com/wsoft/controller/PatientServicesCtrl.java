package com.wsoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;

import org.hibernate.Query;

import com.wsoft.model.ExecutedService;
import com.wsoft.model.HibernateProxy;
import com.wsoft.view.PatientServices;
import com.wsoft.view.components.TableImpl;
import com.wsoft.view.components.TableModelImpl;

public class PatientServicesCtrl extends GridCtrl implements
		ModelListLoadable<ExecutedService> {

	public Long idPac;
	public TableImpl table;
	private TableModelImpl tableModel;

	@Override
	public void loadView() {
		PatientServices frame = (PatientServices) this.view;
		this.table = new TableImpl(this);
		frame.scrollPane.getViewport().add(this.table);
		this.loadData();
	}

	public void loadData() {
		PatientServices frame = (PatientServices) this.view;
		Query query = HibernateProxy.session().createQuery(
				"from com.wsoft.model.ExecutedService s where "
						+ "s.idPac = :idPac");
		query.setLong("idPac", idPac);
		List<ExecutedService> services = query.list();
		if (services != null && !services.isEmpty()) {
			this.loadToView(services);
		}
	}

	@Override
	public void loadToView(List<ExecutedService> models) {
		Vector tableData = new Vector();
		for (ExecutedService executedService : models) {
			Vector tableRow = new Vector();
			tableRow.add(executedService.getDatum());
			tableRow.add(executedService.getIdZuba());
			tableRow.add(executedService.getDijagnoza());
			tableRow.add(executedService.getUsluga());
			tableRow.add(executedService.getMaterijal());
			tableRow.add(executedService.getPovrsine());
			tableRow.add(executedService.getNapomena());
			tableRow.add(executedService.getIdStom());
			tableData.add(tableRow);
		}
		this.tableModel = new TableModelImpl(tableData, this.getColumnNames(),
				this);
		this.table.setModel(this.tableModel);
	}

	@Override
	public List<ExecutedService> unloadFromView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		int rowIndex = e.getLastIndex();
		if (!lsm.isSelectionEmpty()) {
			Vector row = (Vector)this.tableModel.getDataVector().get(rowIndex);
			System.out.println("<row>");
			for(Object column: row){
				if(column != null)
					System.out.println("\t"+column.toString());
				else
					System.out.println("\tnull");
			}
			System.out.println("</row>");
		}
	}

	@Override
	public Vector<String> getColumnNames() {
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Datum");
		columnNames.add("Zub");
		columnNames.add("Dijagnoza");
		columnNames.add("Intervencija");
		columnNames.add("Materijal");
		columnNames.add("Povr\u0161ine");
		columnNames.add("Napomena");
		columnNames.add("Stomatolog");
		return columnNames;
	}

	@Override
	public List<Class> getColumnClassTypes() {
		ArrayList<java.lang.Class> classes = new ArrayList<java.lang.Class>();
		classes.add(java.util.Date.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.Long.class);
		return classes;
	}

	@Override
	public List<Integer> hiddenColumns() {
		ArrayList<Integer> hiddenColumns = new ArrayList<Integer>();
		hiddenColumns.add(0);
		hiddenColumns.add(1);
		hiddenColumns.add(3);
		return hiddenColumns;
	}

}
