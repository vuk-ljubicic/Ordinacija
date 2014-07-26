package com.wsoft.refresher;

import org.hibernate.Query;

import com.wsoft.model.HibernateProxy;

public class RefresherThread implements Runnable{

	@Override
	public void run() {
		while(true){
			Query query = HibernateProxy.session().createQuery("from com.wsoft.model.Patient where idPac = 1");
			query.list();
			HibernateProxy.session().close();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
