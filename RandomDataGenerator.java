
import java.util.Random;

public class RandomDataGenerator {
	
	public static int[] generateRandomArray(int size, int maxValue) {	
		int [] data = new int[size];	
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			data[i] = rand.nextInt(maxValue);
		}
		return data;
	}
	
}
