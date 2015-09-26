

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort{
	
	static Double array[];
	static int partision =1;
	static long milliSeconds = 0;
	
	public static void start() {
         milliSeconds = System.currentTimeMillis();
            }
	
	 public static void end() {
         System.err.println(  ": Time for quickSort:  " + ( System.currentTimeMillis() - milliSeconds) );
          }
	 

	
	
	public static void swap(int i, int j){
		
		Double temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	
	/*
	 * @divide_Array: take any random pivot from the given array
	 * & move the element either left or tight side of 
	 * the element depending on if the element is
	 * small or large than the element
	 * 
	 */
	public static int divide_Array(int pos_one,int pos_last)
	{
		partision++;
		Random rand = new Random();
		
		int pivot = pos_one + (int)(Math.random() * (( pos_last - pos_one)));
		swap(pivot,pos_last);
		
		pivot = pos_last;
		int index = pos_one;
		
		for(int i=pos_one;i<pos_last;i++){
						
			if(array[i]<= array[pivot]){
							
				swap(i,index);
				index++;
			}
			
		}
		swap(index,pos_last);										
		
		return index;
	}

	/*
	 * @quick_sort: its recursive function which 
	 * divide all element into right part & left part in the 
	 * array in respect to the specified index by 
	 * calling divide_Array() method 
	 */
	public static void quick_sort(int pos_one,int pos_last){
		
		if(pos_one<pos_last){
			
			int partision_Index = divide_Array(pos_one,pos_last);
			quick_sort(pos_one,partision_Index-1);
			
			quick_sort(partision_Index+1,pos_last);
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
		
		System.out.println("time in quick_sort: for random array");
		start();
		quick_sort(0,--range);
		end();
		
		 System.out.println("partision in  "+partision);
		 System.out.println(Arrays.toString(array));		//printing the array list
		 System.out.println();
		 partision =0;
		 
		// Sorted Dataset
		
		 array = new Double[range];
		array = D1.sorted(range);
		
		System.out.println("time in quick_sort: time for sorted array");
		start();
		quick_sort(0,--range);
		end();
		 System.out.println("partision in  "+partision);
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 partision =0;
			 
		// One-forth Data set
		 
		array = new Double[range];
		array = D1.onefourth(range);
		
		System.out.println("time in quick_sort: time for onefourth sorted array");
		start();
		quick_sort(0,--range);;
		end();
		 System.out.println("partision in  "+partision);
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 partision =0;
				 
		 //Poission values Data set
		 
		 array = new Double[range];
		array = D1.possionNo(range);
		
		System.out.println("time in quick_sort: time for possion array");
		start();
		quick_sort(0,--range);
		end();
		 
		 System.out.println("partision in  "+partision);
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 partision =0;
		
		 long total = Runtime.getRuntime().totalMemory();
		 long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		 System.out.println( "Total memory used:"+ used);
	}

}
