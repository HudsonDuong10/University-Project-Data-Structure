
public class Main {

	public static void main(String[] args) {
		int size = 100_000; // You can try 10_000 or 100_000 too
        int maxValue = 1_000_000;

        // Generate the same random input for all structures
        int[] testData = RandomDataGenerator.generateRandomArray(size, maxValue);

        System.out.println("=== Insertion Performance Test (" + size + " elements) ===");
        PerformanceTesting.insertionPerformance_AVL(testData);
        PerformanceTesting.insertionPerformance_Splay(testData);
        PerformanceTesting.insertionPerformance_Chaining(testData);
        PerformanceTesting.insertionPerformance_Probing(testData);

        System.out.println("\n=== Search Performance Test (" + size + " elements) ===");
        PerformanceTesting.searchPerformance_AVL(size);
        PerformanceTesting.searchPerformance_Splay(size);
        PerformanceTesting.searchPerformance_Chaining(size);
        PerformanceTesting.searchPerformance_Probing(size);
        
        System.out.println("\n=== Delete Performance Test (" + size + " elements) ===");
        PerformanceTesting.deletePerformance_AVL(size);
        PerformanceTesting.deletePerformance_Splay(size);
        PerformanceTesting.deletePerformance_Chaining(size);
        PerformanceTesting.deletePerformance_Probing(size);
	}

}
