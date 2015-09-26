

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MY_CHOICE_QSORT{
	
	static Double array[];
	static int partartision = 1 ;
	static long milliSeconds = 0;
	
	public static void start() {
        milliSeconds = System.currentTimeMillis();
           }
	
	 public static void end() {
        System.err.println(  " Time : " + ( System.currentTimeMillis() - milliSeconds) );
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
		partartision++;
		
		int pivot = (pos_one+pos_last)/2;
		
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
	 * @my_qort: its recursive function which 
	 * divide all element into right part & left part in the 
	 * array in respect to the specified index by 
	 * calling divide_Array() method 
	 */

	public static void my_qort(int pos_one,int pos_last){
		
		
		if(pos_one<pos_last){
			
			int partIndex = divide_Array(pos_one,pos_last);
			
			my_qort(pos_one,partIndex-1);
			
			my_qort(partIndex+1,pos_last);
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
		
		System.out.println("time in MY_CHOICE_my_qort: for random array");
		start();
		my_qort(0,--range);
		end();
		
		 System.out.println("partartision in  "+partartision);
		 System.out.println(Arrays.toString(array));		//printing the array list
		 System.out.println();
		 partartision =0;
		 
		// Sorted Dataset
		
		 array = new Double[range];
		array = D1.sorted(range);
		
		System.out.println("time in MY_CHOICE_my_qort: time for sorted array");
		start();
		my_qort(0,--range);
		end();
		 System.out.println("partartision in  "+partartision);
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 partartision =0;
			 
		// One-forth Data set
		 
		 array = new Double[range];
		array = D1.onefourth(range);
		
		System.out.println("time in MY_CHOICE_my_qort: time for onefourth sorted array");
		start();
		my_qort(0,--range);
		end();
		 System.out.println("partartision in  "+partartision);
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 partartision =0;
				 
		 //Poission values Data set
		 
		 array = new Double[range];
		array = D1.possionNo(range);
		
		System.out.println("time in MY_CHOICE_my_qort: time for possion array");
		start();
		my_qort(0,--range);
		end();
		 
		 System.out.println("partartision in  "+partartision);
		 System.out.println(Arrays.toString(array));
		 System.out.println();
		 partartision =0;
		
		 long total = Runtime.getRuntime().totalMemory();
		 long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		 System.out.println( "Total memory used:"+ used);
		
		 
			
	}

}
