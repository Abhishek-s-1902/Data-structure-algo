import java.util.Iterator;

public class HpHashTree{
	
	int HashValue;
	
	
	public BinaryTree BT = new BinaryTree();
	public treeIterator IT = new treeIterator();
	public BinaryTree minnode;
	
	class treeIterator implements Iterator{
		
		public void remove(){}
		public boolean hasNext(){
			
			return(BT.HasNextnode());	
			
			}
		
		
		public Object next(){
			
			return(BT.PresentNodeVal());
		}
	}
	
	
		
	 public boolean add(Object newelement)
	 { int hashcode;
		      hashcode = newelement.hashCode();		     //please check if the try catch block is correct,	
		      													//i wrote if number is greater than the int can store   
		      
				 Class c = newelement.getClass();
				 System.out.println(c);
			if(BT.basenode!=null){
			 if(c == BT.basenode.value.getClass()){
					 return(BT.addToLinkList(newelement,hashcode));
				}}else{
				 return(BT.addToLinkList(newelement,hashcode));
			 }
	 	System.out.println("element type is different from the class element");return false;
				 
	}
	 
	 public Iterator iterator(){
		return IT;
		 
	 }
	 
	 public boolean contains(Object objecttosearch){
		 HashValue =  objecttosearch.hashCode();
		 return(BT.containsvalue(HashValue));
	 } 
	 
	 boolean isEmpty(){return(BT.BTIsempty());
			 }
	
	
	 int size(){
	    	return(BT.BTsize());  
	      }
	 
}
