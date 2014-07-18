package com.wsoft.view;

import com.wsoft.controller.CtrlFactory;


public class ServicesFrame extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public ServicesFrame() {
		CtrlFactory.addView("com.wsoft.controller.DefaultCtrl", this);
		setTitle("Registar usluga");
		
	}

}
