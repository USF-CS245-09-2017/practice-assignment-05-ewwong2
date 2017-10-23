
public class BSTree {
	
	private Node root;
	
	public BSTree() {
		// start a new BSTree with no elements
		root = null;
	}
	
	public BSTree(Comparable<String> data) {
		// start a new BSTree with one element
		root = new Node(data);
	}
	
	public void insert(Comparable<String> data) {
		if (root == null) {
			// if the BSTree is empty
			// set root to a new Node with data value
			root = new Node(data);
		} else /*root != null*/ {
			// if the BSTree is not empty
			// perform helper method at root
			insert(data, root);
		}
	}
	
	private Node insert(Comparable<String> data, Node node) {
		if (node == null) {
			// Base Case
			// If there is an empty spot (node is null)
			// then return a new Node with data value
			return new Node(data);
		} else if (node.getData().compareTo((String) data)>=0) {
			// Recursive Case 1
			// If current node is larger than data
			// then set its left to either its
			// left (if it exists) or the new Node
			node.setLeft(insert(data, node.getLeft()));
			// return current node
			return node;
		} else /*node.getData().compareTo((String)data)<0*/{
			// Recursive Case 2
			// If current node is smaller than data
			// then set its right to either its
			// right (if it exists) or the new Node
			node.setRight(insert(data, node.getRight()));
			// return current node
			return node;
		}
	}
	
	public boolean find(Comparable<String> data) {
		// call helper function at root
		return find(data, root);
	}
	
	private boolean find(Comparable<String> data, Node node) {
		if (node == null) {
			// Base Case 1
			// If current node is null, return false
			// This means up to the end of a "branch"
			// was searched without finding data
			return false;
		} else if (node.getData().compareTo((String)data)==0) {
			// Base Case 2
			// If current node contains data, then return true;
			return true;
		} else if (node.getData().compareTo((String)data)>0) {
			// Recursive Case 1
			// If current node data is greater than this data
			// then search to the left of the current node
			return find(data, node.getLeft());
		} else /*node.getData().compareTo((String)data)<0*/{
			// Recursive Case 2
			// If current node data is smaller than this data
			// then search to the right of the current node
			return find(data, node.getRight());
		}
	}
	
	public void delete(Comparable<String> data) {
		// call delete helper method at root
		// set root the possibly updated root
		root = delete(data, root);
	}
	
	private Node delete(Comparable<String> data, Node node) {
		if (node == null) {
			// Base Case 1
			// If current node is null, return null
			return null;
		} else if (node.getData().compareTo((String)data)==0) {
			// Base Case 2
			// If current node is node that contains data
			if (node.getLeft() == null) {
				// If there is no child to the left
				// then return the right
				return node.getRight();
			} else if (node.getRight() == null) {
				// If there is no child to the right
				// then return the left
				return node.getLeft();
			} else {
				// If there is children to the left AND right
				if (node.getRight().getLeft()==null) {
					// If the right child does not have a left child
					// then change the current value to the right value 
					// and replace the right node with it's right node
					node.setData(node.getRight().getData());
					node.setRight(node.getRight().getRight());
					// return current node
					return node;
				} else {
					// Otherwise, set the current Node data to the smallest value
					// and remove the node of the smallest value node
					node.setData(removeSmallest(node.getRight()));
					// return current node
					return node;
				}
			}
		} else if (data.compareTo((String) node.getData())<0) {
			// Recursive Call 1
			// If current node data is greater than this data
			// then recursively call delete on the left node
			delete(data,node.getLeft());
		} else /*data.compareTo((String) node.getData())>0*/ {
			// Recursive Call 2
			// If current node data is smaller than this data
			// then recursively call delete on the right node
			delete(data,node.getRight());
		}
		// I don't think this will ever run but eclipse gives a warning 
		// without it
		return node;
	}
	
	private Comparable<String> removeSmallest(Node node) {
		// Helper function for delete
		// We know node.getLeft() exists because removeSmallest is only
		// called when node.getLeft() is not null
		if (node.getLeft().getLeft() == null) {
			// Base Case
			// if the left of the left does not exist, then set the
			// left to right of left
			// This will remove the left leaf and inherit (at the left) 
			// the right node of the left leaf
			Comparable<String> smallest = node.getLeft().getData();
			node.setLeft(node.getLeft().getRight());
			// return the value of the node that was removed
			return smallest;
		} else {
			// Recursive Case
			// recursively call removeSmallest on the left node
			return removeSmallest(node.getLeft());
		}
	}
	
	public String toStringInOrder() {
		// build a space separated message in alphabetical order
		String message = toStringInOrder("",root);
		// remove extra space from toStringInOrder
		return message.substring(0,message.length()-1);
	}
	
	private String toStringInOrder(String message, Node node) {
		if (node != null) {
			// recursively call the left subtree
			message = toStringInOrder(message, node.getLeft());
			// add the node data to the string
			message += node.getData() + " ";
			// recursively call the right subtree
			message = toStringInOrder(message, node.getRight());
		}
		// when the node is null, return the message
		return message;
	}
	
	public String toStringPreOrder() {
		// build a space separated message in pre order
		String message = toStringPreOrder("",root);
		// remove extra space from toStringPreOrder
		return message.substring(0,message.length()-1);
	}
	
	private String toStringPreOrder(String message, Node node) {
		if (node != null) {
			// add the node data to the string
			message += node.getData() + " ";
			// recursively call the left subtree
			message = toStringPreOrder(message, node.getLeft());
			// recursively call the right subtree
			message = toStringPreOrder(message, node.getRight());
		}
		// when the node is null, return the message
		return message;
	}
	
}
