package com.wsoft.view;

import com.wsoft.controller.CtrlCache;


public class MaterialsFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaterialsFrame() {
		CtrlCache.addView("com.wsoft.controller.DefaultCtrl", this);
		setTitle("Registar materijala");
	}

	@Override
	public String getViewId() {
		return "materialsFrm";
	}

}
