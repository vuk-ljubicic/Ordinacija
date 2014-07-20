package com.wsoft.view;

import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.DefaultCtrl;


public class MaterialsFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaterialsFrame() {
		CtrlCache.addView(DefaultCtrl.class, this);
		setTitle("Registar materijala");
	}
}
