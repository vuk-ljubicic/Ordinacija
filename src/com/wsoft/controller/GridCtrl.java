package com.wsoft.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;

public abstract class GridCtrl extends BaseCtrl implements ListSelectionListener, TableModelListener {
	public abstract Vector<String> getColumnNames();
	public abstract List<java.lang.Class> getColumnClassTypes();
	public abstract List<Integer> hiddenColumns();
}
