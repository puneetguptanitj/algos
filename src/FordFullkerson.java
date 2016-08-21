import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FordFullkerson {

	private static class Node{
		List<Node> neighbors;
		int value;
	}
	
	private static boolean bfs(Node source, Node sink, List<Node> path){
		Queue<Node> queue = new LinkedList<>();
		queue.add(source);
		Set<Node> scanned = new HashSet<>();
		while(queue.isEmpty()){
			Node head = queue.poll();
			path.add(head);
			if(head == sink){
				return true;
			}
			for(Node node: head.neighbors){
				if(!scanned.contains(node)){
					queue.add(node);
				}
			}
		}
	}
	
	public static void main(String []args){
		Node source       = null;
		Node sink         = null;
		Node [] path      = null;
		bfs(source, sink, path);
	}
}
