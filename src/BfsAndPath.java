import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BfsAndPath {
	
	/*     2 -- 4
	 *   /     /
	 * 1      /
	 *   \   /
	 *     3 -- 5
	 */
	
	private static class Edge{
		Node destination;
		int  value;
		public Edge(Node dest, int value){
			this.destination = dest;
			this.value       = value;
		}
	}

	private static class Node{
		List<Edge> edges    = new ArrayList<>();
		char label;
		public Node(char label){
			this.label = label;
		}
		public String toString(){
			return String.valueOf(label);
		}
	}
	
	private static boolean bfs(Node source, Node sink, Map<Node,Node> parent){
		Queue<Node> queue = new LinkedList<>();
		queue.add(source);
		Set<Node> scanned = new HashSet<>();
		while(!queue.isEmpty()){
			Node head = queue.poll();
			if(head == sink){
				return true;
			}
			if(!scanned.contains(head)){
				for(Edge edge: head.edges){
					if(parent.get(edge) == null){
						parent.put(edge.destination, head);
					}
					queue.add(edge.destination);
				}
				scanned.add(head);
			}
		}
		return false;
	}
	
	private static void printPath(Map<Node, Node> parent, Node a1, Node a4){
		Node current = a4;
		while(current != null){
			System.out.println(current.label);
			current = parent.get(current);
		}
	}
	
	public static void main(String []args){
		Map<Node,Node> parent = new HashMap<>();
		Node a1 = new Node('1'); Node a2 = new Node('2'); Node a3 = new Node('3');Node a4 = new Node('4');Node a5 = new Node('5'); 
		a1.edges.add(new Edge(a2,1));  a1.edges.add(new Edge(a3,1));
		
		a2.edges.add(new Edge(a4,1));
		
		a3.edges.add(new Edge(a4,1)); a3.edges.add(new Edge(a5,1));
		if(bfs(a1, a4, parent)){
			printPath(parent, a1, a4);
		};
	}
}
