import java.util.Stack;

public class SerDeserBT {
	
	private static String SPACE = " ";
	private static Node NULL     = new Node();
	private static class Node{
		Node left ;
		Node right ;
		int  value;
	}
	
	public static void main(String []args){
		Node a3  = new Node(); a3.value = 3;
		Node a1  = new Node(); a1.value = 1;
		Node a4  = new Node(); a4.value = 4;
		Node a6  = new Node(); a6.value = 6;
		Node a8  = new Node(); a8.value = 8;
		Node a2  = new Node(); a2.value = 2;
		a3.left = a1; a3.right = a2;
		a1.left = a4; a1.right = a6;
		a4.left = a8;
		StringBuilder builder = new StringBuilder();
		serialize(a3, builder);
		System.out.println(builder.toString());
		Node root = deserialize(builder.toString());
		
		builder = new StringBuilder();
		serialize(root, builder);
		System.out.println(builder.toString());
		
	}

	private static Node deserialize(String serialized) {
		Stack<Node> stack = new Stack<>();
		String [] values  = serialized.split(SPACE);
		Node root         = null;
		for(String value : values){
			Node current  = null;
			if(!value.equals("#")){
				current  = new Node();
				current.value = Integer.valueOf(value);
				current.left  = NULL;
				current.right = NULL;
			}
			if(!stack.isEmpty()){
				Node top = stack.peek();
				if(top.left == NULL){
					top.left  = current;
				}else{
					top.right = current; 
					stack.pop();
				}
			}
			if(current != null){
				if(root == null){
					root = current;
				}
				stack.push(current);
			}
		}
		return root;
	}

	private static void serialize(Node root, StringBuilder builder) {
		if(root == null){
			builder.append("#").append(SPACE);
			return;
		}
		builder.append(root.value).append(SPACE);
		serialize(root.left,builder);
		serialize(root.right, builder);
	}

	
}
