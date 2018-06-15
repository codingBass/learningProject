package controller;

import model.Animal;
import model.ZooFile;

public class Testdrive {

	public static void main(String[] args) {
		
	        ZooFile zf = new ZooFile();
	       
	        Animal a1 = new Animal("Dumbo", "elephant", 5);
	        
	        zf.saveToFile (a1);
	        
	        Animal a2 = new Animal("Tigrou", "tiger", 2);
	        
	        zf.saveToFile (a2);
	        
	        Animal a3 = new Animal("Mickey", "mouse", 112);
	        
	        zf.saveToFile (a3);
	        
	        zf.displayFile();
	        
	        zf.displayCount();
	        
	        zf.searchByName("Tigrou");
	        
	        zf.searchBySpacies("elephant");

		
	    }
}

