

import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Double;
public class MergeSort {
	
	static List<Double> arrayList ;
	static Double array[];
	
	public static int heapSize;
	public static int Alength ;
	static long milliSeconds = 0;
	
	public static void start() {
        milliSeconds = System.currentTimeMillis();
           }
	
	 public static void end() {
        System.err.println(  ": Time for mergesort:  " + ( System.currentTimeMillis() - milliSeconds) );
         }

	
	/*
	 * @Mergesort: takes the array and do merge sort operation 
	 *   	recursively on left half and right half of the array
	 */
	
	public static void mergeSort(Double array1[]){
		
		int n = array1.length;
		
		int temIndex=0;
		if(n < 2)
			return;
		int mid = n/2;
		int nexthalf = array1.length-mid;
		Double left[]; 
		Double right[];
		
		left = Arrays.copyOfRange(array1, 0, mid);
		right = Arrays.copyOfRange(array1, mid, n);
		
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right, array1);
		
	}
	
	/*
	 * @merge: for merging the left and right half in one sorted list
	 */
	
 public static void merge(Double left[],Double right[],Double array2[]){
		
		int noinLeft = left.length;
		int noinRight = right.length;
		int i_index = 0, j_index=0,k=0;
		while(i_index<noinLeft&&j_index<noinRight ){
			if(left[i_index]<=right[j_index])
			{
				array2[k] = left[i_index];
				i_index++;
			}
			
			else{
				array2[k] = right[j_index];
				j_index++;
			}
			k++;
		}
		
		while(i_index<noinLeft){
			array2[k] = left[i_index];
			i_index++; k++;
		}
		
		while(j_index<noinRight){
			array2[k] = right[j_index];
			j_index++; k++;
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
		
		System.out.println("time in  merger sort: for random array");
		start();
		mergeSort(array);;
		end();
		
		
		 System.out.println(Arrays.toString(array));		//printing the array list
		 System.out.println();
		
		 
		// Sorted Dataset
		
		 array = new Double[range];
		array = D1.sorted(range);
		
		System.out.println("time in merger sort: time for sorted array");
		start();
		mergeSort(array);;
		end();
		
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 
		// One-forth Data set
		 
		 array = new Double[range];
		array = D1.onefourth(range);
		
		System.out.println("time in merger sort: time for onefourth sorted array");
		start();
		mergeSort(array);
		end();
		
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 
				 
		 //Poission values Data set
		 
		 array = new Double[range];
		array = D1.possionNo(range);
		
		System.out.println("time in merger sort: time for possion array");
		start();
		mergeSort(array);;
		end();
		 
		 
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		
		
		 long total = Runtime.getRuntime().totalMemory();
		 long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		 System.out.println( "Total memory used:"+ used);
		
	}

}
