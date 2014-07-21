package com.wsoft.view.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wsoft.model.HibernateProxy;

public abstract class EventHandle implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		HibernateProxy.beginTransaction();
		try {
			this.handleEvent(e);
			HibernateProxy.commitTransaction();
			HibernateProxy.closeSession();
		} catch(Exception ex){
			ex.printStackTrace();
			HibernateProxy.rollbackTransaction();
			HibernateProxy.closeSession();
		}

	}
	
	public abstract void handleEvent(ActionEvent e);

}
