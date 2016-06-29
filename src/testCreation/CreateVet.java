package testCreation;

//imported to create SessionFactory
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//imported to create the actual session
import org.hibernate.Session;

//gotta import the package to add the annotated class Vet
import entities.Vet;

public class CreateVet {

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
			//create a Vet object
			System.out.println("Creating new vet");
			Vet testVet = new Vet(37333984, "guillermina", "rioja 4368", 40428, Double.parseDouble("3413020082"), "30-05-1993");
			
			//start a transaction
			session.beginTransaction();
			
			//save the Vet object
			System.out.println("Saving the temporary vet");
			session.save(testVet);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("listo");
		}
		finally{
			factory.close();
		}
	}							

}
