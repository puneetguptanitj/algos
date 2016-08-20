import java.util.concurrent.atomic.AtomicInteger;

public class Bst {
	static Integer i =0;
	public static class Node{
		private Node left;
		private Node right;
		private int value;
	}
	public static class MyBst{
		private Node root;

		public void addNode(int newValue){
			if(root == null){
				root = new Node();
				root.value = newValue;
			}else{
				addNode(root, newValue);
			}
		}

		private void addNode(Node currentRoot, int newValue){
			if(newValue <= currentRoot.value){
				if(currentRoot.left != null){
					addNode(currentRoot.left, newValue);
				}else{
					Node node = new Node(); node.value = newValue;
					currentRoot.left = node;
				}
			}else{
				if(currentRoot.right != null){
					addNode(currentRoot.right, newValue);
				}else{
					Node node = new Node(); node.value = newValue;
					currentRoot.right = node;
				}
			}
		}

		private int minValue (Node node){
			if(node.left == null){
				return node.value;
			}
			return minValue(node.left);
		}

		private boolean delete(Node current, Node parent, int value){
			if(current == null){
				return false;
			}
			if(current.value == value){
				if(parent.left == current){
					if (current.left == null && current.right == null){
						parent.left = null;
					}else if (current.left == null){
						parent.left = current.right;
					}else if (current.right == null){
						parent.left = current.left;
					}else{
						current.value = minValue(current.right);
						delete(current.right,current, current.value);
					}
				}

				if(parent.right == current){
					if (current.left == null && current.right == null){
						parent.right = null;
					}else if (current.left == null){
						parent.right = current.right;
					}else if (current.right == null){
						parent.right = current.left;
					}else{
						current.value = minValue(current.right);
						delete(current.right,current, current.value);
					}
				}
			}else if(value < current.value){
				delete(current.left, current, value);
			}else if(value > current.value){
				delete(current.right, current,value);
			}
			return true;
		}

		private boolean delete(int value){
			if(root == null ) {
				return false;
			}
			if(root.value == value){
				if(root.left == null){
					root = root.right;
				}
				if(root.right == null){
					root = root.left;
				}
				return true;
			}
			if(value < root.value){
				return delete(root.left, root, value);
			}else{
				return delete(root.right, root, value);
			}
		}

		private void inOrderTraversal(Node node){
			if(node == null){
				return;
			}
			inOrderTraversal(node.left);
			System.out.println(node.value);
			inOrderTraversal(node.right);
		}

		private void inOrderTraversal(){
			inOrderTraversal(root);
		}

	}

	private static void kthElem(int k,  AtomicInteger i, Node node){
		if(node == null){
			return ;
		}
		System.out.println("K = " + k + " i = " + i + " Node value = " + node.value);
		kthElem(k, i, node.left);
		i.incrementAndGet();
		if(k == i.get()) {
			System.out.println(node.value) ;
			return;
		}
		System.out.println("\tK = " + k + " i = " + i + " Node value = " + node.value);
		kthElem(k, i, node.right);
	}

	public static void main(String []args){
		Node node3 = new Node(); node3.value=3;
		Node node2 = new Node(); node2.value=2;
		Node node5 = new Node(); node5.value=5;
		Node node4 = new Node(); node4.value=4;
		Node node6 = new Node(); node6.value=6;


		MyBst bst = new MyBst();
		bst.addNode(3);bst.addNode(2);bst.addNode(5);bst.addNode(4);bst.addNode(6);
		bst.inOrderTraversal();
		
		bst.delete(4);

	}

}
