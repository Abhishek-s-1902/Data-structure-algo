package word_wrap;
/*
 * @Author: Abhishek Sharma
 * @Program: This program executes the task of pretty printing similar to 
 * used in MS-Word or LaTex to evenly distributes the words across the line
 * so as the whole paragraph looks good.
 * 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;
import java.lang.Object;

/*
 * @pretty_print: This class contains the program used to execute
 * the task of even distribution of words
 */
public class pretty_print {
	
	/*
	 * @final_array: this contains the starting word index at each line
	 * 
	 */
	
	static int final_array (Integer print_matrix[], Integer n)
	{
	    int l;
	    if (print_matrix[n] == 1)
	        l = 1;
	    else
	        l = final_array (print_matrix, print_matrix[n]-1) + 1;
	    System.out.println("In Line :"+ l+" word contain from no."+print_matrix[n]+" to "+ n);
	       
	    return l;
	}
	
	/*
	 * 	@pretty_line: Takes the input as array containing each word length
	 * and total number of word, and maximum length allowed per line
	 */
	static void pretty_line (Integer word_list[], Integer n, Integer maxLength)
	{

	    Integer space_matrix[][] = new Integer[n+1][n+1];
	    Integer slack_matrix[][] = new Integer[n+1][n+1];
	    Integer cost_matrix[] = new Integer[n+1];
	    Integer print_matrix[] = new Integer[n+1];
	   

	    for (int i = 1; i <= n; i++)
	    {
	        space_matrix[i][i] = maxLength - word_list[i-1];
	        for (int j = i+1; j <= n; j++)
	            space_matrix[i][j] = space_matrix[i][j-1] - word_list[j-1] - 1;
	    }


	    for (int i = 1; i <= n; i++)
	    {
	        for (int j = i; j <= n; j++)
	        {
	            if (space_matrix[i][j] < 0)
	                slack_matrix[i][j] = (int) Float.POSITIVE_INFINITY;
	            else if (j == n && space_matrix[i][j] >= 0)
	                slack_matrix[i][j] = 0;
	            else
	                slack_matrix[i][j] = space_matrix[i][j]*space_matrix[i][j];
	        }
	    }


	    cost_matrix[0] = 0;
	    for (int i = 1; i <= n; i++)
	    {
	    	cost_matrix[i] = (int) Float.POSITIVE_INFINITY;
	        for (int j = 1; j <= i; j++)
	        {
	            if (cost_matrix[j-1] != (int) Float.POSITIVE_INFINITY && slack_matrix[j][i] != (int) Float.POSITIVE_INFINITY && 
	            														(cost_matrix[j-1] + slack_matrix[j][i] < cost_matrix[i]))
	            {
	            	cost_matrix[i] = cost_matrix[j-1] + slack_matrix[j][i];
	            	print_matrix[i] = j;
	            }
	        }
	    }

	    final_array(print_matrix, n);
	}
	
	
	

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Vector<Integer> word_list = new Vector<Integer>();
		Vector<Character> word_char = new Vector<Character>();
		String specialchar;
		Vector<String> line = new Vector<String>() ;
		Integer word_copy[]= null;
		boolean special = false;
		char[] specialCh = {'!','@',']','#','$','%','^','&','*',',','.','?'};

		Scanner reader = new Scanner(new FileInputStream(args[1]));
		
		while ( reader.hasNext()) {
			special = false;
			specialchar = reader.next();
			int size = specialchar.length();
			
			for (Character c : specialCh) {
				
				if(specialchar.charAt(size-1)== c){    
					line.add(specialchar.substring(0,size-1));
					special = true;
				}
		}
		if(special == false)
				line.add(specialchar);
		
		}	
		reader.close();
		
		for (int j = 0; j < line.size(); j++){
			
			word_list.add(line.elementAt(j).length());
		}
						
		Integer n = word_list.size();
		word_copy = new Integer[n];
		word_list.copyInto(word_copy);
		
		Integer maxLength = Integer.parseInt(args[0]);
		
	    pretty_line(word_copy,n,maxLength);
	    
	}

}
