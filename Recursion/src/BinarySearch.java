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
	
    public static int searchRecursive(ArrayList<Integer> list, int target, int low, int high) {
        if (low > high) {
            return -1; // target is not in the array
        }

        int mid = low + (high - low) / 2;

        if (list.get(mid) == target) {
            return mid;
        } else if (list.get(mid) < target) {
            return searchRecursive(list, target, mid + 1, high);
        } else {
            return searchRecursive(list, target, low, mid - 1);
        }
    }	
	

	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0; i < 20; i++) {
			myList.add(random.nextInt(100));
		}
		Collections.sort(myList);
		
		int key = myList.get(10);
		System.out.println("Binary Search Iterative: " + search(myList, key));
		
		System.out.println("Binary Search Recursive: " + searchRecursive(myList, key, 0, myList.size() - 1));
		
		
	}

}
