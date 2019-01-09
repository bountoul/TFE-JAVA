package database;

import java.sql.*;

public class DBConnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public DBConnect () {
		try {
			
			//Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connection
			con = DriverManager.getConnection("jdbc:mysql://172.19.255.114:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","lv0","lK09347DP190018");	
			st = con.createStatement();	
		}
		catch(Exception ex) {
			System.out.println("Error : " + ex );
		}
	}
	
	
	
	public void getAllClient(){
		try {
			//SQL requête
			String query = "select * From client";
			rs = st.executeQuery(query);

			System.out.println("Reading DataBase");
			
			//Boucle pour sortir tous les noms des clients
			while(rs.next()) {
				String name = rs.getString("Name");
				String firstName = rs.getString("FirstName");
				System.out.println("Name : " + name + " - "  +"Firstname : " + firstName);
			}	
		}
		catch(Exception ex) {
			System.out.println("Error : " + ex );
		}
	}
	
	
	public void newUser() {
		try {
			//Var user = new Var();
			String query = "insert into client (Name,FirstName) values ('" + Var.newName + "','" + Var.newFirstName + "')" ;
			st.executeUpdate(query);
			//rs = st.executeQuery("insert into client(Name,FirstName) values ('caca','pipi'),('coco','papa')");
			System.out.println("Creating a new user in the DataBase");
		}
		catch(Exception ex) {
			System.out.println("Error : " + ex );
		}
	}
	
	public void removeUser() {
		try {
			System.out.println("Removing" + Var.idClient + "in the DataBase");
			String query = "delete from client where ID ='" + Var.idClient + "'";
			st.executeUpdate(query);
			
		}
		catch(Exception ex) {
			System.out.println("Error : " + ex );
		}
	}
	
}
