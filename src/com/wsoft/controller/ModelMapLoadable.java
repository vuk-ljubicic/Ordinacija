package com.wsoft.controller;

import java.util.HashMap;
import java.util.List;

import com.wsoft.model.BaseModel;

public interface ModelMapLoadable {
	public void loadToView(HashMap<String, List<BaseModel>> models);
	public HashMap<String, List<BaseModel>> unloadFromView();
}
