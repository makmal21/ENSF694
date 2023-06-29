/**
 * Class Name: Search App 
 * 
 *represents command-line interface to prompt user for inputs.
 *Uses inputed array to perform Linear and Interpolation Search. 
 * 
 * Author: Mehreen Akmal
 */
import java.util.Arrays; 
import java.util.Scanner;
public class SearchApp {
	
	private Scanner reader = new Scanner(System.in);
	
	
	/**
	 * Linear Search method 
	 * @param array
	 * @param key
	 * @return int
	 */
	static int linearSearch(int[] array, int key) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Improved Linear Search method for Q3
	 * @param array
	 * @param key
	 * @return int
	 */
	static int linearSearchQ3(int[] array, int key) {
		
		int mid =  (array.length) / 2;
		if(key < array[mid]) {
			for(int i = 0; i < mid; i++) {
				if(array[i] == key) {
					return i;
				}
			}
		}else {
			for(int i = mid; i < array.length; i++) {
				if(array[i] == key) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Interpolation Search method
	 * 
	 * @param array
	 * @param key
	 * @return int
	 */
	static int interpolationSearch(int[] array, int key) {
		
		int low = 0, mid, high = array.length-1;
		while(low <= high)
		{
			int pos = (key-array[low])/ (array[high]- array[low]);
			mid = low + ((high-low)*pos);
			if(key < array[mid]) {
				high = mid-1;
			}else if(array[mid] < key) {
				low = mid + 1;
			}else {
				return mid; //Key Found and index returned 
			}
		}
		return -1;
	}
	
	/**
	 * Prompt user for inputs, store elements in array 
	 * Call Linear and Interpolation Search methods
	 */
	public void run() {
			
		//Prompt user for the number of elements in the array
		System.out.println("Enter the number of elements in the array: ");
		int elements = reader.nextInt();
		
		//Prompt user for the elements of the array
		System.out.println("Enter the elements of the array: ");
		
		//Set size of int array 
        int [] array = new int[elements];
        //add values entered to array
		for(int i = 0; i < elements; i++) {
			array[i] = reader.nextInt();
		}
		
		//Prompt user for the search key
		System.out.println("Enter the search key: ");
		int key = reader.nextInt();
		
		Arrays.sort(array); //Sort array 
		
		//Linear Search
		long LinearStartTime = System.nanoTime();
		
		if (linearSearch(array, key) == -1) {
			System.out.println("Using Linear Search:\nSearch key NOT FOUND\n");
		}
		else {
			System.out.println("Using Linear Search:\nSearch key FOUND at index : "+ linearSearch(array, key)+"\n");
		}
		
		long LinearEndTime   = System.nanoTime();
		long LinearTotalTime = LinearEndTime - LinearStartTime;
		
	
		
		//Q3 Linear Search - Improved
		//I improved the Linear Search by splitting the array in half.
		//Then determined which half the key is in so we only have to search half the length of the array. 
		long Linear2StartTime = System.nanoTime(); 
		
		int index = linearSearchQ3(array, key);
		if (index == -1) {
			System.out.println("Using Linear Search Improved:\nSearch key NOT FOUND\n");
		}
		else {
			System.out.println("Using Linear Search Improved:\nSearch key FOUND at index : "+ linearSearchQ3(array, key)+"\n");
		}
		long Linear2EndTime   = System.nanoTime();
		long Linear2TotalTime = Linear2EndTime - Linear2StartTime;
		
		
		//Interpolation Search
		long interStartTime = System.nanoTime();
		if (interpolationSearch(array, key) == -1) {
			System.out.println("Using Interpolation Search:\nSearch key NOT FOUND\n");
		}
		else {
			System.out.println("Using Interpolation Search:\nSearch key FOUND at index : "+ interpolationSearch(array, key)+"\n");
		}
		long interEndTime   = System.nanoTime();
		long interTotalTime = interEndTime - interStartTime;
		
		
		//Q2: Compare runtime for Linear Search vs. Interpolation Search using nanoTime(). 
		//Interpolation Search performed better then the Linear Search as it took less time. 
		//This is because Interpolation Search divides the array at the probe position continuously 
		//until it finds the key whereas Linear search goes through every single item in the array.
		System.out.println("Time for Linear Search in ns : " +LinearTotalTime); 
		System.out.println("Time for Linear Search Improved for Q3 in ns : " +Linear2TotalTime); 
		System.out.println("Time for Interpolation Search in ns : " +interTotalTime); 
		
		//Q3 Showing run time improved by at least 20%
		int percent = (int) ((LinearTotalTime-Linear2TotalTime)*100/LinearTotalTime);
		System.out.println("Improved by: " +percent+"%");
		
	}

	public static void main(String[] args) {
		
		SearchApp app = new SearchApp();
		app.run();
	}

}
