package testCreation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Appointment;
import entities.Breed;
import entities.Owner;
import entities.Pet;
import entities.Pet.Sex;
import entities.Species;
import entities.Treatment;
import entities.Vet;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				// configure parameters are not necessary IF cfg's file name is
				// the default
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Owner.class)
				.addAnnotatedClass(Pet.class)
				.addAnnotatedClass(Vet.class)
				.addAnnotatedClass(Appointment.class)
				.addAnnotatedClass(Breed.class)
				.addAnnotatedClass(Species.class)
				.addAnnotatedClass(Treatment.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Creating Owners");
			Owner o1 = new Owner(37333984, "guillermina vescovo");
			Owner o2 = new Owner(17102322, "alejandra degiorgi");
			Owner o3 = new Owner(16265726, "gustavo vescovo");
			
			System.out.println("Creating pets");
			Pet p1 = new Pet("Confite", Sex.F);
			Pet p2 = new Pet("Yuki", Sex.M);
			Pet p3 = new Pet("Carozo", Sex.F);
			Pet p4 = new Pet("Indira", Sex.F);
			Pet p5 = new Pet("Amaterasu", Sex.M);
			Pet p6 = new Pet("Connie Ansaldi", Sex.F);
			
			System.out.println("Creating Vets");
			Vet v1 = new Vet(1, 40119467, "Juan Ignacio Vescovo");
			Vet v2 = new Vet(2, 37333985, "Nicolás Pickelny");
			Vet v3 = new Vet(3, 37079494, "Franco Martinelli");
			
			System.out.println("Creating Species");
			Species s1 = new Species(001, "Whale");
			Species s2 = new Species(002, "4-legged");
			Species s3 = new Species(003, "Bird");
			
			System.out.println("Creating Treatments");
			Treatment t1 = new Treatment(10, "Uterus vaccine");
			Treatment t2 = new Treatment(11, "Flu vaccine");
			Treatment t3 = new Treatment(12, "Antibiothics");
			Treatment t4 = new Treatment(13, "STD prevention");
			Treatment t5 = new Treatment(14, "X-Ray");
			Treatment t6 = new Treatment(15, "Surgery");
			
			System.out.println("Saving them");
			session.save(o1);session.save(o2);session.save(o3);
			session.save(p1);session.save(p2);session.save(p3);session.save(p4);session.save(p5);session.save(p6);
			session.save(v1);session.save(v2);session.save(v3);
			session.save(s1);session.save(s2);session.save(s3);
			session.save(t1);session.save(t2);session.save(t3);session.save(t4);session.save(t5);session.save(t6);
			
			System.out.println("Commiting changes to the DB");
			session.getTransaction().commit();
			
			
			
			
			
			
			
		}
		finally{
			session.close();
		}
	}		
}