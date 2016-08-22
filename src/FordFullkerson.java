import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FordFullkerson {
	
	/*      1 -- 3
	 * 10  /     /
	 *   /      /
	 * 0
	 *   \
	 *    \   /
	 *     2 -- 4
	 */
	
	
	static int V = 6;
	int [][] graph = new int [V][V];
	
	public FordFullkerson(){
		for(int u =0; u< V ; u++){
			for(int v =0 ; v< V ; v++ ){
				graph [u][v] = -1;
			}
		}
		graph[0][1] = 16;
		graph[0][2] = 12;
		graph[1][2] = 10;
		graph[2][1] = 4;
		graph[1][3] = 12;
		graph[3][2] = 9;
		graph[2][4] = 14;
		graph[4][3] = 7;
		graph[3][5] = 20;
		graph[4][5] = 4;
	}
	
	private void printPath(int [] parent, int d){
		while(parent[d] != -1){
			System.out.println(parent[d]);
			d = parent[d];
		}
	}
	
	private boolean bfs(int s, int d, int [] parent){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		Set<Integer> scanned = new HashSet<>();
		while(!queue.isEmpty()){
			int current = queue.poll();
			for(int i=0; i<V; i++){
				if(graph[current][i] != -1){ //they are adjacent 
					if(parent[i] == -1){
						parent[i] = current;
					}
					if(i == d){
						printPath(parent, d);
						return true;
					}
					if(!scanned.contains(i)){
						queue.add(i);
						scanned.add(i);
					}
				}
			}
			
		}
 		return false;
	}
	
	public static void main(String []args){
		FordFullkerson fullkerson = new FordFullkerson();
		int [] parent = new int[V];
		for(int i=0; i< V; i++){
			parent[i] = -1;
		}
		fullkerson.bfs(0, 5, parent);
	}

}
