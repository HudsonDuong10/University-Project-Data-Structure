
public class HashTableChaining {
	
	private static class Node {
		int key;
		Node next;
		
		Node(int key){
			this.key = key;
			this.next = null;
		}
	}
	
	private static final int DEFAULT_CAPACITY = 131071; 	//10007, 131071
	
	private Node[] table;
	
	public HashTableChaining() {
		table = new Node[DEFAULT_CAPACITY];
	}
	
	public void insert(int key) {
		int index = Math.abs(key) % table.length;
		
		//Checks for duplicates
		Node current = table[index];		
		while(current != null) {
			if(current.key == key) {	//key is already present do nothing
				return;
			}
			current = current.next;
		}
		
		Node newNode = new Node(key);	//inserts the new node at the head of the list
		newNode.next = table[index];
		table[index] = newNode;		
	}
	
	public boolean contains(int key) {
		int index = Math.abs(key) % table.length;
		
		Node current = table[index];
		while(current != null) {
			if(current.key == key) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public void delete(int key) {
		int index = Math.abs(key) % table.length;
		
		Node current = table[index];
		Node prev = null;
		
		while(current != null) {
			if(current.key == key) {
				if(prev == null) {		//key is at the head
					table[index] = current.next;
				} else {				//key is in the middle or end
					prev.next = current.next;
				}
				return;		//key found and deleted, exit
			}
			prev = current;
			current = current.next;
		}
		
	}
	
	
}
