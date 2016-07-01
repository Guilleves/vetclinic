
package testCreation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Vet;

	public class DeleteObject {

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
				//start transaction
				session.beginTransaction();
				Vet myVet = session.get(Vet.class, dni);
				
				//delete the Vet
				System.out.println("deleting the vet :" +myVet);
				session.delete(myVet);
				
				//ALT APPROACH WITH A QUERY
				session.createQuery("delete from Vet where dni = 37333984");
				
				//commit (until now, it was only in memory--not the db)
				session.getTransaction().commit();
				
				
			}
			finally{
				factory.close();
			}
		}
	}

