package testCreation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Vet;

public class PKDemo {
//instead of adding 1 vet, we add several
	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
								//configure parameters are not necessary IF cfg's file name is the default
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Vet.class)
								.buildSessionFactory();
			
		//create session
		Session session = factory.getCurrentSession();
		
		//use the session to save a Java object
		try{
			//create 3 Vet object
			System.out.println("Creating new vet");
			Vet testVet = new Vet(37333984, "guillermina", "rioja 4368", 40428, Double.parseDouble("3413020082"), "30-05-1993");
			Vet testVet2 = new Vet(37333985, "carlos", "lima 4368", 40588, Double.parseDouble("3413020081"), "15-04-1991");
			Vet testVet3 = new Vet(37333986, "horhe", "cordoba 4368", 40128, Double.parseDouble("3413020080"), "03-10-1990");
			
			//start a transaction
			session.beginTransaction();
			
			//save the Vet object
			System.out.println("Saving the temporary vet");
			session.save(testVet);
			session.save(testVet2);
			session.save(testVet3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("listo");
		}
		finally{
			factory.close();
		}
	}				
}
