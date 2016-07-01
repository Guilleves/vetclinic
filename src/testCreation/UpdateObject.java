package testCreation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Vet;

public class UpdateObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			//retrieve Vet based on the dni -- WORKS ONLY WITH THE PK, NOT OTHER FIELDS
			Vet myVet = session.get(Vet.class, dni);
			System.out.println("dis vet: " + myVet);
			//update it
			System.out.println("Now we'll update it");
			myVet.setName("Esteban");
			Vet myUpdatedVet = session.get(Vet.class, dni);
			System.out.println("dis vet: " + myUpdatedVet);
			
			//ANOTHER QUERY -- update all phone numbers
			session.createQuery("update Vet set phone=3413020082").executeUpdate();

			//commit (until now, it was only in memory--not the db
			session.getTransaction().commit();
			
			
		}
		finally{
			factory.close();
		}
	}

}
