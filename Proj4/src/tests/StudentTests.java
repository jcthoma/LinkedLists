package tests;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class StudentTests {

	@Test
	public void testAddToEnd() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3);

		assertEquals(3, linkedList.getSize());
		assertEquals(Integer.valueOf(1), linkedList.getFirst());
		assertEquals(Integer.valueOf(3), linkedList.getLast());
	}

	@Test
	public void testAddToFront() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToFront(1).addToFront(2).addToFront(3);

		assertEquals(3, linkedList.getSize());
		assertEquals(Integer.valueOf(3), linkedList.getFirst());
		assertEquals(Integer.valueOf(1), linkedList.getLast());
	}

	@Test
	public void testRetrieveFirstElement() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3);

		Integer firstElement = linkedList.retrieveFirstElement();

		assertEquals(2, linkedList.getSize());
		assertEquals(Integer.valueOf(1), firstElement);
		assertEquals(Integer.valueOf(2), linkedList.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3);

		Integer lastElement = linkedList.retrieveLastElement();

		assertEquals(2, linkedList.getSize());
		assertEquals(Integer.valueOf(3), lastElement);
		assertEquals(Integer.valueOf(2), linkedList.getLast());
	}

	@Test
	public void testRemoveWithComparator() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3).addToEnd(2);
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(a, b);
			}
		};

		linkedList.remove(2, comparator);
		assertEquals(2, linkedList.getSize());
		assertEquals(Integer.valueOf(1), linkedList.getFirst());
		assertEquals(Integer.valueOf(3), linkedList.getLast());
	}

	@Test
	public void testIterator() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3);

		Iterator<Integer> iterator = linkedList.iterator();
		List<Integer> elements = new ArrayList<>();

		while (iterator.hasNext()) {
			elements.add(iterator.next());
		}

		assertEquals(3, elements.size());
		assertEquals(Integer.valueOf(1), elements.get(0));
		assertEquals(Integer.valueOf(2), elements.get(1));
		assertEquals(Integer.valueOf(3), elements.get(2));
	}

	@Test
	public void testGetReverseArrayList() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3);

		ArrayList<Integer> reverseList = linkedList.getReverseArrayList();

		assertEquals(3, reverseList.size());
		assertEquals(Integer.valueOf(3), reverseList.get(0));
		assertEquals(Integer.valueOf(2), reverseList.get(1));
		assertEquals(Integer.valueOf(1), reverseList.get(2));
	}

	@Test
	public void testGetReverseList() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		linkedList.addToEnd(1).addToEnd(2).addToEnd(3);

		BasicLinkedList<Integer> reverseList = linkedList.getReverseList();

		assertEquals(3, reverseList.getSize());
		assertEquals(Integer.valueOf(3), reverseList.getFirst());
		assertEquals(Integer.valueOf(1), reverseList.getLast());
	}

	@Test
	public void testIsEmpty() {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList<>();
		assertTrue(linkedList.isEmpty());

		linkedList.addToEnd(1);
		assertFalse(linkedList.isEmpty());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSortedAddToEnd() {
		SortedLinkedList<Integer> sortedList = new SortedLinkedList<>();
		sortedList.addToEnd(1);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSortedAddToFront() {
		SortedLinkedList<Integer> sortedList = new SortedLinkedList<>();
		sortedList.addToFront(1);
	}
}
