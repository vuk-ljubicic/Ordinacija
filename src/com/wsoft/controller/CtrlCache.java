package com.wsoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wsoft.view.BaseFrame;

public class CtrlCache {
	private static HashMap<String, BaseCtrl> qualifiedClassNameCache = new HashMap<String, BaseCtrl>();
	private static HashMap<String, List<BaseCtrl>> viewNameCache = new HashMap<String, List<BaseCtrl>>();
	private static void addView(java.lang.Class ctrlClass, String viewId, BaseFrame view) {
		BaseCtrl ctrl = getCtrl(ctrlClass);
		List<BaseCtrl> viewCtrls = null;
		ctrl.view = view;
		if(viewNameCache.containsKey(viewId)) {
			viewCtrls = viewNameCache.get(viewId);
		} else {
			viewCtrls = new ArrayList<BaseCtrl>();
			viewNameCache.put(viewId, viewCtrls);
		}
		viewCtrls.add(ctrl);
	}

	public static void addView(java.lang.Class ctrlClass, BaseFrame view) {
		addView(ctrlClass, view.getClass().getName(), view);
	}

	public static List<BaseCtrl> getViewCtrls(BaseFrame view){
		return viewNameCache.get(view.getClass().getName());
	}
	
	public static BaseCtrl getCtrl(java.lang.Class ctrlClass) {
		BaseCtrl ctrl = null;
		if (!qualifiedClassNameCache.containsKey(ctrlClass.getName())) {
			try {
				ctrl = (BaseCtrl) ctrlClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			qualifiedClassNameCache.put(ctrlClass.getName(), ctrl);
		} else {
			ctrl = qualifiedClassNameCache.get(ctrlClass.getName());
		}
		
		return ctrl;
	}
}
