package com.wsoft.view;

import com.wsoft.controller.CtrlCache;
import com.wsoft.controller.DefaultCtrl;


public class ServicesFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public ServicesFrame() {
		CtrlCache.addView(DefaultCtrl.class, this);
		setTitle("Registar usluga");
		
	}
}
