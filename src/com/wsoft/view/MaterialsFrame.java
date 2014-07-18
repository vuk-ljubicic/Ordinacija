package com.wsoft.view;

import com.wsoft.controller.CtrlFactory;


public class MaterialsFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaterialsFrame() {
		CtrlFactory.addView("com.wsoft.controller.DefaultCtrl", this);
		setTitle("Registar materijala");
	}

}
