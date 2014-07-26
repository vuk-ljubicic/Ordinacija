package com.wsoft.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Vuk
 */
public class HibernateProxy {
	private static SessionFactory sessionFactory = null;
	private static Properties hbmProperties = null;
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();

	private static synchronized SessionFactory getSessionFactory()
			throws NamingException {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		return sessionFactory;
	}

	private static org.hibernate.SessionFactory createSessionFactory()
			throws NamingException {

		SessionFactory sessionFactory = null;
		ArrayList<String> hbm = new ArrayList<String>();

		HibernateProxy.fillHbm(hbm);
		sessionFactory = HibernateProxy.createSessionFactory(hbm);

		return sessionFactory;
	}

	private static SessionFactory createSessionFactory(
			ArrayList<String> mappings) {

		Properties prop = new Properties();
		prop.put("hibernate.dialect",
				"org.hibernate.dialect.SQLServerDialect");
		prop.put("hibernate.connection.driver_class",
				"net.ucanaccess.jdbc.UcanaccessDriver");
		prop.put("hibernate.connection.url",
				hbmProperties.getProperty("url"));
		prop.put("hibernate.archive.autodetection", "class");
		prop.put("hibernate.connection.characterEncoding", "utf8");
		prop.put("hibernate.connection.pool_size", "0");
		prop.put("transaction.factory_class",
				"org.hibernate.transaction.JDBCTransactionFactory");
		prop.put("connection.autocommit", "false");
		prop.put("connection.provider_class",
				"org.hibernate.connection.C3P0ConnectionProvider");
		prop.put("hibernate.show_sql","false");
		Configuration config = new Configuration();
		config.addProperties(prop);
		Iterator<String> it = mappings.iterator();

		while (it.hasNext()) {
			String txt = it.next();
			config.addResource(txt);
		}

		return config.buildSessionFactory();
	}

	private static void fillHbm(ArrayList<String> hbm) {
		hbmProperties = new Properties();
		try {
			InputStream in = HibernateProxy.class
					.getClassLoader().getResourceAsStream("hbm.properties");
			hbmProperties.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Enumeration e = hbmProperties.propertyNames();

		while (e.hasMoreElements()) {
			String propertyName = (String) e.nextElement();
			String propertyValue = hbmProperties.getProperty(propertyName);
			if(propertyName.startsWith("hbm"))
				hbm.add(propertyValue);
		}
	}

	public static Session session() {
		if (HibernateProxy.session.get() == null || !HibernateProxy.session.get().isOpen()) {
			try {
				HibernateProxy.session.set(HibernateProxy.getSessionFactory()
						.openSession());
				HibernateProxy.session.get().setCacheMode(CacheMode.IGNORE);
			} catch (HibernateException | NamingException e) {
				e.printStackTrace();
			}
		}
		return HibernateProxy.session.get();
	}

	public static void beginTransaction() {
		if (!HibernateProxy.session().getTransaction().isActive())
			HibernateProxy.session().beginTransaction();
	}

	public static void commitTransaction() {
		if (HibernateProxy.session().getTransaction().isActive())
			HibernateProxy.session().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		if (HibernateProxy.session().getTransaction().isActive())
			HibernateProxy.session().getTransaction().rollback();
	}

	public static void attachClean(Object instance) {
		HibernateProxy.session().lock(instance, LockMode.NONE);
	}

	public static void attachDirty(Object instance) {
		Object mergedInstance = HibernateProxy.merge(instance);
		HibernateProxy.session().saveOrUpdate(mergedInstance);
	}

	public static void delete(Object persistentInstance) {
		Object mergedInstance = HibernateProxy.merge(persistentInstance);
		HibernateProxy.session().delete(mergedInstance);
	}

	public static List<Object> findEntitiesBasedOnCriteria(
			HashMap<String, Criteria> criteria, String rootCriterionName) {
		Criteria rootCriteria = criteria.get(rootCriterionName);
		List<Object> result = rootCriteria.list();
		return result;
	}

	public static Object findById(String className, Object id) {
		Object instance = (Object) HibernateProxy.session().get(className,
				(Serializable) id);
		return instance;
	}

	public static Object merge(Object detachedInstance) {
		Object result = (Object) HibernateProxy.session().merge(
				detachedInstance);
		return result;
	}

	public static void persist(Object transientInstance) {
		HibernateProxy.session().persist(transientInstance);
	}

	public static void closeSession() {
		HibernateProxy.session().close();
	}

}
