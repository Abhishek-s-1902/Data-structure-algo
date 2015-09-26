

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {
	
	static Double array[];
	public static int Aaaylength ;
	
	static long milliSeconds = 0;
	
	public static void start() {
        milliSeconds = System.currentTimeMillis();
           }
	
	 public static void end() {
        System.err.println(  ": Time for HeapSort:  " + ( System.currentTimeMillis() - milliSeconds) );
        
        
         }
	 
	
	
	 public static void swap(int i, int j){
		
		Double temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	
	/*
	 * @hepify: it build the heap from the poition 
	 * 			given as argument
	 */
	
	public static void heapify(int element_pos){
	
		int left_child = 2*element_pos+1;
		int right_child = 2*element_pos+2;
		int localmax_element = element_pos;
		
		if(left_child<Aaaylength && array[left_child]>array[element_pos]){
			localmax_element = left_child;
	    }
		
		if(right_child<Aaaylength && array[right_child]>array[localmax_element]) 
	    {
			localmax_element= right_child;
	    }
		
		 if(localmax_element!=element_pos)
		    {
			 swap(localmax_element,element_pos);
			 
			 heapify(localmax_element);
		    }
		
	}
	
	
	/*
	 * @build_heap: creates a max heap by calling 
	 * 				heapify recursively  
	 */
	
	public static void  build_heap()
	{
	    Aaaylength = array.length;     
	    for(int i=array.length/2; i>=0;i--)
	    {
	        heapify(i);
	    }
	}

	
	/*
	 * @heap sort: it takes the max element from the root
	 * and again heapify all array discarding the last element
	 * and makes the array of sorted element. 
	 */
	
	public static void heapSort(Double array[])
	{
	   
	    build_heap();
	   
	    for(int i=array.length-1;i>=0;i--)
	    {
	        
	        Double temp = array[0];
	        array[0]=array[i];
	        array[i]=temp;
	        Aaaylength  = Aaaylength-1;
	       
	        heapify(0);
	    }
	    
	}
	
	
	/*
	 * @Main : take the range at 1st element of argument line 
	 * 			and calls sort for each dataset  
	 */
	
	public static void main(String[] args) {
		
		if(args.length==0){
			System.out.println("no element length provided");
		}

		int range = Integer.parseInt(args[0]);
		
		if(range==1){
			
			System.out.println(array);
		}

		DataSet D1 = new DataSet();
		
		// Random Dataset
		
		array = new Double[range];
		array = D1.random(range);
		
		System.out.println("time in Heap sort: for random array");
		start();
		heapSort(array);
		end();
		
		 
		 System.out.println(Arrays.toString(array));		//printing the array list
		 System.out.println();
		
		 
		// Sorted Dataset
		
		 array = new Double[range];
		array = D1.sorted(range);
		
		System.out.println("time in Heap sort: time for sorted array");
		start();
		heapSort(array);
		end();
		 
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 
			 
		// One-forth Data set
		 
		 array = new Double[range];
		array = D1.onefourth(range);
		
		System.out.println("time in Heap sort: time for onefourth sorted array");
		start();
		heapSort(array);
		end();
		 
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		
				 
		 //Poission values Data set
		 
		 array = new Double[range];
		array = D1.possionNo(range);
		
		System.out.println("time in Heap sort: time for possion array");
		start();
		heapSort(array);
		end();
		 
		
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		
		
		 long total = Runtime.getRuntime().totalMemory();
		 long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		 System.out.println( "Total memory used:"+ used);
	}

	
}


