package testCreation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Vet;

public class QueryObject {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Vet.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
		}
		finally{
			factory.close();
		}

	}

}
