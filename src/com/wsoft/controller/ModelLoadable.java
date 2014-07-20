package com.wsoft.controller;

import com.wsoft.model.BaseModel;

public interface ModelLoadable {
	public void loadToView(BaseModel model);
	public BaseModel unloadFromView();
}
