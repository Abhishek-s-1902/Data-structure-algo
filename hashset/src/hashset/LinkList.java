package hashset;

public class LinkList {
	
	class Node {
		
		public Object i;       // these variables belong to each object i created 
		public Node nextlink;
		
		
		public Node( Object copyObject, Node next) {    //constructor for assigning the values to i and making the current nextlink reference as null
			i = copyObject;								//when next time a new object get created it will be set as refrence of next object (check the sequence in
			this.nextlink = next;						// addToLinkList method and setnext() method)
			ItteratingE++;								//this variable i had kept for traversing purpose,, just ignore it,, couldn't able to manage
		}
		
		public Object getValue() {
			return i;					//returnig the value of present object
		}
		
		public Node getNext() {    
			return nextlink;      //returning the nextling calue of current NODE object
		}
		
		public void setNext( Node next ) {
			this.nextlink = next;        //setting the nextlink value of present node to next node reference
		}
		
		
	}
	
	//variables
	protected Node nextlink1;
	public static int ItteratingE=0;
	//
	
	
	
	
	public LinkList() {
	    nextlink1 = null;  
	}
	
	
	    
	public void createHead(Object copyObject) {		//check the node constructor
	    nextlink1 = new Node(copyObject, null);  //for 1st time if no other node has been created i am creating the 1st node for the object say element[0]..
	}											//and i am storing the reference to next node in element[0], and storing the present value in this node 		
	
	public Node getHead() {
		return nextlink1;					//keeping the reference of very first node created in nextlink1 for traversing purpose
	}
	
	
	/*public boolean findnextval(Object Otraverse){
		nextlink1 = Otraverse.nextlink1;
		for(int i=0;i<=ItteratingE;i++){
			if()
		}
		}*/
	
	
	public boolean containlinklist(Object Objecttoprint)
	{
			Node nextlink1 = this.getHead();
			do{
			if(nextlink1.i.equals(Objecttoprint))
			return true;
			}while( nextlink1.getNext() != null) ;
			return false;
	}
	
	public boolean removethiselement(Object Objecttoremove){
		Node node1 = this.getHead();
		if(node1.i.equals(Objecttoremove))
		{
			nextlink1.i = null;
			return true;
		}
		else{
			while( node1.getNext() != null){
				node1 = node1.getNext();
				if(node1.i.equals(Objecttoremove))
				return true;	
			}
		}
		return false;
	}
	
	static Node iteratenode;
	
	public boolean iteratenext()
	{
		if(iteratenode == null){
		iteratenode = this.getHead();
		}
		
		if(iteratenode.getNext() == null){
		if(iteratenode.i == null)
		{
			return false;
		}
		else
		{ return true;}
		}
		boolean check = true;
		
		while(true){
			
		if(iteratenode.i == null)
		{
			iteratenode = iteratenode.getNext();
			continue;
		}
		else{
			iteratenode = iteratenode.getNext();
			check = false;
			return true;
		
		}
		}			
			
	}
	
	
	
	public Object iteratenextval(){
		
	if(iteratenode == null){
		
		iteratenode = this.getHead();
		return (iteratenode.i);
		}
	
	else{
		
		return(iteratenode.i);
	}
		
	}
	
			
	
	public void addToLinkList(Object copyObject) {
		Node nextlink1 = getHead();   //checking if there 1st node is present or not..
		if( nextlink1 == null ) {		
			createHead(copyObject);		//if not calling the createhead
		} else {
			Node head1 = nextlink1;				//else taking the existing node into a variable head1
			while( head1.getNext() != null ) {			//traversing through all node till end for the particular object say element[0]
				head1 = head1.getNext();				
			}
			if( head1.getNext() == null ) {				
				Node node = new Node(copyObject, null);			//after reaching to the last not, i am storing the value of object into that node (check i variable)and..
				head1.setNext(node);						//creating the next node and keeping that reference in this node for next time traversing (check the setnext())
			}										
		}
	}
}
