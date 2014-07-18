package com.wsoft.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.wsoft.model.BaseModel;
import com.wsoft.view.BaseFrame;

public abstract class BaseCtrl {
	public HashMap<String, BaseFrame> view = new HashMap<String, BaseFrame>();
	public abstract void loadView();
	
	void addView(String viewId, BaseFrame view){
		this.view.put(viewId, view);
	}
	
	public abstract void loadToView(HashMap<String, ArrayList<BaseModel>> models);
	
	public abstract HashMap<String, ArrayList<BaseModel>> unloadFromView();
	
}
