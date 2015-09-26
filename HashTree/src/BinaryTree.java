import java.util.*;

public class BinaryTree{
	
	/* @numberofelement
	 * @numberofcontain
	 * @presentnode,Rchild,Lchild,previousnode,basenode,staticnode;
	 * @value: for storing the values
	 * @HashValue: for comparing the variables
	 * @visited: for keeping record of node already accessed
	 */
	static int numberofelement,numberofcontain;
	BinaryTree presentnode,minnode=null;
	private BinaryTree Rchild,Lchild,previousnode;
	BinaryTree basenode,staticnode;
	Object value = null;
	int HashValue = 0,noforserching=0;
	private int visited = 0;
	
	BinaryTree(){
		
	}
	
	/*
	 * creation of new node by constructor
	 */
	BinaryTree(Object next,BinaryTree presentnode1){
		visited = 0;
		numberofelement++;
		numberofcontain++;
		value = next;
		HashValue = next.hashCode();
		Rchild = null;
		Lchild = null;
		previousnode=presentnode1;
		
	}
	
	/*
	 * creation of the basenode
	 */
	
	BinaryTree createbasenode(Object nextvalue,BinaryTree previousnode){
		
				 staticnode = new BinaryTree(nextvalue,previousnode);
				 return(staticnode);
	}
	

	/*BinaryTree nextnode(){
		return basenode;
	}
	
	/*
	 * geting the static node for traversal in next time
	 */
	BinaryTree getstaticnode(){
		return staticnode;
	}
	
	/*
	 * geting the basenode
	 */
	BinaryTree getbase(){
		return basenode;
	}
	
	
	
	
/*
 * Addition of next element:
 	
 */

	boolean addToLinkList(Object newobject,int hashvalueadd){   
	
	
				if(basenode==null){
			basenode = createbasenode(newobject,null);
		
			staticnode = basenode;
			return true;
		}else{
			presentnode = basenode;
		}
		
		boolean lastcheck=true;
		while(lastcheck==true){
			
		/*
		 * if value already exist it return false	
		 */
			String S1 = (presentnode.value).toString();
			
		if(presentnode.HashValue==hashvalueadd){
			System.out.println("value already present");
			return false;
		}
		/*
		 * if value is greater, create a rite child node
		 */
		else if(hashvalueadd>presentnode.HashValue){
			if(presentnode.Rchild == null){
				presentnode.Rchild = new BinaryTree(newobject,presentnode);
			
				return true;
			}
			else{presentnode = presentnode.Rchild;
				continue;
			}
		}
			/*
			 * else creating left child	
			 */
		else if(hashvalueadd<presentnode.HashValue){
			
			if(presentnode.Lchild == null){
				presentnode.Lchild = new BinaryTree(newobject,presentnode);
				if(staticnode.HashValue>presentnode.Lchild.HashValue){
					staticnode = presentnode.Lchild;
				}				
				return true;
			}
			else{presentnode = presentnode.Lchild;
				continue;
			}
		}
		}System.out.println("your value is having some problem");
		return false;
			
	}
	
	/*
	 * function for backtracking the node 
	 */
	BinaryTree Backtrack(BinaryTree backnode){
		
		if(backnode == basenode)
		{return backnode;
			} if(backnode.visited==0){
				 return(backnode);
			}else{ return(Backtrack(backnode.previousnode)); }
	}
	
	
	BinaryTree getpresentnode(BinaryTree getpresent){
		 if(getpresent.Lchild!=null){
			    if(getpresent.Lchild.visited==0){
			    	getpresent = getpresentnode(getpresent.Lchild);
		}
			}
		 if(getpresent.visited==0){
			 return getpresent;}

		 if(getpresent.Rchild!=null){
				if(getpresent.Rchild.visited==0){
					getpresent = getpresentnode(getpresent.Rchild); 
			}
			}
		 if(getpresent.visited==0){
			 return getpresent;
		 }else{
			 getpresent =Backtrack(getpresent); 
			   return getpresent;
		 }
		
	}

	
	/*
	 * NextNodeVal fun: for traversal and finding the next value
	 */
	
	public Object NextNodeVal(){  	                   
		
		if(basenode==null){
			return false;
			}else{
				
				presentnode = staticnode;
				

				while(numberofelement>0){
			 if(presentnode.visited==0){
			numberofelement--;
			presentnode.visited = 1;
			
			staticnode = presentnode;
			
			return(presentnode.value);
			}
			 else{
				
				presentnode = getpresentnode(presentnode);
				continue;
			}		 			
			 
		}
						
	} System.out.println("no more element present");
	return null;

	} 
	
	/*
	 * HasNextnode fun: for checking if next value exist in tree
	 */
	
 public boolean HasNextnode(){
	 
	 if(basenode==null){
			return false;
	}else{
		presentnode = staticnode;
	}
	 if(numberofelement>0){
		 if(staticnode.value!=null){
	 return true;}
		 else return false;}
	 return false;
	
		
	}
 
 /*
  * checking for a specific value in the tree
  */
	
	boolean containsvalue(int HashValueTree){    
	
		noforserching = numberofcontain;
		
	if(basenode==null){
	 System.out.println("the tree is blank"); 	
	return false;	
	}else{
		presentnode = basenode;
	}
	
	while(noforserching>0){
		 if(presentnode.HashValue==HashValueTree){
				return true;
		}else if(presentnode.Rchild == null && presentnode.Lchild == null){
			return false;
		}else if(presentnode.HashValue<HashValueTree){
		    
		presentnode = presentnode.Rchild;
		
		}else if(presentnode.HashValue>HashValueTree){
					presentnode = presentnode.Lchild; 
		continue;}
		}return false;
	}
		
	/*
	 * checking if the tree is empty
	 */
	
	  boolean BTIsempty(){
		  if(basenode==null){
			  return true;
		  }else return false;
	  }

/*
 * checking the size of tree(number of element)
 */
	  int BTsize(){
		  return(numberofcontain);
	      }
	  
	  
     
}
	




