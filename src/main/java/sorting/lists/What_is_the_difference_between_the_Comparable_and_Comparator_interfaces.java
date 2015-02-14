/**
 * 
 */
package sorting.lists;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * @author DTT-777
 * 
 */
public class What_is_the_difference_between_the_Comparable_and_Comparator_interfaces {
	
	/**
	 * What is the difference between the Comparable and Comparator interfaces ?
	 * */
	
	/**
	 * For the implementation without a Comparator object, the type is sorted by its natural ordering.
	 * Sorting the array from low to high.
	 * User Comparable Interface
	 * */
	@Test
	public void sortInts() {
		final int[] numbers = { -3, -5, 1, 7, 4, -2 };
		final int[] expected = { -5, -3, -2, 1, 4, 7 };
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	/**
	 * Listing 4-2: Sorting objects naturally
	 * For an array of Objects, the type being sorted must implement the Comparable interface
	 * */
	@Test
	public void sortObjects() {
		final String[] strings = { "z", "x", "y", "abc", "zzz", "zazzy" };
		final String[] expected = { "abc", "x", "y", "z", "zazzy", "zzz" };
		Arrays.sort(strings);
		assertArrayEquals(expected, strings);
	}
	
	/**
	 * The String class implements the Comparable interface, so the sorting works as you would expect (kỳ vọng).
	 * If the type being sorted does not implement Comparable, this will throw a ClassCastException.
	 * string thì ko có lớp nguyên thủy,
	 * sortObjects tự động implement Comparable interface
	 * */
	
	/**
	 * Listing 4-3: Sorting without a Comparable interface
	 * */
	private static class NotComparable {
		private NotComparable(final int i) {
		}
	}
	
	@Test
	public void sortNotComparable() {
		final List<NotComparable> objects = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			objects.add(new NotComparable(i));
		}
		try {
			Arrays.sort(objects.toArray());
		} catch (Exception e) {
			// correct behavior – cannot sort
			//chỗ này nó xảy ra ngoại lệ nếu dùng lệnh ́82:
			//java.lang.ClassCastException: vn.com.minhnd.core.algorithms.SortingLists$NotComparable cannot be cast to java.lang.Comparable
			//at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:290)
			return;
			//e.printStackTrace();
		}
		fail();
	}
	
	/**
	* It is not possible (không thể) to use the Collections.sort method
	* because the compiler expects the type of the parameter to be an implementation of Comparable.
	* The method signature is: public static <T extends Comparable<? super T>> void sort(List<T> list)
	* If you want to provide your own ordering, you provide an implementation of the Comparator interface to the sort method.
	* This interface has two methods: int compare(T o1, T o2) for the implementing type T, and boolean equals(Object o).
	* 
	* The compare method returns an int in one of three states:
	*   - negative if the first argument is sorted before the second,
	*   - zero if the two are equal
	*   - positive if the second argument is sorted first.
	* 
	* sắp xếp theo tăng dần, giảm dần, custom bằng cách implement Comparator<T>
	* */
	
	/**
	 * Listing 4-4: A reverse numerical order Comparator, If you were to provide a reverse numerical order Comparator,
	 * the implementation may look like
	 * */
	public class ReverseNumericalOrder implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
		// equals omitted
	}
	
	/**
	 * Listing 4-5: Using a custom ordering, uses this Comparator
	 * */
	@Test
	public void customSorting() {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);
		
		Collections.sort(numbers, new ReverseNumericalOrder());
		assertEquals(expected, numbers);
	}
	
	/**
	 * Comparable interface được sử dụng sort các số tự nhiên.
	 * Comparator interface dùng cho điều khiển chính xác over orderring. 
	 * */
}
