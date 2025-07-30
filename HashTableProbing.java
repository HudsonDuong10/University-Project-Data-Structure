
public class HashTableProbing {
	
	private static final int DEFAULT_CAPACITY = 131071;	//10007, 131071
	private static final int EMPTY = -1;	//represents an empty slot
	private static final int DELETED = -2;	//represents a deleted slot
	
	private int[] table;
	
	public HashTableProbing() {
		table = new int[DEFAULT_CAPACITY];		//Sets up the table with default size
		
		for(int i = 0; i < table.length; i++) {		//marks every slot as EMPTY at the start
			table[i]= EMPTY;
		}
	}
	
	public void insert(int key) {
		int tableSize = table.length;
		
		int index = key % tableSize;
		
		int i = 0;
		
		while(i < tableSize) {
			int probeIndex = (index + i * i) % tableSize;
			
			if(table[probeIndex] == EMPTY || table[probeIndex] == DELETED) {	//if an empty or deleted slot is found we can insert a key there
				table[probeIndex] = key;
				return;
			}
			if(table[probeIndex] == key) {		//if key already exists, don't insert again
				return;
			}
			i++;
				
		}
		System.out.println("Hash table is full. Could not insert key: " + key);
	}
	
	public boolean contains(int key) {
		
		int tableSize = table.length;
		int index = key % tableSize;
		
		int i = 0;		//Number of Attempts
		
		while(i < tableSize) {
			int probeSize = (index + i * i) % tableSize;
			
			if(table[probeSize] == EMPTY) {		//if slot is empty, the key was never inserted
				return false;
			}	
			if(table[probeSize] == key) {		//if key is found return true
				return true;
			}
			i++;		//key not found yet, try next probe
		}
		return false;		//Return false if key wasn't found in the table
	}
	
	public void delete(int key) {
		
		int tableSize = table.length;
		int index = key % tableSize;
		
		int i = 0;
		
		while(i < tableSize) {
			int probeIndex = (index + i * i) % tableSize;
			
			if (table[probeIndex] == EMPTY) {	//if slot is empty, key doesn't exist
	            return;
	        }

	        if (table[probeIndex] == key) {		// If we find the key, mark it as DELETED
	            table[probeIndex] = DELETED;
	            return;
	        }

	        i++; 	// Otherwise, keep probing
		}
	}
	
	
}
