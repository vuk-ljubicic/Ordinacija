package com.wsoft.view;

import com.wsoft.controller.CtrlCache;


public class ServicesFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public ServicesFrame() {
		CtrlCache.addView("com.wsoft.controller.DefaultCtrl", this);
		setTitle("Registar usluga");
		
	}

	@Override
	public String getViewId() {
		// TODO Auto-generated method stub
		return "servicesFrm";
	}

}
