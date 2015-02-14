package sorting.lists;

import java.util.ArrayList;
import java.util.List;

public class How_would_you_implement_the_quicksort_algorithm {
	/**
	 * This algorithm is recursive. The base case is when a list is provided with zero or one element. You 
	can simply return that list because it is already sorted.
	The second part of the algorithm is to pick an arbitrary element from the list, called the pivot. In 
	this case the first element in the list was used, but any element could have been picked. The remaining elements are separated into two: those lower than the pivot, and those equal to or larger than 
	the pivot.
	The method is then called on each of the two smaller lists, which will return in each segment being 
	sorted. The final list is the smaller elements, now sorted, followed by the pivot, and then the higher 
	sorted elements.
	* */
	public static List<Integer> quicksort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}
		final Integer pivot = numbers.get(0);
		final List<Integer> lower = new ArrayList<>();
		final List<Integer> higher = new ArrayList<>();
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}
		final List<Integer> sorted = quicksort(lower);
		sorted.add(pivot);
		sorted.addAll(quicksort(higher));
		return sorted;
	}
}
