import java.util.Vector;
/*
 *@dejekstra: Its Implementation of dijkstra
 *algorithm.
 *
 */

public class dejekstra3  {
	/*
	 * matrix: a dataset for tesing poupose
	 */
	static int matrix[][] = {{0,1,2,0,0,0},
		 {0,0,1,0,0,0},
		 {0,0,0,0,0,0},
		 {0,0,1,0,0,0},
		 {0,0,0,1,0,0},
		 {0,0,0,2,1,0}};
	
	
	static node queue[]; 
	static node set[]; 
	static Integer present_min_Node = (Integer) null;
	static long milliSeconds = 0;
	
	public static void start() {
        milliSeconds = System.currentTimeMillis();
         }
	
	 public static void end() {
        System.err.println(  " Time : " + ( System.currentTimeMillis() - milliSeconds) );
         }
	 
	/*
	 * @node: each node has been represented as 
	 * a class
	 * 
	 */
	public static class node{
		node(int length){
			adj = new node[length];
			weight_between_adj = new int[length];
			visited =0;
			j= new int[length];
		}
		int j[];
		int visited ;
		int distance;
		node adj[] ;
		int weight_between_adj[] ;
		node parentNode;
	}
	
	/*
	 * @weightbetweenNode: to store the weight 
	 * between two nodes
	 * 
	 */
	
	public static class weightbetweenNode{
		int weight_between_node;
	}
	
	/*
	 * @update_child:Traversal through each adjacent child node 
	 * and calulating the min_distance from the source
	 * 
	 */
	public static void update_child(node presentnode,node childnode,int weight){
		
		
		if(weight==0)
			weight = (int)Float.POSITIVE_INFINITY-(presentnode.distance+10);
		
		if(childnode.distance > presentnode.distance+weight)
		{
			childnode.distance = presentnode.distance +weight;
			childnode.parentNode = presentnode;
		}
		
	}
	
	/*
	 * @initialize_nodes: To initialize all nodes with their 
	 * Neighbor. It assign a large number(1000000) to each node  
	 * except the destination as equivalent to infinity.
	 */
	
	public static void initialize_nodes(int matrix[][]){
		int length = matrix.length; 
		
		for(int i = 0; i<length;i++)
		{
			node N = new node(length);
			 queue[i]= N;
			 queue[i].distance = 1000000;
		}
		
		queue[0].distance = 0;
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(matrix[i][j]!=0){
					queue[i].adj[j]= queue[j];
					queue[i].j[j] = j;
					queue[i].weight_between_adj[j]= matrix[i][j];
					
					
				}else{
					queue[i].adj[j]= null;
					queue[i].weight_between_adj[j]= 0;
				}
					
			}
		}
	}
/*
 * @Extract_min:To get the node with min_distance among
 * the non visited nodes 	
 */
	
	public static boolean Extract_min(){
		int temp = 0 ;
		int temp2 = 1;
		node temp_1 = new node(0);
		Vector<node> temp_node = new Vector<node>(); 
		Vector<Integer> temp_index = new Vector<Integer>();
		int i,j;
		
		for(i=0;i<queue.length;i++){
			
			if(queue[i].visited==0){
				temp_node.add(queue[i]);
				temp_index.add(i);
				
				}
			}
		
		if(temp_node.size()==0){
			return false;
		}else{
																										//present_min_Node = 0;
		for(i =0;i<temp_node.size();i++){
			
		if(temp_node.get(temp).distance>=temp_node.get(i).distance){
				temp = i;
				present_min_Node = temp_index.get(i);
				continue;
			}
		
		}
		
		return true;
	}		
	
	}
	
	/*
	 * @dejeckstra: this function implements the 
	 * dijeckstra algorithm
	 */
	public static void dejeckstra(){
		int length = matrix.length;
		boolean allVisited;
		node child;
		int weightbetweenTwo;
		int index =0;
		int lengthoftraversal = length;
		while(lengthoftraversal!=0){
		 
			if(Extract_min()){
			
			for(int j=0;j<length;j++){
				if(matrix[present_min_Node][j]!=0){
				child = queue[present_min_Node].adj[j];
				
				weightbetweenTwo = queue[present_min_Node].weight_between_adj[j];
				update_child(queue[present_min_Node],child,weightbetweenTwo);
				}
				}
			
			queue[present_min_Node].visited = 1;
			lengthoftraversal--;
			present_min_Node = (Integer)null;
			
			}else{
				
				break;
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args){
		
		
		int v,e;
		v = Integer.parseInt(args[0]);
		e = Integer.parseInt(args[1]);
		
		 System.out.println("Weighted undirected graph:");
		 GraphInputGenerator g = new GraphInputGenerator(v, e, true, false);
				 
		 matrix = g.get_adj();
		 
		
		 int length = matrix.length;
		 queue = new node[length];
		 set = new node[length];
		 
		//Initialization of matrix//
		 
		 
		 initialize_nodes(matrix); 			
		for(int i=0;i<length;i++){
				for(int j=0;j<length;j++)
				{
					if(matrix[i][j]!=0)
					System.out.print(" "+matrix[i][j]+" ");
			}	
				System.out.println();
		 }
		 
		 start();
		dejeckstra();
		end();
		for(int i=0;i<length;i++){
			if(queue[i].distance==1000000)
				System.out.println(" destination "+i+" cant be reached from sourse");
			else			
			System.out.println(" destination and weight :"+i+" "+queue[i].distance);
	   }
	
	}	
}
