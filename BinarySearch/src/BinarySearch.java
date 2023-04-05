import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BinarySearch {
	
	// return the index where value is located in list
	public static int search(ArrayList<Integer> list, int value) {
		int low = 0;
		int high = list.size() - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid).intValue() < value) {
				low = mid + 1;
			}
			else if (list.get(mid) > value) {
				high = mid - 1;
			}
			else {
				return mid;
			}
		}
		return -1; // value is not found in list
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0; i < 20; i++) {
			myList.add(random.nextInt(100));
		}
		Collections.sort(myList);
		
		int key = -345;
		System.out.println(search(myList, key));
		
		
	}

}
