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
	
	
	static int linearSearch(int[] array, int key) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	static int interpolationSearch(int[] array, int key) {
		
		Arrays.sort(array);
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
	
	
	public void run() {
			
		//Prompt user for the number of elements in the array
		System.out.println("Enter the number of elements in the array: ");
		int elements = reader.nextInt();
		
		//Prompt user for the elements of the array
		System.out.println("Enter the elements of the array: ");
		
        int [] array = new int[elements];
		for(int i = 0; i < elements; i++) {
			array[i] = reader.nextInt();
		}
		
		//Prompt user for the search key
		System.out.println("Enter the search key: ");
		int key = reader.nextInt();
		
		//Linear Search
		
		long LinearStartTime = System.nanoTime(); //Q2
		
		if (linearSearch(array, key) == -1) {
			System.out.println("Using Linear Search:\nSearch key NOT FOUND\n");
		}
		else {
			System.out.println("Using Linear Search:\nSearch key FOUND at index : "+ linearSearch(array, key)+"\n");
		}
		long LinearEndTime   = System.nanoTime();
		long LinearTotalTime = LinearEndTime - LinearStartTime;
		//Q2 shows the time it takes for Linear search as complexity is O(n)
		System.out.println("Time for Linear Search in ns : " +LinearTotalTime+"\n"); 
		
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
		//Q2 shows the time it takes for Interpolations search is O(n)
		System.out.println("Time for Interpolation Search in ns : " +interTotalTime+"\n"); 
		
		//Interpolation Search takes longer then Linear Search based on the time it takes determined using nanoTime()
				
	}

	public static void main(String[] args) {
		
		SearchApp app = new SearchApp();
		app.run();
	}

}
