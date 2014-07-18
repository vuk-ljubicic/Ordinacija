package com.wsoft.controller;

import com.wsoft.view.BaseFrame;

public abstract class FormCtrl extends BaseCtrl{
	public abstract void create();
	public abstract void delete();
	public abstract void search();
	public abstract void save();
	public abstract void change();
	public abstract void first();
	public abstract void previous();
	public abstract void next();
	public abstract void last();
}
