  import java.util.*;
 import java.util.TreeSet;
public class Hptest{
	
	
	
	   
	             long milliSeconds = 0;
	             
	             /*
	              * creating objects of HpTreeSet
	              */
	             HpTreeSet aHashTree;
	             
	             HpTreeSet Test1 = new HpTreeSet();
	             HpTreeSet Test2 = new HpTreeSet();
	             HpTreeSet Test3 = new HpTreeSet();
	             HpTreeSet Test4 = new HpTreeSet();
	             HpTreeSet Test5 = new HpTreeSet();
	   
	             
	             public void Test() {
	             }
	   
	             public void start() {
	                 milliSeconds = System.currentTimeMillis();
	             }
	   
	             public Hptest  init(HpTreeSet myhashset) {
	                 this.aHashTree = myhashset;
	                 return this;
	             }
	             public void end(String whatKind)    {
	                 System.err.println(whatKind + ": Time for all:  " + ( System.currentTimeMillis() - milliSeconds) );
	             }
	             
	             
	           /*
	            *  Test(): for calling diffrent functions of HpTreeSet
	            */
	   
	             public void executeTest() {
	                
	            	 
	            	//Test1: for similar element as Integer
	            	 
	            	 
	            	 Integer IntegerArray[] = new Integer[10];
	            	 for(int i=0;i<10;i++){
	            		 IntegerArray[i] = i+2; 
	            	 }
	            	 
	            	 
	            	 for(int i=0;i<10;i++){
	            		 System.out.println(Test1.add(IntegerArray[i]));
	            	 }
	            	 
	            	 /*Iterator object for Test1*/
	            	 Iterator<Object>IT1 = Test1.iterator();
	            	 
	            	 while(IT1.hasNext()) {
        	        	 System.out.println(IT1.hasNext());
            	         System.out.println(IT1.next());
            	         
        	         }
	            	 
	            	 System.out.println(Test1.isEmpty());
	                 System.out.println(Test1.size());
	                 
	            	 System.out.println(Test1.contains(new Integer(9)));
	                
	            	 
	          	     
	                 /*check for diffrent data types*/
	            	 System.out.println("//////////////////////////////////");
	            	 
	            	 Test3.add(new String("458"));
	            	 Test4.add(-1);				 
	            	 Test4.add(75.00);
	            	 
	             }
	            	 

	             /*main   class*/
	           public static void main(String args[]){
	                
	            	new Hptest().executeTest();
	                 System.exit(0);
	            	
	            	
	            }  }		
	 
	            
	                 
	                 
	                
	                 
	             
	             
	    
	   
	                    
	            
	            	     
	            	 
	            
	        

	
