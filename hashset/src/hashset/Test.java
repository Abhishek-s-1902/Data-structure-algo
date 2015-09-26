package hashset;
import java.util.*;

public class Test {
	
   
             long milliSeconds = 0;
             HpHashSet aHashSet;
   
             public void Test(){
             }
   
             public void start() {
                 milliSeconds = System.currentTimeMillis();
             }
   
             public Test  init(HpHashSet myhashset) {
                 this.aHashSet = myhashset;
                 return this;
             }
             public void end(String whatKind)    {
                 System.err.println(whatKind + ": Time for all:  " + ( System.currentTimeMillis() - milliSeconds) );
             }
   
             public void executeTest()   {
                 aHashSet.add("451");				//passing the value to the function add 
                 aHashSet.add(new Integer(45));
                 aHashSet.add(new Long(2345678L));
                 
                 aHashSet.contains("451");
                 aHashSet.contains(45);
                 aHashSet.contains(2345678L);
                 //contains(new Object());
                 aHashSet.isEmpty();
                 
                 aHashSet.iterator();
                 aHashSet.iterator();
                 aHashSet.iterator();
                 aHashSet.iterator();
                 
                 /*aHashSet.isEmpty();
                  * 
                 
                 aHashSet.iterator();
                 aHashSet.iterator();*/
                 //aHashSet.remove(new Object());
                 
                /* aHashSet.size();*/
                 
             }
            public void testIt() {
   
                 start();
                 (init(new HpHashSet())).executeTest();		//calling my hashset1 object and executetest()  
                 end("HpHashSet");
                 start();
                // (init(new HashSet())).executeTest();
                 end("HashSet");
            }
   
            public static void main(String args[] )      {
                 new Test().testIt();					//calling the test program
                 System.exit(0);
            }
        

}
