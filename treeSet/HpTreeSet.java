import java.util.*;

/*
 * 
 */
public class HpTreeSet extends TreeSet<Object>{
	
	int HashValue;
	/*
	 * BT : initializing the tree
	 * IT: initializing the iterator
	 */
	BinaryTree BT;
	 treeIterator IT;
	 
	 /*
	  * creating both objects in constructor
	  */
	public HpTreeSet(){
	  BT = new BinaryTree();  
	  IT = new treeIterator();
	}
	
	/*
	 * defining class for Iterator
	 */
	class treeIterator implements Iterator{
		
		public void remove(){}
		public boolean hasNext(){
			
			return(BT.HasNextnode());	
			
			}
		
		
		public Object next(){
			
			return(BT.NextNodeVal());
		}
	}
	
	/*
	 * add function: it will get call from the test class
	 * Class c : for checking if the new Object if of same 
	 * 			existing Object in the Tree
	 */
		
	 public boolean add(Object newelement)
	 { int hashcode;
		      hashcode = newelement.hashCode();		     	
		      													   
		      
				 Class c = newelement.getClass();
				
			if(BT.basenode!=null){
			 if(c == BT.basenode.value.getClass()){
					 return(BT.addToLinkList(newelement,hashcode));
				}}else{
				 return(BT.addToLinkList(newelement,hashcode));
			 }
	 	System.out.println("element type is different from the class element");return false;
				 
	}
	 
	 /*
	  * This iterator fun will get the call from the Test class
	  */
	 public Iterator iterator(){
		return IT;
	}
	 
	 /*
	  * contains(): This function will check for the specific element in the tree
	  */
	 public boolean contains(Object objecttosearch){
		 HashValue =  objecttosearch.hashCode();
		 return(BT.containsvalue(HashValue));
	 } 
	 /*
	  *isEmpty():this will check if the tree is empty
	  */
	 public boolean isEmpty(){
		 return(BT.BTIsempty());
			 }
	
	/*
	 * size(): for checking the size of tree
	 */
	 public int size(){
	    	return(BT.BTsize());  
	      }
	 
}
