
public class Node {
	
	// Originally planned to use Comparable without 
	// a type but decided to use String type 
	// Professor Brizan also said I could use String 
	// instead of Comparable<String> if I wanted but 
	// I decided to leave it.
	private Comparable<String> data;
	private Node left;
	private Node right;
	
	public Node() {
		// new node with no values
		setData(null);
		setLeft(null);
		setRight(null);
	}
	
	public Node(Comparable<String> data) {
		// new node with data
		this.setData(data);
	}
	
	public Node(Comparable<String> data, Node left, Node right) {
		// new node with data, left, and right
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
	}

	// accessors and mutators
	public Comparable<String> getData() {
		return data;
	}

	public void setData(Comparable<String> data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}
