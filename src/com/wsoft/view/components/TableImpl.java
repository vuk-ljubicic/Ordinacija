package com.wsoft.view.components;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.GridCtrl;

public class TableImpl extends JTable {
	
	private static final long serialVersionUID = -1775040938560945979L;
	private GridCtrl gridCtrl;
	
	public TableImpl(GridCtrl gridCtrl){
		super();
		this.gridCtrl = gridCtrl;
		this.setSelectionListener((ListSelectionListener)gridCtrl);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
	
	private void setSelectionListener(ListSelectionListener listener){
		ListSelectionModel listSelectionModel = this.getSelectionModel();
        listSelectionModel.addListSelectionListener(listener);
	}
	
	@Override
	public void setModel(TableModel dataModel){
		super.setModel(dataModel);
		
		this.getModel().addTableModelListener((TableModelListener)gridCtrl);
		if(dataModel.getRowCount() > 0)
			this.setRowSelectionInterval(0, 0);
		if(this.columnModel.getColumns().hasMoreElements()){
			this.hideColumns();
		}	
	}
	
	private void hideColumns(){
		for(Integer hiddenColumn: gridCtrl.hiddenColumns()){
			this.columnModel.getColumn(hiddenColumn).setMinWidth(0);
			this.columnModel.getColumn(hiddenColumn).setMaxWidth(0);
			this.columnModel.getColumn(hiddenColumn).setPreferredWidth(0);
		}
	}
}
