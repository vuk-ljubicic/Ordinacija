package com.wsoft.view.components;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.wsoft.controller.GridCtrl;

public class TableModelImpl extends DefaultTableModel{
	/**
	 * 
	 */
	private GridCtrl ctrl;
	private static final long serialVersionUID = -6747793932812316170L;
	public TableModelImpl(Vector data, Vector columnNames, GridCtrl ctrl) {
        super(data, columnNames);
        this.ctrl = ctrl;
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
    }
	@Override
	public Class getColumnClass(int c) {
        return this.ctrl.getColumnClassTypes().get(c);
    }
}
