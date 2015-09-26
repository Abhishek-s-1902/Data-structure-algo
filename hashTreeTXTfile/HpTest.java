  import java.util.*;
 import java.util.TreeSet;
public class Hptest implements Comparator{
	
	
	
	   
	             long milliSeconds = 0;
	             HpHashTree aHashSet;
	   
	             public void Test() {
	             }
	   
	             public void start() {
	                 milliSeconds = System.currentTimeMillis();
	             }
	   
	             public Hptest  init(HpHashTree myhashset) {
	                 this.aHashSet = myhashset;
	                 return this;
	             }
	             public void end(String whatKind)    {
	                 System.err.println(whatKind + ": Time for all:  " + ( System.currentTimeMillis() - milliSeconds) );
	             }
	             
	             
	             public int compare(Object o1, Object o2)        {
	                 String s1 = (String)o1;
	                 String s2 = (String)o2;
	                 
	                 return -1*s1.compareTo(s2);}
	   
	             public void executeTest() {
	                 aHashSet.add(new Integer(84));				//passing the value to the function add 
	                 aHashSet.add(75);
	                 aHashSet.add(new Integer(05));
	                 aHashSet.add(new Integer(100));
	                 aHashSet.add(new Integer(60));
	                 System.out.println(aHashSet.contains(new Integer(60)));
	                 System.out.println(aHashSet.isEmpty());
	                 System.out.println(aHashSet.size());
	                 
	                 System.out.println(aHashSet.IT.hasNext());
	                 System.out.println(aHashSet.IT.next());
	                 System.out.println(aHashSet.IT.hasNext());
	                 System.out.println(aHashSet.IT.next());
	                 System.out.println(aHashSet.IT.hasNext());
	                 System.out.println(aHashSet.IT.next());
	                 System.out.println(aHashSet.IT.hasNext());
	                 System.out.println(aHashSet.IT.next());
	                 System.out.println(aHashSet.IT.hasNext());
	                 System.out.println(aHashSet.IT.next());
	                 System.out.println(aHashSet.IT.hasNext());
	                // aHashSet.printtheval();
	                 
	             }
	             
	            public void testIt() {
	   
	                 start();
	                 (init(new HpHashTree())).executeTest();		//calling my hashset1 object and executetest()  
	                 end("HpHashSet");
	                 start();
	                 end("HashSet");
	            }
	   
	            public static void main(String args[]){
	                
	            	new Hptest().testIt();
	                 System.exit(0);
	            	
	            	
	            }  }		
	            	/* Integer i = 10;
	            	System.out.println(i.hashCode()); 
	            	
	             i = 20; System.out.println(i.hashCode());
	            	
	            }}*/	
	            			
	            			/*Hptest H1 =  new Hptest();
	            	         TreeSet<Object> ts = new TreeSet<Object>();
	            	         Object O1 = -1.0004578;
	            	         Object O2 = -1.00059;
	            	         Object O3 = 1.00059;
	            	         
	            	         /*String A1 = O1.toString();
	            	         String A2 = (String)O2;
	            	         String A3 = (String)O3;
	            	         System.out.println(A1.getClass().getName());
	            	         //ts.add("rn");
	            	         
	            	         System.out.println(H1.compare(O1,O2));
	            	         System.out.println(O1.hashCode());
	            	         System.out.println(O2.hashCode());
	            	         System.out.println(O3.hashCode());
	            	   
	            	         ts.add(2.0);
	            	        
	            	        
	            	         System.out.println(ts);
	          
	            }
}
	          
	               /* public static void main(String args[]) {
	                    String theStrings[] = { "x", "a", "b", "c", "d" };
	                    List l = Arrays.asList(theStrings);
	                    Collections.sort(l);                            // line a
	                    Collections.sort(l, new ThisIsMyThing());       // line b
	                    System.out.println(l);
	                }
	            }

	            class ThisIsMyThing implements Comparator {
	                    public int compare(Object o1, Object o2)        {
	                            String s1 = (String)o1;
	                            String s2 = (String)o2;
	                            
	                            return -1 * s1.compareTo(s2);
	                    }*/
	                    
	            
	            	     
	            	 
	            
	        

	
