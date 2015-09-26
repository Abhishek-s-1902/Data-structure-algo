

import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class possion {
	
	static Double lemda=500.0;
	static Double epsolon = 2.71828;
	
	
	public static Double nogenerator(){
	
		Random Randomno = new Random();
       Double L = 1/Math.pow(epsolon,lemda);
       Double u;
       Double k = 0.0;
       Double p = 1.0;
        
       do{
        k = k+1;
        u =  Randomno.nextDouble();
         p = p*u;
        
       }
   while(p > L);
   return (k-1);
	}
	
	public static void main(String[] args) {
		
		
		Double [] bin = new Double[1000];
		for (int trial = 0; trial < 1000; trial++) {
			bin[trial] =  nogenerator(); 
		}
		System.out.println(Arrays.toString(bin));
	    }
}



/*

SOfN<Integer> s_of_n = new SOfN<Integer>(500);
List<Integer> sample = null;
for (int i = 0; i < 1000; i++)
sample = s_of_n.process(i);
for (int s : sample)
bin[s]++;
*/