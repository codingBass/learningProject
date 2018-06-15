package model;

import java.util.Random;

public class QuickSort {	

	// Construction methode "Quick Sort" qui sera appellee depuis "main"
	
	public void quickSort(int[] tab){
		
		System.out.println("\n"+"Quick Sorting in progress...");
		quickSort(tab, 0, tab.length-1);

	}
	
	// Methode quickSort "interne" avec attributs pour sub-tableaux "virtuels" #RECURSIVITE
	
	private void quickSort(int[] tab, int lowestIndex, int highestIndex) {
		
		// "S'il y a plus d'un élément à trier alors..."

		if (lowestIndex < highestIndex+1) {
			
			// Definition "pivot" via Methode "interne" partitionTab
			
			int pivot = partitionTab(tab, lowestIndex, highestIndex);
			
			// Tri de la partie avant le pivot
			
			quickSort(tab, lowestIndex, pivot-1);
			
			// Tri de la partie après le pivot
			
			quickSort(tab, pivot+1, highestIndex);
		}
		
	}
	
	// Utilitaire #1 "interne" pour swap des valeurs
	
	private void swapVal(int[]tab, int cptStart, int cptEnd) {
		
		int temp = tab[cptStart];
		
		tab[cptStart] = tab[cptEnd];
		
		tab[cptEnd] = temp;
		
		}
	
	// Utilitaire #2 "interne pour générer/récupérer index "pivot"
	
	private int pivotIndex(int lowestIndex , int highestIndex) {
		
		// Generation nombre aleatoire dans nos limites
		
		Random randNumb = new Random();
		
		return randNumb.nextInt((highestIndex - lowestIndex) + 1) + lowestIndex;	
	
	}
	
	// 1st Part Methode QuickSort: partion tableau @ pivot
	
	private int partitionTab(int tab[] , int lowestIndex , int highestIndex) {	
		
		// Call methode swapVal pour basculer pivot au milieu
		
		swapVal(tab, lowestIndex, pivotIndex(lowestIndex, highestIndex));
		
		// Init bordure gauche sub-tableaux "virtuels" @ droite du pivot
		
		int limit = lowestIndex + 1;									
		
		// Init boucle qui va comparer/deplacer elements sub-tab vs "pivot"
		
		for (int i = limit ; i <= highestIndex ; i++) {
			
			// Si la valeur "bordure" est plus petite que notre "pivot"
			
			if (tab[i] < tab[lowestIndex]) {
				
				// leur valeur sont échangées
				
				swapVal(tab, i, limit++);
				
			}		
		}
		
		// les valeurs sont remises dans la bonne position vs "pivot"
		
		swapVal(tab, lowestIndex, limit-1);
		
		// retour de l'index au "pivot"
		
		return limit-1;
		
	}
	
	// Methode d'affichage
	
	public void printTab(int tab[]){
		
        for (int i=0; i<tab.length; ++i)
        	
            System.out.print("| "+tab[i]+" |");
    }
	
}
