package testCreation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Vet;

public class ReadVet {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Vet.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			//assume a Vet with this dni exists
			Integer dni = 37333984;
			System.out.println(dni);
			//start transaction
			session.beginTransaction();
			//retrieve Vet based on the id -- WORKS ONLY WITH THE PK, NOT OTHER FIELDS
			Vet myVet = session.get(Vet.class, dni);
			System.out.println("dis vet: " + myVet);
			//commit
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally{
			factory.close();
		}

	}

}
