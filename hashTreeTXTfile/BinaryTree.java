import java.util.*;

public class BinaryTree{
	
	static int numberofelement,numberofcontain;
	BinaryTree presentnode,minnode=null;
	private BinaryTree Rchild,Lchild,previousnode;
	static BinaryTree basenode,staticnode;
	Object value = null;
	int HashValue = 0,noforserching=0;
	private int visited = 0;
	
	BinaryTree(){
		
	}
	
	BinaryTree(Object next,BinaryTree presentnode1){
		visited = 0;
		numberofelement++;
		numberofcontain++;
		value = next;
		HashValue = next.hashCode();
		Rchild = null;
		Lchild = null;
		previousnode=presentnode1;
		System.out.println("previousnode"  + previousnode  );
		System.out.println(value);
	}
	
	
	BinaryTree createbasenode(Object nextvalue,BinaryTree previousnode){
		
				 staticnode = new BinaryTree(nextvalue,previousnode);
				 return(staticnode);
	}
	
	
	BinaryTree nextnode(){
		return basenode;
	}
	
	BinaryTree getstaticnode(){
		return staticnode;
	}
	
	BinaryTree getbase(){
		return basenode;
	}
	
	
	
	
	

	boolean addToLinkList(Object newobject,int hashvalueadd){   /////////////////ADD DONE/////////////////////
	
	
				if(basenode==null){
			basenode = createbasenode(newobject,null);
		
			staticnode = basenode;
			return true;
		}else{
			presentnode = basenode;
		}
		
		boolean lastcheck=true;
		while(lastcheck==true){
			
		if(presentnode.value.equals(newobject)){
			System.out.println("value already present");
			return false;
		}
		
		else if(hashvalueadd>presentnode.HashValue){
			if(presentnode.Rchild == null){
				presentnode.Rchild = new BinaryTree(newobject,presentnode);
				System.out.println("Rchild" + presentnode.Rchild + presentnode.Rchild.previousnode);
				return true;
			}
			else{presentnode = presentnode.Rchild;
				continue;
			}
		}
				
		else if(hashvalueadd<presentnode.HashValue){
			
			if(presentnode.Lchild == null){
				presentnode.Lchild = new BinaryTree(newobject,presentnode);
				if(staticnode.HashValue>presentnode.Lchild.HashValue){
					staticnode = presentnode.Lchild;
				}
				System.out.println("Lchild" + presentnode.Lchild+ presentnode.Lchild.previousnode);
				return true;
			}
			else{presentnode = presentnode.Lchild;
				continue;
			}
		}
		}System.out.println("your value is having some problem");
		return false;
		
				
	}
	
	
	BinaryTree Backtrack(BinaryTree backnode){
		
		if(backnode == basenode)
		{return backnode;
			}else
				 return(backnode.previousnode);
			
	}
		

	
	
	public boolean HasNextnode(){  	                   ////////////////////HASNEXT//////////////////////////////
		
		if(basenode==null){
			return false;
			}else{
				
				presentnode = staticnode;
				

				while(numberofelement>0){
			 if(presentnode.visited==0){
			numberofelement--;
			presentnode.visited = 1;
			System.out.println("before swap"+presentnode+staticnode);
			staticnode = presentnode;
			System.out.println("after swap"+presentnode+staticnode);
			return true;
			}
			 else if(presentnode.Lchild!=null){
			    if(presentnode.Lchild.visited==0){
			presentnode = presentnode.Lchild;
			continue;}
			}

			else if(presentnode.Rchild!=null){System.out.println("visited"+presentnode.Rchild.visited);
				if(presentnode.Rchild.visited==0){
			presentnode = presentnode.Rchild; 
			continue;}
			}
			 else{System.out.println("before backtrack"+presentnode);
				 presentnode =Backtrack(presentnode);
				 System.out.println("after backtrack"+presentnode);
			   continue;
			}System.out.println("present node before while"+presentnode);
						
			} return false;

	} }
	
 public Object PresentNodeVal(){		/////////////////PresentNodeValue///////////////////////////////////
	 
	 if(basenode==null){
			return false;
	}else{
	 return(staticnode.value);}
		
	}
 
	
	boolean containsvalue(int HashValueTree){    ////////////////////////////CONTAINS//////////////////////
	
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
						
	
	  boolean BTIsempty(){
		  if(basenode==null){
			  return true;
		  }else return false;
	  }


	  int BTsize(){
		  return(numberofcontain);
	      }
	  
	  
     
}
	




