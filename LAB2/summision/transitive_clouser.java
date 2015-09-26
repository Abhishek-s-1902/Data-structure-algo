
public class transitive_clouser {
	/*
	 * @transitive_clouser: This program implements the 
	 * Floyd Warshall algorithm to calculate 
	 * the transitive_clouser matrix between each pair of node
	 * 
	 */	
	
	
	static int weight[][] = {{0,1,2},
		 {3,0,2},
		 {0,3,0}};
	
	static long milliSeconds = 0;
	
	public static void start() {
        milliSeconds = System.currentTimeMillis();
           }
	
	 public static void end() {
        System.err.println(  " Time : " + ( System.currentTimeMillis() - milliSeconds) );
       }
	 
	 /*
	  * @calculate_path:for calculating the matrix
	  * for shortest path between each pair
	  * 	
	  */
	
	static public int[][] calculate_path(int matrix[][]){
		
		int length = matrix.length;
		
		int R1[][] = new int[length][length];
		int R2[][] = new int[length][length];
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(matrix[i][j]==0 && i!=j)
				R1[i][j] = 100000;
				else
					R1[i][j] = matrix[i][j];
			}
		}	
	
		R2 = R1;
		
		for(int k=1;k<length;k++){
			for(int i=1;i<length;i++){
				for(int j=1;j<length;j++){
					
					R2[i][j] = Math.min(R1[i][j],R1[i][k]+R1[k][j]); 
					
				}
			}
			
			R1 = R2;
		}
		
		return R2;
	}
	
	
	public static void main(String[] args) {
		
		
		int v,e;
		v = Integer.parseInt(args[0]);
		e = Integer.parseInt(args[1]);
		
		System.out.println("Weighted undirected graph:");
		GraphInputGenerator g = new GraphInputGenerator(v, e, true, false);
				
		weight = g.get_adj();
		 int length = weight.length;
		
		 for(int i=0;i<length;i++){
				for(int j=0;j<length;j++){	
				System.out.print(" "+weight[i][j]+" ");
				}System.out.println();
			}
		 
		int rfinal[][] = new int[length][length];
		
		start();
		rfinal = calculate_path(weight);
		end();
		System.out.println("final matrix:");
		
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(rfinal[i][j]<100000&&rfinal[i][j]>0)
					System.out.print(" 1 ");
				else 
			System.out.print(" 0 ");
			}System.out.println();
		}
		
		
	}

}
