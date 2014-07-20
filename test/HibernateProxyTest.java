import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wsoft.model.ExecutedService;
import com.wsoft.model.HibernateProxy;
import com.wsoft.model.Patient;


public class HibernateProxyTest {
	
	private static Session session;
	@BeforeClass
	public static void createSessionFactory(){
		session = HibernateProxy.session();
		HibernateProxy.beginTransaction();
	}
	
	//@Test
	public void testPatientSelection() {
		Query query = session.createQuery("from com.wsoft.model.Patient");
		List patients = query.list();
		for(int i = 0; i<1500; i++){
			Patient patient = (Patient)patients.get(i);
			if(patient.getIdPac() == 770)
				assertTrue(patient.getLek());
		}
	}
	
	//@Test
	public void testExecutedServiceSelection() {
		Query query = session.createQuery("from com.wsoft.model.ExecutedService");
		List executedServices = query.list();
		for(int i = 0; i<1500; i++){
			ExecutedService executedService = (ExecutedService)executedServices.get(i);
		}
	}
	
	@AfterClass
	public static void closeSession(){
		HibernateProxy.commitTransaction();
		HibernateProxy.closeSession();
	}
	
}
