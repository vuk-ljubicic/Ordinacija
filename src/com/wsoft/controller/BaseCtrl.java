package com.wsoft.controller;

import java.util.HashMap;
import java.util.List;

import com.wsoft.model.BaseModel;
import com.wsoft.view.BaseFrame;

public abstract class BaseCtrl {
	protected HashMap<String, BaseFrame> view = new HashMap<String, BaseFrame>();
	public abstract void loadView();
	
	void addView(String viewId, BaseFrame view){
		this.view.put(viewId, view);
	}
	
	public abstract void loadToView(HashMap<String, List<BaseModel>> models);
	
	public abstract HashMap<String, List<BaseModel>> unloadFromView();
	
	public abstract void loadToView(List<BaseModel> models);
	
	public abstract List<BaseModel> unloadListFromView();
	
	public abstract void loadToView(BaseModel model);
	
	public abstract BaseModel unloadSingleFromView();
	
	
	
}
