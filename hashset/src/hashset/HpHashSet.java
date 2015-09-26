package hashset;
	import hashset.LinkList.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.lang.Object;
import java.util.Scanner;
	
		
public class HpHashSet {
	
	
	
	static int hasnextcount = 0;
	
	public class myIterator implements Iterator{
		
		
		
		public Object next(){
			
			return(element[hasnextcount].iteratenextval());
		}
	
		public void remove(){}

		@Override
		public boolean hasNext() {
			while(hasnextcount != tablecapacity){
				 if((element[hasnextcount].iteratenext()) == false)
						 {
					 hasnextcount++;
					 continue;
				 }
				 else{ return true;}
				 
				}return false;
		}
	
	}
	
	
	
	static int tablecapacity = 15;
	static int countofelement = (int)(tablecapacity * 0.75);
	public LinkList element[] = new LinkList[tablecapacity];// creating the object of 1st 15 element of linklist
	int RowValue = 0,counter;
	public LinkList copyElement[];
	static LinkList ItteratingE;
	 LinkList first;
	 
	
	// hashset1 newhashset = new hashset1();
	 
	 public HpHashSet() {
		 for( int i = 0; i < element.length; i++ ) {
			 element[i] = new LinkList();  // initializing the element as object as LinkList for 1st 15 element (not as an array, every thing as linklist and its node) 
		 }									//i think i did mistake by creating 2 times the objects
	 }
	  
	 //ADD METHOD
	 
	 
	 public void add(Object newelement)
	 {
		 RowValue =  newelement.hashCode()%15;     //hashset value calculation 
		 element[RowValue].addToLinkList(newelement); //passing the value to the func in linklist class 
		 
		 if(RowValue > countofelement){
			 tablecapacity = tablecapacity*2;
			 countofelement = (int)(tablecapacity*0.75);
			 LinkList copyElement[] = new LinkList[countofelement+1];
			 copyElement = element;
			 this.element = new LinkList[tablecapacity];
			 element = copyElement;
			 
		 }
	 }
	 
	 public void contains(Object Objecttoprint)
	 {
		 RowValue =  Objecttoprint.hashCode()%15;
		 System.out.println(element[RowValue].containlinklist(Objecttoprint));		 
		 
		 if((1>0)==true){
			 
		 }
		 
	 }
	 
	 public void remove(Object Objecttoremove)
	 {
		 RowValue =  Objecttoremove.hashCode()%15;
		 if(element[RowValue].removethiselement(Objecttoremove) == true)
		 {
			 System.out.println("removed");
		 }
		 else{
			 System.out.println("your element does not contained in the list");
		 }
	 }
	 
	 myIterator iterateAll = new myIterator();
	
	 public void iterator(){
		 
		System.out.println(iterateAll.hasNext());
		System.out.println(iterateAll.next());
		 
	 }
	 
	 
	 public void isEmpty(){
		 if(countofelement == 0)
			 System.out.println("true");
		 else{
			 System.out.println("false");
		 }
	 }
		



}
