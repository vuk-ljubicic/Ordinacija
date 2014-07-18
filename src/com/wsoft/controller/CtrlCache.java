package com.wsoft.controller;

import java.util.HashMap;

import com.wsoft.view.BaseFrame;

public class CtrlCache {
	private static HashMap<String, BaseCtrl> qualifiedClassNameCache = new HashMap<String, BaseCtrl>();
	private static HashMap<String, BaseCtrl> viewNameCache = new HashMap<String, BaseCtrl>();
	private static void addView(String ctrlClassName, String viewId, BaseFrame view){
		BaseCtrl ctrl = null;
		if(qualifiedClassNameCache.containsKey(ctrlClassName)){
			ctrl = qualifiedClassNameCache.get(ctrlClassName);
		} else{
			ctrl = createCtrl(ctrlClassName);
			qualifiedClassNameCache.put(ctrlClassName, ctrl);
		}
		ctrl.addView(viewId, view);
		viewNameCache.put(viewId, ctrl);
	}
	
	public static void addView(String ctrlClassName, BaseFrame view){
		addView(ctrlClassName, view.getViewId(), view);
	}
	
	private static BaseCtrl createCtrl(String ctrlClassName){
		BaseCtrl baseCtrl = null;
		try {
			baseCtrl = (BaseCtrl) Class.forName(ctrlClassName).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return baseCtrl;
	}
	
	public static BaseCtrl getCtrl(String viewId){
		return viewNameCache.get(viewId);
	}
}
