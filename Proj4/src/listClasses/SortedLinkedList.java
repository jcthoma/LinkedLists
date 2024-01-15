package listClasses;

import java.util.Comparator;

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;

	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	public SortedLinkedList() {
		this(null);
	}

	public SortedLinkedList<T> add(T element) {
		Node newNode = new Node(element);

		// insert the element as the first node if list is empty
		if (isEmpty()) {
			head = newNode;
		} else {
			Node current = head;
			Node previous = null;

			// Find correct position to insert element
			while (current != null
					&& comparator.compare(element, current.data) >= 0) {
				previous = current;
				current = current.next;
			}

			// Insert element at correct position
			if (previous == null) {
				newNode.next = head;
				head = newNode;
			} else {
				previous.next = newNode;
				newNode.next = current;
			}
		}

		size++;
		return this;
	}

	public SortedLinkedList<T> remove(T targetData) {
		Node current = head;
		Node previous = null;

		while (current != null) {
			// If the current node's data matches the target data
			if (comparator.compare(targetData, current.data) == 0) {
				if (previous == null) {
					head = current.next;// Update head to skip the current node
				} else {
					// Update the previous node's next pointer to skip the
					// current node
					previous.next = current.next;
				}
				size--;
				break;
			}

			previous = current;
			current = current.next;
		}

		return this;
	}

	@Override
	public SortedLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException(
				"Invalid operation for sorted list.");
	}

	@Override
	public SortedLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException(
				"Invalid operation for sorted list.");
	}
}
