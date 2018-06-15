package controller;
import model.QuickSort;

public class Test {

	public static void main(String[] args) {

		QuickSort testSort = new QuickSort();
		int[]test = {57,-1,30,-5,10,11,9,22,45,-8};

		testSort.printTab(test);

		testSort.quickSort(test);
		
		testSort.printTab(test);
		
		

	}

}
