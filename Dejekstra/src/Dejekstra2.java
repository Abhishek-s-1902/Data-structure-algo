import java.util.Vector;


public class Dejekstra2 {

	static int matrix[][] = {{0,4,2,1,0},
		{0,0,0,4,2},
		{0,0,0,3,0},
		{0,1,0,0,3},
		{0,0,0,0,0}};
	
	static weightbetweenNode weight[][] = new weightbetweenNode[5][5];
	static Vector<node> queue;
	static Vector<node> set;
	
	public static class node{
		int distance;
		Vector<node> adj;
		Vector<Integer> weight_between_adj;
		node parentNode;
	}
	
	public static class weightbetweenNode{
		int weight_between_node;
		
	}
	
	public static void update_child(node presentnode,node childnode,int weight){
		
		if(weight==0)
			weight = (int)Float.POSITIVE_INFINITY-(presentnode.distance+10);
		
		if(childnode.distance > presentnode.distance+weight)
		{
			childnode.distance = presentnode.distance +weight;
			childnode.parentNode = presentnode;
		}
		
	}
	
	
	public static void initialize_nodes(int matrix[][]){
		int length = matrix.length; 
		
		for(int i = 0; i<length;i++)
			 queue.add(new node());
		
		queue.get(0).distance = 0;
		
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(matrix[i][j]!=0){	
					queue.get(i).adj.add(queue.get(j));
					queue.get(i).weight_between_adj.add(matrix[i][j]);
				
				}	
			}
		}
		
		
	}
	
	
	public static node Extract_min(){
		node temp = new node();
		for(int i=0;i<queue.size();i++){
			if(queue.get(i).distance>queue.get(i+1).distance)
			temp = 	queue.get(i+1);
		}
		
		return temp;
	}
	
	public static void dejeckstra(){
		int length = weight.length;
		node present_min_Node;
		node child;
		int weightbetweenTwo;
		
		while(!queue.isEmpty()){
		 
			present_min_Node = Extract_min();
			set.add(present_min_Node);
			int size = present_min_Node.adj.size();
			for(int i=0;i<size;i++){
				child = present_min_Node.adj.get(i);
				weightbetweenTwo = present_min_Node.weight_between_adj.get(i);
				update_child(present_min_Node,child,weightbetweenTwo);
			}
		}
		
	}
	
	
	
	public static void main(){
		
		initialize_nodes(matrix);
		
		int length = matrix.length; 
		for(int i=0;i<length;i++){
			System.out.println(" i :"+i);
			for(int j=0;j<length;j++){
				if(matrix[i][j]!=0){	
				System.out.print(" j :"+j);
				System.out.print(" weight "+queue.get(i).weight_between_adj.get(j));
				System.out.println();
				}	
			}
		}
		
	}
	
	
}
