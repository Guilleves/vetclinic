package testCreation;

import java.util.List;

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
			session.beginTransaction();
			//QUERY ALL THE VETS
			//the query class must be the same name of the Java class (Vet.java)
			List<Vet> myVets = session.createQuery("from Vet").list();
						//display the vets
			displayVets(myVets);
			
			//ANOTHER QUERY -- get me vets whose name is guillermina
			//now I should use the attribute name, not the column name
			List<Vet> myVets2 = session.createQuery("from Vet v where v.name = 'guillermina'").list();
			//display the vet
			displayVets(myVets2);
			
			//ANOTHER ONE -- vets whose name is guillermina or live in lima
			List<Vet> myVets3 = session.createQuery("from Vet v where v.name = 'guillermina' or v.address like 'lima%'").list();
			displayVets(myVets3);
			
			//commit tx
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}

	}

	private static void displayVets(List<Vet> resultSet) {
		for(Vet v: resultSet){
			System.out.println(v);
		}
		System.out.println("\n------------\n");
	}

}
