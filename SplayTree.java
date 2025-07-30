
public class SplayTree {
	
	 private class Node {
		 int key;
		 Node left, right;
		 
		 Node(int key) {
			 this.key = key;
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
		 root = splay(root, key);
		 return root != null && root.key == key;
	 }
	 
	 private Node splay (Node root, int key) {
		 //Base Case: if the root is empty or the key is already at the root
		 if (root == null || root.key == key)
		        return root;

		 //Case 1: Key is in the Left subtree
		 if (key < root.key) {
			 if (root.left == null) return root;

			 // Zig-Zig (Left Left)
		     if (key < root.left.key) {
		    	 root.left.left = splay(root.left.left, key);	//splay the key in the left-left subtree	
		    	 root = rightRotate(root);						//Rotate right to bring key closer to the root
		     }
		     // Zig-Zag (Left Right)
		     else if (key > root.left.key) {
		         root.left.right = splay(root.left.right, key);	//splay the key in left-right subtree
		         if (root.left.right != null)					//if key is found rotate left at left child
		        	 root.left = leftRotate(root.left);
		     }
		     return (root.left == null) ? root : rightRotate(root);	//Rotate right if left child exist otherwise return root
		 }
		 
		 // Case 2: Key is in the Right Subtree
		 else {
		     if (root.right == null) return root;

		     // Zig-Zig (Right Right)
		     if (key > root.right.key) {						
		    	 root.right.right = splay(root.right.right, key);	//splay the key in right-right subtree
		         root = leftRotate(root);							//rotate left at root
		     }
		     // Zig-Zag (Right Left)
		     else if (key < root.right.key) {
		         root.right.left = splay(root.right.left, key);		//splay the key in right-left subtree
		         if (root.right.left != null)						//if key is found rotate right at right child
		        	 root.right = rightRotate(root.right);			
		     }
		     return (root.right == null) ? root : leftRotate(root);	//Rotate left if right child exists, otherwise return root
		 }
	 }
	 private Node rightRotate(Node y) {
		 if (y == null || y.left == null) return y;
		 Node x = y.left;
		 y.left = x.right;
		 x.right = y;
		 return x;
	 }
	 private Node leftRotate(Node x) {
		 if (x == null || x.right == null) return x;
		 Node y = x.right;
		 x.right = y.left;
		 y.left = x;
		 return y;
	 }
	 
	 private Node insert(Node root, int key) {
		 if(root == null) {		//if tree is empty create a new node
			 return new Node(key);
		 }
		 
		 root = splay(root, key);
		 
		 if(root.key == key) {	//if key already exists return root
			 return root;
		 }
		 
		 Node newNode = new Node(key);
		 
		 if(key < root.key) {		//Inserts the node to the left or right depending on key
			 newNode.right = root;
			 newNode.left = root.left;
			 root.left = null;
		 } else {
			 newNode.left = root;
			 newNode.right = root.right;
			 root.right = null;
		 }
		 return newNode;
	 }

	 private Node delete(Node root, int key) {
		 if (root == null) {
			 return null;
		 }
		 
		 root = splay(root, key); 	//brings the node to delete to the root
		 
		 if (root.key != key) {		//if the key isn't present return root as is
			 return root;
		 }
		 
		 if(root.left == null) {	
			 return root.right;		//no left child return to right subtree
		 } else {
			 int maxKey = findMax(root.left);
			 Node newRoot = splay(root.left, maxKey);	//splay by key ensures largest node comes to root 			 
			 newRoot.right = root.right;			//Attach the right subtree to the new Root
			 return newRoot;
		 }
		 
		 
	 }
	 private int findMax(Node node) {
		 while (node.right != null) {
			 node = node.right;
		 }
		 return node.key;
	 }

}
