package com.wsoft.view.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wsoft.model.HibernateProxy;
import com.wsoft.view.Main;

public abstract class EventHandle implements ActionListener {

	public static java.lang.Class baseFrame;
	public static Integer x;
	public static Integer y;
	
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
		if(baseFrame != null && x != null && y!=null){
			Main.openFrame(baseFrame, x, y);
			baseFrame = null;
			x=null;
			y=null;
		}

	}
	
	public abstract void handleEvent(ActionEvent e) throws Exception;

}
