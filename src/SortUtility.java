import java.util.ArrayList;

/**
 * Utility Class. Used to sort comparable objects
 * @author Juan Lopez
 *
 */
public class SortUtility {
	
	/**
	 * Sorts the specified object using the selection sort algorithm
	 */
	public static void selectionSort(ArrayList<Comparable> packages) {
		int min;
		Comparable temp;
		
		for (int index = 0; index < packages.size() - 1; index++) {
			min = index;
			for (int scan = index+1; scan < packages.size(); scan++) {
				if ((packages.get(scan)).compareTo(packages.get(min)) < 0) {
					min = scan;
				}

	         temp = packages.get(min);
	         packages.set(min, packages.get(index));
	         packages.set(index, temp);
			}
		}
	}
	
	/**
	 * Sorts the specified object using the insertion sort algorithm
	 */
	public static void insertionSort(ArrayList<Comparable> packages) {
		
		for (int index = 1; index < packages.size(); index++) {
			Comparable key = packages.get(index);
	         int position = index;
	         
	         while (position > 0 && (key.compareTo(packages.get(position-1)) < 0)) {
	        	 packages.set(position, packages.get(position-1));
	        	 position--;
	         }
	         packages.set(position, key);
		}
	}
}
