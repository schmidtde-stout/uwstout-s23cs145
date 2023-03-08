import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

	// return the index where value is located in list
	public static int search(ArrayList<Integer> list, int value) {
		int low = 0;
		int high = list.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid).intValue() < value) {
				low = mid + 1;
			} else if (list.get(mid) > value) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1; // value is not found in list
	}

	// using the selection sort algorithm, efficiency O(n^2)
	public static void selectionSort(ArrayList<Integer> list) {
		
		for (int i = 0; i < list.size() - 1; ++i) {

			int minimum = list.get(i);
			int minimumAt = i;
			for (int j = i + 1; j  < list.size(); j++) {
				if (list.get(j) < minimum) {
					minimumAt = j;
					minimum = list.get(j);
				}
			}
			if (minimumAt != i) {
				int temp = list.get(i);
				list.set(i, minimum);
				list.set(minimumAt, temp);
			}
		}
	}	
	
	// using the insertion sort algorithm, efficiency O(n^2)
	public static void insertionSort(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); ++i) {
			// Insert list[i] into sorted part,
			// stopping once list[i] is in correct position
			for (int j = i; j > 0; j--) {
				if (list.get(j) < list.get(j - 1)) {
					int temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			myList.add(random.nextInt(100));
		}

		selectionSort(myList);
		Collections.shuffle(myList);
		insertionSort(myList);

	}

}
