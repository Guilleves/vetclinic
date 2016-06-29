package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/vetclinic";
		String usr = "root";
		String pass = "root";
		
		try{
			System.out.println("connecting");
			Connection myConn = DriverManager.getConnection(jdbcUrl, usr, pass);
			System.out.println("exito");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
