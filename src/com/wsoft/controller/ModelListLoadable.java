package com.wsoft.controller;

import java.util.List;

import com.wsoft.model.BaseModel;

public interface ModelListLoadable<T> {
	public void loadToView(List<T> models);
	public List<T> unloadFromView();
}
