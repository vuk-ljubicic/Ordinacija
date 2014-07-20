package com.wsoft.controller;

import java.util.List;

import com.wsoft.model.BaseModel;

public interface ModelListLoadable {
	public void loadToView(List<BaseModel> models);
	public List<BaseModel> unloadFromView();
}
