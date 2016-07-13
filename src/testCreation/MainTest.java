package testCreation;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Owner;
import entities.Pet;
import entities.Pet.Sex;
public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								//configure parameters are not necessary IF cfg's file name is the default
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Owner.class)
											.addAnnotatedClass(Pet.class)
											.buildSessionFactory();

				
				//use the session to save a Java object
				try{
				//create a Vet object
					Session session = factory.getCurrentSession();
						System.out.println("Creating new Owner");
						Owner testOwner = new Owner();
						testOwner.setDni(17102322);
						testOwner.setName("alejandra");
						testOwner.setAddress("rioja 4368");
						testOwner.setEmail("madegiorgi@yahoo.com.ar");
						
						System.out.println("Creating new Owner");
						Owner owner2 = new Owner();
						owner2.setDni(37333984);
						owner2.setName("guillermina");
						owner2.setAddress("rioja 4368");
						owner2.setEmail("guilleves@gmail.com");
						
						System.out.println("Creating new pet");
						Pet pet1 = new Pet("Yuki", Sex.M , new Date(), owner2);

						System.out.println("Creating new pet");
						Pet pet2 = new Pet("Confite", Sex.F , new Date(), owner2);
						
						System.out.println("Creating new pet");
						Pet pet3 = new Pet("Lola", Sex.M , new Date(), testOwner);


						
						
						//start a transaction
						session.beginTransaction();
						
						//save the Vet object
						System.out.println("Saving the temporary vet");
						session.save(testOwner);
						session.save(owner2);
						session.save(pet1);
						session.save(pet2);
						session.save(pet3);

						
						//commit transaction
						session.getTransaction().commit();
						System.out.println("listo");
						}
				finally{
				factory.close();
				}
				}							


}