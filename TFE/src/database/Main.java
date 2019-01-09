package database;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DBConnect connect = new DBConnect();
		connect.getAllClient();
		
		//System.out.println("Veuillez entrez le nom du nouveau client : ");
		//Var.newName = scanner.nextLine();
		//System.out.println("Veuillez entrez le prénom du nouveau client : ");
		//Var.newFirstName = scanner.nextLine();
		System.out.println("Veuillez entrez l'ID du client : ");
		Var.idClient = scanner.nextInt();
		connect.removeUser();
		connect.getAllClient();
	}

}
