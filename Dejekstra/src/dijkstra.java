import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class dijkstra {
	
	 
	static int finalpath[][];
	static int backtrac[];
	static int max_traversal;
	static int minVal_weight[] ;
	static int weight[][] = {{0,4,2,1,0},
						{0,0,0,4,2},
						{0,0,0,3,0},
						{0,1,0,0,3},
						{0,0,0,0,0}};
	
	public static int min_of_two(int i,int j){
		if(i>j)
			return i;
		else
			return j;
	}
	
	/*
	 * @min_node: for getting the last min_node for
	 * the present node
	 */
	

	static public int min_node(int presentNode){
		int node=0;
		int min=0;
		for(int i=1;i<finalpath.length;i++){
			if(finalpath[i][presentNode]<=finalpath[i-1][presentNode]&&finalpath[i][presentNode]!=0){
				min = finalpath[i][presentNode];
				node = i;}
			}
		//System.out.println("retun node"+ node);
		return node;
		}
	
	
	/*
	 * @min_value: for getting the last min_value for
	 * the present node from source till the present 
	 * itteration
	 * 
	 */
	
	static public int min_value(int presentNode){
		
		int minnode=0;
		int min=0;
				
		
		for(int i=0;i<finalpath[0].length;i++){
			if(finalpath[i][presentNode]==0)
				continue;
			else if(min==0){
			minnode=i;
			min = finalpath[i][presentNode];
			continue;
			}				
			else if(finalpath[i][presentNode]<=finalpath[minnode][presentNode]){
				min = finalpath[i][presentNode];
				minnode = i;
				continue;
				}
			}
		System.out.println("min val for present "+presentNode+ " :"+ min);
		return min;
	}
	
	
	/*
	 * @calculate_path: for calulating the min spanning 
	 * matrix for dejekstra algorithm
	 */
	static public void calculate_path(int matrix[][]){
		
		int presentNode;
		int lenghtofMatrix = matrix.length;
		backtrac = new int[matrix.length];
		minVal_weight = new int[matrix.length];
		int widthofGraph = matrix[0].length;
		int backtracknode, minvalueForpresentNode;
		
		
		
		Queue<Integer> path = new LinkedList<Integer>();
		
		path.add(0);
		int max_val =0;
		
			
		while(!path.isEmpty()){
		presentNode = path.peek();
		if(presentNode==0)
			minvalueForpresentNode = 0;
		else
		minvalueForpresentNode =  min_value(presentNode);                         
		//System.out.println(" PN and min: "+presentNode+" "+  minvalueForpresentNode);
		for(int j = 1;j<widthofGraph; j++){
			
			if(matrix[presentNode][j]!=0)
			{	
				System.out.println(" matrix for PN and j: val"+ presentNode+" "+ j+" "+ matrix[presentNode][j] );
				finalpath[presentNode][j] = min_of_two(finalpath[presentNode][j], matrix[presentNode][j]+minvalueForpresentNode);
				System.out.println(" PN and j: val"+ presentNode+" "+ j+" "+ finalpath[presentNode][j] );
				if(path.contains(j))
					continue;
				else
				path.add(j);
								
			}
		}	
		
		if(max_traversal==lenghtofMatrix*lenghtofMatrix)
			break;
		//System.out.print("first elemt PN:"+ path.peek());
		path.remove();
		//System.out.print("queue val at PN:"+presentNode+": ");
		for(int s : path) { 
			  System.out.print(" "+ s); 
			}
		//System.out.println("break: ");
		max_traversal++;
		
		}
		
		minVal_weight[0] = 0;
		backtrac[0] = 0;
		for(int i= 1;i<matrix.length;i++){
			minVal_weight[i]=min_value(i);
			backtrac[i] = min_node(i);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		int nextnode=0;
		int length ;                                                // weight.length;
		int v = Integer.parseInt(args[0]);
		int e = Integer.parseInt(args[1]);
		System.out.println("Non-weighted undirected graph:");
		GraphInputGenerator g = new GraphInputGenerator(v, e,
		false, false);
		//g.genGraphInput();
		
		/*weight = g.get_adj();
		
		for(int i= 0;i<weight.length;i++){
			for(int j= 0;j<weight[0].length;j++){
				System.out.print( weight[i][j]);
			}
			System.out.println(); 
		}
		*/
		length = weight.length;
		finalpath = weight ;                             //intializing the finalpath
		
		System.out.println("length "+ finalpath.length);
		
		calculate_path(weight);
		
		
		for(int i= 1;i<weight.length;i++){
			
			System.out.println("weight from 0 to :"+i+" is "+ minVal_weight[i]);
		}
		
		
		
		for(int i= 0;i<weight.length;i++){
			for(int j= 0;j<weight[0].length;j++){
				System.out.print( finalpath[i][j]);
			}
			System.out.println(); 
		}
		/*for(int i= 0;i<backtrac.length;i++){
			
			System.out.println("form node 0 to :"+ i );
			for(int j=i;j>=0;)	
			{   
				nextnode = backtrac[j];
				j=backtrac[j];
				System.out.println("weight from 0 to :"+j+" is "+ backtrac[j]);
				if(j==0)
					j--;
			}
			
		}*/
		
		
	
	/*System.out.println("Weighted undirected graph:");
	g = new GraphInputGenerator(v, e, true, false);
	g.genGraphInput();
	System.out.println("Non-weighted directed graph:");
	g = new GraphInputGenerator(v, e, false, true);
	g.genGraphInput();
	System.out.println("Weighted directed graph:");
	g = new GraphInputGenerator(v, e, true, true);
	g.genGraphInput();*/
	}
}
