
public class AVLTree {
	
	private class Node {
		int key, height;
		Node left, right;
		
		Node (int key) {
			this.key = key;
			this.height = 1;	//New nodes start @ height 1
			this.left = null;
			this.right = null;
		}
		
	}
	
	private Node root;
	
	public void insert(int key) {
		root = insert(root, key);
	}
	public void delete(int key) {
		root = delete(root, key);
	}
	public boolean search(int key) {
		return search(root, key);
	}
	
	private Node insert(Node node, int key) {
		if (node == null) {			//BST insertion
			return new Node(key);
		}
		
		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		} else
			return node;
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));	//updates the height of this ancestor node
		
		//Gets the balance factor to check for imbalance
		int balance = getBalance(node);
		
		if(balance > 1 && key < node.left.key) {	//left-left case
			return rightRotate(node);
		}
		if(balance > 1 && key > node.left.key) {	//left-right case
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < -1 && key > node.right.key) {	//right-right case
			return leftRotate(node);
		}		
		if(balance < -1 && key < node.right.key) {	//right-left case
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}	
		return node;
	}
	
	private Node delete(Node node, int key) {
	    if (node == null)
	        return null;

	    // Traverse the tree to find the node to delete
	    if (key < node.key) {
	        node.left = delete(node.left, key);
	    } else if (key > node.key) {
	        node.right = delete(node.right, key);
	    } else {
	        // Node to delete found

	        // Case 1: No children
	        if (node.left == null && node.right == null) {
	            return null;
	        }

	        // Case 2: One child
	        else if (node.left == null) {
	            return node.right;
	        } else if (node.right == null) {
	            return node.left;
	        }

	        // Case 3: Two children
	        else {
	            Node successor = getMinValue(node.right);  
	            node.key = successor.key;		//Copy Value from successor
	            node.right = delete(node.right, successor.key);		//Delete Successor
	        }
	    }

	    // Update height
	    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

	    // Re-balance
	    int balance = getBalance(node);

	    if (balance > 1 && getBalance(node.left) >= 0)		//Left-Left Case
	        return rightRotate(node);

	    if (balance > 1 && getBalance(node.left) < 0) {		//Left-Right Case
	        node.left = leftRotate(node.left);
	        return rightRotate(node);
	    }

	    if (balance < -1 && getBalance(node.right) <= 0)	//Right-Right Case
	        return leftRotate(node);

	    if (balance < -1 && getBalance(node.right) > 0) {	//Right-Left Case
	        node.right = rightRotate(node.right);
	        return leftRotate(node);
	    }

	    return node;
	}
	
	private boolean search(Node node, int key) {
		if (node == null) {
			return false;
		}
		if (key == node.key) {
			return true;
		}
		if (key < node.key) {
			return search(node.left, key);
		}
		return search(node.right, key);
	}
	
	private int getBalance(Node node) {
		return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);	//Returns 0 if node = null otherwise returns height of left node - height of right node
	}	
	private int getHeight(Node node) {
		return (node == null) ? 0 : node.height;	//Returns 0 if node = null otherwise returns height of that node
	}	
	
	private Node rightRotate(Node y) {
		if(y == null || y.left == null) return y;
		
		Node x = y.left;
		Node T2 = x.right;
		
		//Performs the rotation
		y.left = T2;
		x.right = y;
		
		
		//Updates the Height
		y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
		x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
		
		return x;	//New Root After Rotation
	}
	private Node leftRotate(Node x) {
		if(x == null || x.right == null) return x;
		
		Node y = x.right;
		Node T2 = y.left;
		
		//Performs the rotation
		x.right = T2;
		y.left = x;
		
		
		//Updates the Height
		x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
		y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
		
		return y;	//New Root After Rotation
	}	
	
	private Node getMinValue(Node node) {	//finds and returns the smallest value in the subtree
		if(node == null) return null;
		
		Node current = node;
		
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
}	

	































