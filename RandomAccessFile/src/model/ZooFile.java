package model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ZooFile {
	
	RandomAccessFile zooFile;
	
	// Initialisation d'un standard d'enregistrement
	
	private static final int RECORD = 44;
	
	public ZooFile() {
		
	}

	// Methode d'ajout d'animal
	
	public void saveToFile(Animal a) {
		
		try {
			
			zooFile = new RandomAccessFile(new File("zooData.txt"), "rw" );
			
			long zooFileSize = zooFile.length();
			
			zooFile.seek(zooFileSize);
			
			zooFile.writeUTF(a.name);
			
			fillByte(a.name);
			
			zooFile.writeUTF(a.specie);
			
			fillByte(a.specie);
			
			zooFile.writeInt(a.age);
			
		//zooFile.close();
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error");
			
			e.printStackTrace();
			
		}
		
	}

	// Methode d'Affichage pour contenu total fichier "zoo"
	
	public void displayFile() {
		
		try {
			
			if (recordCount() == 0) {
				
				System.out.println("No animal have been registered yet...");
				
			}
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error");
			
			e.printStackTrace();
			
		}
		
		try {
			
			zooFile.seek(0);
			
				for (int j = 0; j < recordCount(); j++) {
					
					String name = zooFile.readUTF();
					
					for (int i = 0 ; i < 20 - name.length(); i++) {
						
						zooFile.readByte();
						
						}
					
					String specie = zooFile.readUTF();
					
					for (int i = 0 ; i < 20 - specie.length(); i++) {
						
						zooFile.readByte(); 
						
						}
					
					int age = zooFile.readInt();
					
					System.out.println("\n" + "An animal named " + name + " have been founded ! It's from the " + specie + "'s specie. It's " + age + " years old.");
					
					}
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error.");
			
			e.printStackTrace();
			
		}
		
	}

	// Methode de Recherche par Nom
	
	public void searchByName(String s) {
		
		try {
			
			if (recordCount() == 0) {
				
				System.out.println("No animal have been registered yet...");
				
			}
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error.");
			
			e.printStackTrace();
			
		}
		
		try {
			
			zooFile.seek(0);
			
				for (int j = 0; j < recordCount(); j++) {
					
					String name = zooFile.readUTF();
					
					for (int i = 0 ; i < 20 - name.length(); i++) {
						
						zooFile.readByte();
						
						}
					
					String specie = zooFile.readUTF();
					
					for (int i = 0 ; i < 20 - specie.length(); i++) {
						
						zooFile.readByte(); 
						
						}
					
					int age = zooFile.readInt();
					
					if (s.equals(name)) {
					
					System.out.println("\n" + name + " have been founded ! It's a(n) " + specie + " specie who is " + age + " years old.");
					
					} 	
				}
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error.");
			
			e.printStackTrace();
			
		}
		
	}

	// Methode de Recherche par Especes
	
	public void searchBySpacies(String s) {

		try {
			
			if (recordCount() == 0) {
				
				System.out.println("No animal have been registered yet...");
				
			}
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error.");
			
			e.printStackTrace();
			
		}
		
		try {
			
			zooFile.seek(0);
			
				for (int j = 0; j < recordCount(); j++) {
					
					String name = zooFile.readUTF();
					
					for (int i = 0 ; i < 20 - name.length(); i++) {
						
						zooFile.readByte();
						
						}
					
					String specie = zooFile.readUTF();
					
					for (int i = 0 ; i < 20 - specie.length(); i++) {
						
						zooFile.readByte(); 
						
						}
					
					int age = zooFile.readInt();
					
					if (s.equals(specie)) {
					
					System.out.println("\n" + "An " + specie + " have been founded ! It's " + age + " years old. We call it " + name );
					
					} 
			}
			
		} catch (IOException e) {
			
			System.out.println("The request could not be performed because of an I/O device error.");
			
			e.printStackTrace();
			
		}
		
	}

	// Methode pour Afficher le nombre d'animaux enregistrés
	
	public void displayCount() {

		try {
			
			System.out.println("\n" + "There is " + recordCount() + " animal(s) registered.");
			
		} catch (IOException e) {

			System.out.println("The request could not be performed because of an I/O device error.");
			
			e.printStackTrace();
			
		}
		
	}

	// Methode "interne" pour completer les Strings
	
	private void fillByte(String s) throws IOException {

		for (int i = 0 ; i < 20 - s.length(); i++) {
			
				zooFile.writeByte(20);
				
		}
	}

	// Methode "interne" gardant trace des enregistrements
	
	private long recordCount() throws IOException {
		
		long zooFileSize = zooFile.length();

		long recordCount = zooFileSize / RECORD;
		
		return recordCount;

	}

}

