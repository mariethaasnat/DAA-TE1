// Java program to illustrate
// Randomised Quick Sort 
import java.util.*; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class RQS 
{	 
	// This Function helps in calculating
	// random numbers between low(inclusive)
	// and high(inclusive) 
	static void random(int arr[],int low,int high) 
	{ 
	
		Random rand= new Random(); 
		int pivot = rand.nextInt(high-low)+low; 
		
		int temp1=arr[pivot]; 
		arr[pivot]=arr[high]; 
		arr[high]=temp1; 
	} 
	
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	static int partition(int arr[], int low, int high) 
	{ 
		// pivot is chosen randomly 
		random(arr,low,high);
		int pivot = arr[high]; 
	

		int i = (low-1); // index of smaller element 
		for (int j = low; j < high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] < pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	static void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 

			int pi = partition(arr, low, high); 

			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver Code 
	public static void main(String[] args){
        try{

            int length = 200;
            // int length = 2000;
            // int length = 20000;
            int[] intArray = new int[length];
            String line;
            BufferedReader in;

            in = new BufferedReader(new FileReader("random1_200.txt"));
            // in = new BufferedReader(new FileReader("random2_2000.txt"));
            // in = new BufferedReader(new FileReader("random3_20000.txt"));

            // in = new BufferedReader(new FileReader("reversed1_200.txt"));
            // in = new BufferedReader(new FileReader("reversed2_2000.txt"));
            // in = new BufferedReader(new FileReader("reversed3_20000.txt"));

            // in = new BufferedReader(new FileReader("sorted1_200.txt"));
            // in = new BufferedReader(new FileReader("sorted2_2000.txt"));
            // in = new BufferedReader(new FileReader("sorted3_20000.txt"));
			
            line = in.readLine();
            int counter = 0;
            
            while(line != null)
            {
                intArray[counter] = Integer.parseInt(line);
                line = in.readLine();
                counter++;
            }

           
            in.close();


            long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			long begin = System.currentTimeMillis();

            sort(intArray,0, length-1);
            
            long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
			long end = System.currentTimeMillis();
			long time = end-begin;
			long actualMemUsed=(afterUsedMem-beforeUsedMem);

			System.out.println("Elapsed Time: "+time +" milli seconds");
			System.out.println("Memory Usage: "+actualMemUsed+ " KB");
        }
        catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }
} 
