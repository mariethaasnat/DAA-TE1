import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CBIS {
    public static int[] sort(int[] a_list){
        int POP = 0;
        for (int i = 1; i < a_list.length; i++) {
            int COP = i;
            int key = a_list[COP];
            int place;

            if (key >= a_list[POP]) place = binary_loc_finder(a_list, POP + 1, COP - 1, key);
            else place = binary_loc_finder(a_list, 0, POP - 1, key);

            POP = place;
            a_list = place_inserter(a_list, place, COP);
        }
        return a_list;
    }

    public static int binary_loc_finder(int[] a_list, int start, int end, int key){
        int loc;
        if (start == end) {
            if (a_list[start] > key) loc = start; 
            else loc =  start + 1;
        }
        if (start > end) loc = start;
        else {
            int mid = (start + end) / 2;
            if (a_list[mid] < key) {
                loc = binary_loc_finder(a_list, mid + 1, end, key);
            } else if (a_list[mid] > key) {
                loc = binary_loc_finder(a_list, start, mid - 1, key);
            } else {
                loc = mid;
            }
        }

        return loc;
    }

    public static int[] place_inserter(int[] a_list, int start, int end){
        int temp = a_list[end];
        for (int k = end; k > start; k--) {
            a_list[k] = a_list[k - 1];
        }
        a_list[start] = temp;
        return a_list;
    }

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

            sort(intArray);
            
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