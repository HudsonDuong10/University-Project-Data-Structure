
public class PerformanceTesting {
	
	// Insertion Performance Test
	// ==========================
	public static void insertionPerformance_AVL(int[] data) {
		AVLTree tree = new AVLTree();
		
		long start = System.nanoTime();		//Start timing
		
		for(int key : data) {				
			tree.insert(key);				//Insert each element into the tree
		}
		
		long end = System.nanoTime();		//Stop Timing
		double durationMs = (end - start) / 1_000_000.0;	//Convert to milliseconds
		
		System.out.println("AVL Tree - Insertion of " + data.length + " elements took " + durationMs + " ms");
	}
	public static void insertionPerformance_Splay(int[] data) {
		SplayTree tree = new SplayTree();
		
		long start = System.nanoTime();
		
		for(int key : data) {
			tree.insert(key);
		}
		
		long end = System.nanoTime();
		double durationMs = (end - start) / 1_000_000.0;
		
		System.out.println("Splay Tree - Insertion of " + data.length + " elements took " + durationMs + " ms");
	}
	public static void insertionPerformance_Chaining(int[] data) {
		HashTableChaining tree = new HashTableChaining();
		
		long start = System.nanoTime();
		
		for(int key : data) {
			tree.insert(key);
		}
		
		long end = System.nanoTime();
		double durationMs = (end - start) / 1_000_000.0;
		
		System.out.println("Hash Table(Chaining) - Insertion of " + data.length + " elements took " + durationMs + " ms");
	}
	public static void insertionPerformance_Probing(int[] data) {
		HashTableProbing tree = new HashTableProbing();
		
		long start = System.nanoTime();
		
		for(int key : data) {
			tree.insert(key);
		}
		
		long end = System.nanoTime();
		double durationMs = (end - start) / 1_000_000.0;
		
		System.out.println("Hash Table(Probing) - Insertion of " + data.length + " elements took " + durationMs + " ms");
	}
	
	// Search Performance Test
	// =======================
	public static void searchPerformance_AVL(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] searchData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		AVLTree avl = new AVLTree();
		for(int key : insertData) {
			avl.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : searchData) {
			avl.search(key);
		}
		
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("AVL Tree - Search of %d elements took %.4f ms%n", size, duration);
	}
	public static void searchPerformance_Splay(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] searchData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		SplayTree splay = new SplayTree();
		for(int key : insertData) {
			splay.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : searchData) {
			splay.search(key);
		}
		
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("Splay Tree - Search of %d elements took %.4f ms%n", size, duration);
	}
	public static void searchPerformance_Chaining(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] searchData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		HashTableChaining table = new HashTableChaining();
		for(int key : insertData) {
			table.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : searchData) {
			table.contains(key);
		}
		
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("Hash Table(Chaining) - Search of %d elements took %.4f ms%n", size, duration);
	}
	public static void searchPerformance_Probing(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] searchData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		HashTableProbing table = new HashTableProbing();
		for(int key : insertData) {
			table.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : searchData) {
			table.contains(key);
		}
		
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("Hash Table(Probing) - Search of %d elements took %.4f ms%n", size, duration);
	}
	
	// Delete Performance Test
	// =======================
	public static void deletePerformance_AVL(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] deleteData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		AVLTree avl = new AVLTree();
		for(int key : insertData) {
			avl.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : deleteData) {
			avl.delete(key);
		}
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("AVL Tree - Search of %d elements took %.4f ms%n", size, duration);
	}
	public static void deletePerformance_Splay(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] deleteData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		SplayTree splay = new SplayTree();
		for(int key : insertData) {
			splay.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : deleteData) {
			splay.delete(key);
		}
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("Splay Tree - Search of %d elements took %.4f ms%n", size, duration);
	}
	public static void deletePerformance_Chaining(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] deleteData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		HashTableChaining table = new HashTableChaining();
		for(int key : insertData) {
			table.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : deleteData) {
			table.delete(key);
		}
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("Hash Table(Chaining) - Search of %d elements took %.4f ms%n", size, duration);
	}
	public static void deletePerformance_Probing(int size) {
		int [] insertData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		int [] deleteData = RandomDataGenerator.generateRandomArray(size, 1_000_000);
		
		HashTableProbing table = new HashTableProbing();
		for(int key : insertData) {
			table.insert(key);
		}
		
		long start = System.nanoTime();
		for(int key : deleteData) {
			table.delete(key);
		}
		long end = System.nanoTime();
		
		double duration = (end - start) / 1_000_000.0;
		System.out.printf("Hash Table(Probing) - Search of %d elements took %.4f ms%n", size, duration);
	}
}
