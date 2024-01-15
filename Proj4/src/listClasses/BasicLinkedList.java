package listClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {
	protected class Node {
		protected T data;
		protected Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	protected Node head;
	protected Node tail;
	protected int size;

	public BasicLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public BasicLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			// If the list is empty set head and tail to the new node
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
			// Otherwise, add the new node to the end of the list
		}

		size++;
		return this;
	}

	public BasicLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			// If the list is empty set head and tail to the new node
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
			// Otherwise, add the new node to the front of the list
		}

		size++;
		return this;
	}

	public T getFirst() {
		if (isEmpty()) {
			return null;
		}

		return head.data;
	}

	public T getLast() {
		if (isEmpty()) {
			return null;
		}

		return tail.data;
	}

	public T retrieveFirstElement() {
		if (isEmpty()) {
			return null;
		}

		T data = head.data; // Store the data of the first node
		head = head.next; // Update the head reference to the next node
		size--;

		if (isEmpty()) {
			tail = null;
		}

		return data;
	}

	public T retrieveLastElement() {
		if (isEmpty()) {
			return null;
		}

		T data = tail.data;
		// If there is only one node, update head and tail to null
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node currentNode = head;
			while (currentNode.next != tail) {
				currentNode = currentNode.next;
				// Traverse the list to find the node before the last node
			}
			currentNode.next = null;
			// Update the next reference of the second-to-last node to null
			tail = currentNode;
		}

		size--;
		return data;
	}

	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node currentNode = head;
		Node previousNode = null;

		while (currentNode != null) {
			if (comparator.compare(currentNode.data, targetData) == 0) {
				if (currentNode == head) {
					head = currentNode.next;
					// If the target node is the head, update the head reference
				} else {
					previousNode.next = currentNode.next;
					// Otherwise update the next reference of the previous node
				}

				if (currentNode == tail) {
					tail = previousNode;
					// If the target node is the tail, update the tail reference
				}
				size--;
			} else {
				previousNode = currentNode;
				// Update the previous node reference
			}

			currentNode = currentNode.next;
		}

		return this;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node currentNode = head; // Start from head of the list

			@Override
			public boolean hasNext() {
				return currentNode != null; // Check if there is a next node
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new UnsupportedOperationException();
					// throw an exception if there's no next node
				}

				T data = currentNode.data; // Store the data of the current node
				currentNode = currentNode.next; // Move to the next node
				return data;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> reverseList = new ArrayList<>();
		// new ArrayList for the reversed elements
		appendReverseList(reverseList, head);
		// append elements in reverse order
		return reverseList;
	}

	private void appendReverseList(ArrayList<T> reverseList, Node currentNode) {
		if (currentNode == null) {
			return;
		}

		appendReverseList(reverseList, currentNode.next);
		reverseList.add(currentNode.data);
	}

	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> reverseList = new BasicLinkedList<>();
		appendReverseList(reverseList, head);
		return reverseList;
	}

	private void appendReverseList(BasicLinkedList<T> reverseList,
			Node currentNode) {
		if (currentNode == null) {
			return;
		}

		appendReverseList(reverseList, currentNode.next);
		reverseList.addToEnd(currentNode.data);
	}

	public boolean isEmpty() {
		return size == 0;// checks if list is empty
	}
}
