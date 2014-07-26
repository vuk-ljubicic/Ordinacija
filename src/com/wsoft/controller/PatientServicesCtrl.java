package com.wsoft.controller;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.wsoft.model.ExecutedService;
import com.wsoft.model.HibernateProxy;
import com.wsoft.view.Main;
import com.wsoft.view.PatientServices;
import com.wsoft.view.PatientServicesEditor;
import com.wsoft.view.action.EventHandle;
import com.wsoft.view.components.TableImpl;
import com.wsoft.view.components.TableModelImpl;

public class PatientServicesCtrl extends GridCtrl implements
		ModelListLoadable<Map<String, Object>> {

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
		String sql = "select u.Datum, u.IDZuba, u.Dijagnoza, d.NazivDijagnoze, u.Usluga, us.NazUsl, u.Materijal, m.NazMat, u.Povrsine, "
				+ "u.Napomena, u.IDStom, s.Prez, s.Ime from IzvedeneIntUsl u left outer join Usluga us on u.Usluga = us.IDUsl "
				+ "left outer join tblDijagnoza d on u.Dijagnoza = d.IdDijagnoze left outer join Materijal m on m.IDMat = u.Materijal "
				+ "left outer join Stomatolog s on s.IDStom = u.IDStom where "
				+ "u.IDPac = :idPac";
		SQLQuery query = HibernateProxy.session().createSQLQuery(sql);
		query.setLong("idPac", this.idPac);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> results = query.list();
		if (results != null && !results.isEmpty()) {
			this.loadToView(results);
		}
	}

	@Override
	public void loadToView(List<Map<String, Object>> models) {
		Vector tableData = new Vector();
		for (Map<String, Object> executedService : models) {
			Vector tableRow = new Vector();
			tableRow.add(executedService.get("DATUM"));
			tableRow.add(executedService.get("IDZUBA"));
			tableRow.add(executedService.get("NAZIVDIJAGNOZE"));
			tableRow.add(executedService.get("NAZUSL"));
			tableRow.add(executedService.get("NAZMAT"));
			tableRow.add(executedService.get("POVRSINE"));
			tableRow.add(executedService.get("NAPOMENA"));
			tableRow.add(((String)executedService.get("IME"))+" "+((String)executedService.get("PREZ")));
			tableRow.add(executedService.get("IDSTOM"));
			tableRow.add(executedService.get("DIJAGNOZA"));
			tableRow.add(executedService.get("USLUGA"));
			tableRow.add(executedService.get("MATERIJAL"));
			tableData.add(tableRow);
		}
		this.tableModel = new TableModelImpl(tableData, this.getColumnNames(),
				this);
		this.table.setModel(this.tableModel);
	}

	@Override
	public List<Map<String, Object>> unloadFromView() {
		List<Map<String, Object>> row = new ArrayList<Map<String, Object>>();
		int selectedRowIndex = this.table.getSelectedRow();
		selectedRowIndex = this.table.convertRowIndexToModel(selectedRowIndex);
		Date datum = (Date)this.tableModel.getValueAt(selectedRowIndex, 0);
		Long idZuba = new Long((Integer)this.tableModel.getValueAt(selectedRowIndex, 1));
		Long usluga = new Long((Integer)this.tableModel.getValueAt(selectedRowIndex, 10));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("DATUM", datum);
		map.put("IDZUBA", idZuba);
		map.put("USLUGA", usluga);
		row.add(map);
		return row;
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
			for(Object column: row){
				if(column != null){
					
				}
				else
				{
					
				}
			}
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
		columnNames.add("IdStomatologa");
		columnNames.add("IdDijagnoze");
		columnNames.add("IdUsluge");
		columnNames.add("IdMaterijala");
		return columnNames;
	}

	@Override
	public List<Class> getColumnClassTypes() {
		ArrayList<java.lang.Class> classes = new ArrayList<java.lang.Class>();
		classes.add(java.util.Date.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.String.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.Long.class);
		classes.add(java.lang.Long.class);
		return classes;
	}

	@Override
	public List<Integer> hiddenColumns() {
		ArrayList<Integer> hiddenColumns = new ArrayList<Integer>();
		hiddenColumns.add(8);
		hiddenColumns.add(9);
		hiddenColumns.add(10);
		hiddenColumns.add(11);
		return hiddenColumns;
	}

	@Override
	public void create() {
		PatientServicesEditorCtrl ctrl = (PatientServicesEditorCtrl)CtrlCache.getCtrl(PatientServicesEditorCtrl.class);
		ctrl.idPac = this.idPac;
		Main.openFrame(PatientServicesEditor.class, 1000, 350);
	}

	@Override
	public void delete() {
		List<Map<String, Object>> model = this.unloadFromView();
		Query query = HibernateProxy
				.session()
				.createQuery(
						"from com.wsoft.model.ExecutedService where datum = :dat and "
								+ "usluga = :usl and idZuba = :idZub and idPac = :idPa");
		query.setDate("dat", (Date)model.get(0).get("DATUM"));
		query.setLong("usl", (Long)model.get(0).get("USLUGA"));
		query.setLong("idZub", (Long)model.get(0).get("IDZUBA"));
		query.setLong("idPa", this.idPac);
		List<ExecutedService> data = query.list();
		ExecutedService executedService = data.get(0);
		 HibernateProxy
			.session().delete(executedService);
		 try {
			this.view.setClosed(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		EventHandle.baseFrame = this.view.getClass();
		EventHandle.x = 10;
		EventHandle.y = 250;
	}

	@Override
	public void change() {
		List<Map<String, Object>> model = this.unloadFromView();
		PatientServicesEditorCtrl ctrl = (PatientServicesEditorCtrl)CtrlCache.getCtrl(PatientServicesEditorCtrl.class);
		ctrl.idPac = this.idPac;
		ctrl.datum = (Date)model.get(0).get("DATUM");
		ctrl.idZuba =(Long)model.get(0).get("IDZUBA");
		ctrl.usluga =(Long)model.get(0).get("USLUGA");
		Main.openFrame(PatientServicesEditor.class, 1000, 350);
	}

}
