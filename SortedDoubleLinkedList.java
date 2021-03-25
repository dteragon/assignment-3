import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<E> extends BasicDoubleLinkedList<E> {

	protected Comparator<E> comparison;
	
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparison - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<E> comparison) {
		this.comparison = comparison;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * Notice we can insert the same element several times. Your implementation must
	 * traverse the list only once in order to perform the insertion. Do not
	 * implement this method using iterators. Notice that you don't need to call any
	 * of the super class methods in order to implement this method.
	 * 
	 * @param data - the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<E> add(E data) {
		
		Node add = new Node(null, data, null);
		Node current = head;
		
		while (current != null && comparison.compare(current.data, data) < 0) {
			current = current.next;
		}
		
		if (current == null) {

			if (tail == null) {
				head = add;
				
			} else {
				tail.next = add;
				add.prev = tail;
			}
			tail = add;
			
		} else {
			
			if (current.prev != null)
				current.prev.next = add;
			else
				head = add;
			add.prev = current.prev;
			
			current.prev = add;
			add.next = current;
		}
		
		size++;
		return this;
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws UnsupportedOperationException - if method is called
	 */
	@Override
	public BasicDoubleLinkedList<E> addToEnd(E data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws UnsupportedOperationException - if method is called
	 */
	@Override
	public BasicDoubleLinkedList<E> addToFront(E data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * 
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public ListIterator<E> iterator() {
		return super.iterator();
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * 
	 * @param data       - the data element to be removed
	 * @param comparison - the comparator to determine equality of data elements
	 * @return data element or null
	 */
	@Override
	public SortedDoubleLinkedList<E> remove(E target, Comparator<E> comparison) {
		return (SortedDoubleLinkedList<E>) super.remove(target, this.comparison);
	}
}
