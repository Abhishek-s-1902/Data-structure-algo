import java.util.Vector;
/*
 * @Author: Abhishek Sharma
 * 
 * @Kruskals: This is based on Kruskal Algorithm 
 * for providing the minimal Spanning tree
 * and uses the Union set concept for making the 
 * Traversal fast.
 *  
 */

public class Kruskals {
	
	/*
	 * matrix: a dataset for tesing poupose
	 */
	static int matrix[][] = {{0,1,2,0,0,0},
							 {0,0,1,0,0,0},
							 {0,0,0,0,0,0},
							 {0,0,1,0,0,0},
							 {0,0,0,1,0,0},
							 {0,0,0,2,1,0}};
	
	/*
	 * All below variable has been chosen for run time pourpose
	 * @V: contains the vertex set
	 * @E_array: contains the edge set 
	 * @SetofEdge: edges which are included in final spanning tree
	 * 
	 */
	static Vertex_V V[];
	static Vector<edge> E_array = new Vector<edge>();
	static Vector<edge> SetofEdge = new Vector<edge>(); 
	static edge E;
	static int count_forEdge;
	static long milliSeconds = 0;
	
	
	public static void start() {
        milliSeconds = System.currentTimeMillis();
           }
	
	 public static void end() {
        System.err.println(  " Time : " + ( System.currentTimeMillis() - milliSeconds) );
         }
	 
	/*
	 * @Vertex_V: each vertex has been represented as 
	 * a class
	 * 
	 */
	static class Vertex_V{
		
		Vertex_V(int i){
			Rank = i;
			IsRoot = false;
			nextRoot = null;
	}
		Vertex_V nextRoot;
		boolean IsRoot;
		final int Rank;
		public int height;
		
	}
	
	/*
	 * @edge: class representing each edge
	 */
	static class edge{
		
		edge(Vertex_V A1,Vertex_V B1,int Weight1){
			A = A1;
			B = B1;
			weight = Weight1;
			
		}
		
		Vertex_V A;
		Vertex_V B;
		int weight;
		
	}
	
	/*
	 * @find: to find the root of any 
	 * vertex
	 */
	
	public static Vertex_V find(Vertex_V X)   //returns the root of this
	{
		Vertex_V C = X;
		
		
		while(C.IsRoot != true){
			if(C.nextRoot!=null){
			C = C.nextRoot;
		}else
			break;
		}
		
	return C;
	}
	
	/*
	 * @Union: for merging two Vertex into one set
	 * if they are in distinct set
	 */
	public static void Union(Vertex_V A, Vertex_V B){
		if(A.height<=B.height){
			A.nextRoot = B;
			A.IsRoot = false;
			B.IsRoot = true;
			B.height++;
		}else{
			B.nextRoot = A;
			B.IsRoot = false;
			A.IsRoot = true;
			A.height++;
		}
	}
	
	/*
	 *@sort: for sorting the edges on basis of their
	 *weight
	 */
	public static void sort(){
		edge e1;	
		 for (int i=0; i<count_forEdge-1; i++) {
		      for (int j=0; j<count_forEdge-i-1; j++) {
		    	 if(E_array.get(j).weight>E_array.get(j+1).weight) 
		        {
		          e1  = E_array.get(j);
		          E_array.set(j,E_array.get(j+1));
		          E_array.set((j+1),e1);
		       }
		     }
		 }	
		
	}

	
	public static void main(String[] args) {
	
		int v,e;
		v = Integer.parseInt(args[0]);
		e = Integer.parseInt(args[1]);
		
		System.out.println("Weighted undirected graph:");
		 GraphInputGenerator g = new GraphInputGenerator(v, e, true, false);
		
		matrix = g.get_adj();
		
		int length = matrix.length;
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++)
			{
				System.out.print(" "+ matrix[i][j]);
			}
			System.out.println();
		}
		
		V = new Vertex_V[length];
		edge e1;
		Vertex_V  a,b;
		
		start();    		//start//
		
		for(int i=0;i<length;i++){
			V[i] = new Vertex_V(i); 
		}
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++)
			{
				if(matrix[i][j]!=0){
				E = new edge(V[i],V[j],matrix[i][j]);
				count_forEdge++;
				E_array.add(E);}
			}
		}
		
		
	sort();		//sorting
		
		
	for(int i=0;i<E_array.size();i++){
		e1 = E_array.get(i);
		
		a = find(e1.A);
		b = find(e1.B);
		
		if(a!=b){
			Union(a,b);
			SetofEdge.add(e1);
		}
	}
	
	 end();				//end//
	for(int i=0;i<SetofEdge.size();i++){
		System.out.println("edge :"+i);
		System.out.println("A: "+SetofEdge.get(i).A.Rank+"B :"+SetofEdge.get(i).B.Rank+" weight "+SetofEdge.get(i).weight);
		
	}
		
}
		
}


