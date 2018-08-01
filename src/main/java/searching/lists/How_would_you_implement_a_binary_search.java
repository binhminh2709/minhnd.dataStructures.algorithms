package searching.lists;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class How_would_you_implement_a_binary_search {
	
	public static boolean binarySearch(final List<Integer> numbers, final Integer value) {
		if (numbers == null || numbers.isEmpty()) {
			return false;
		}
		final Integer comparison = numbers.get(numbers.size() / 2);
		if (value.equals(comparison)) {
			return true;
		}
		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size() / 2), value);
		} else {
			return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
		}
	}
	
	@Test
	public void testBinarySearch() {
		List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		Integer value = 9;
		Assert.assertTrue(binarySearch(numbers, value));
	}
}
