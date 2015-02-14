package sorting.lists;

public class How_would_you_implement_a_bubble_sort_algorithm {
	
	/**
	 * Listing 4-6: A bubble sort implementation
	 * */
	public void bubbleSort(int[] numbers) {
		boolean numbersSwitched;
		do {
			numbersSwitched = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i + 1] < numbers[i]) {
					int tmp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = tmp;
					numbersSwitched = true;
				}
			}
		} while (numbersSwitched);
	}
}
