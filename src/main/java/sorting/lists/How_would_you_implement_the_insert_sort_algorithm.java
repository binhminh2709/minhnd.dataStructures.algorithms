package sorting.lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class How_would_you_implement_the_insert_sort_algorithm {
	/**
	 * listing 4-7: An insert sort implementation
	 * */
	public static List<Integer> insertSort(final List<Integer> numbers) {
		final List<Integer> sortedList = new LinkedList<>();
		originalList: for (Integer number : numbers) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}
	
	@Test
	public void testInsertSort() {
		List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		numbers = insertSort(numbers);
		for (Integer in : numbers) {
			System.out.println(in);
		}
	}
	
	/**
	* Also, the list implementation returned is a LinkedList instance.
	* A linked list is very efficient (/i'fiʃənt/ tính từ - có hiệu lực) in  adding elements in the middle of the list,
	* simply by rearranging the pointers of the nodes in the list.
	* If an ArrayList had been used, adding elements to the middle would be expensive.
	* An ArrayList is backed by an array
	* so inserting at the front or middle of the list means that all subsequent (đến sau, theo sau, xảy ra sau)
	* elements must be shifted along by one to a new slot in the array.
	* This can be very expensive if you have a list with several million rows,
	* especially if you are inserting early in the list. If the difference between list data structures,
	* such as array lists and linked lists, are new to you,
	* look at Chapter 5 on data structures and their implementations.
	* 
	* LinkedList danh sách liên kết, ArrayList danh sách mảng.
	* dùng ArrayList, khi insert vào giữa hoặc phía trước của list, all phần tử theo sau phải chuyển về một khe cắm in một mảng
	* xem chapter 5 cấu trúc dữ liệu
	* 
	* ý ở đây là add(index, object) dùng LinkedList tốt hơn là dùng ArrayList
	* còn add(object) nó add vào vị trí sau cùng hai cái nào cũng đc
	* 
	* */
}
