import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<E> implements Iterable<E> {

	protected Node head;
	protected Node tail;
	protected int size;
	
	/**
	 * Notice you must not traverse the list to compute the size. This method just
	 * returns the value of the instance variable you use to keep track of size.
	 * 
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to the end of the list. Do not use iterators to implement
	 * this method.
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<E> addToEnd(E data) {
		
		Node add = new Node(tail, data, null);
		
		if (tail != null)
			tail.next = add;
		else
			head = add;
		tail = add;
		size++;
		
		return this;
	}
	
	/**
	 * Adds element to the front of the list. Do not use iterators to implement this
	 * method.
	 * 
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<E> addToFront(E data) {

		Node add = new Node(null, data, head);

		if (head != null)
			head.prev = add;
		else
			tail = add;
		head = add;
		size++;

		return this;
	}
	
	/**
	 * Returns but does not remove the first element from the list. If there are no
	 * elements the method returns null. Do not implement this method using
	 * iterators.
	 * 
	 * @return the data element or null
	 */
	public E getFirst() {
		
		if (head == null)
			return null;
		return head.data;
	}

	/**
	 * Returns but does not remove the last element from the list. If there are no
	 * elements the method returns null. Do not implement this method using
	 * iterators.
	 * 
	 * @return the data element or null
	 */
	public E getLast() {
		
		if (tail == null)
			return null;
		return tail.data;
	}
	
	/**
	 * This method must be implemented using an inner class that implements
	 * ListIterator and defines the methods of hasNext(), next(), hasPrevious() and
	 * previous(). Remember that we should be able to call the hasNext() method as
	 * many times as we want without changing what is considered the next element.
	 * 
	 * @throws NoSuchElementException        - Your next() method should throw
	 *                                       NoSuchElementException if there are no
	 *                                       more elements (at the end of the list
	 *                                       and calling next() or at the beginning
	 *                                       of the list and calling previous()).
	 * @throws UnsupportedOperationException - You don't need to implement the
	 *                                       ListIterator's remove(), add(),
	 *                                       nextIndex() and previousIndex() and
	 *                                       set() methods, throw
	 *                                       UnsupportedOperationException if
	 *                                       called.
	 */
	public ListIterator<E> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new ListIterator<E>() {
			
			Node last = null;
			Node current = head;
			
			public boolean hasNext() {
				return current != null;	
			}

			public E next() {
				
				if (hasNext()) {
					
					last = current;
					current = current.next;
					return last.data;
				}
				throw new NoSuchElementException();
			}

			public boolean hasPrevious() {
				return last != null;
			}

			public E previous() {

				if (hasPrevious()) {

					current = last;
					last = last.prev;
					return current.data;
				}
				throw new NoSuchElementException();
			}

			public int nextIndex() {
				throw new UnsupportedOperationException();
			}

			public int previousIndex() {
				throw new UnsupportedOperationException();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public void set(E element) {
				throw new UnsupportedOperationException();
			}

			public void add(E element) {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	/**
	 * Removes the first instance of the targetData from the list. Notice that you
	 * must remove the elements by performing a single traversal over the list. You
	 * may not use any of the other retrieval methods associated with the class in
	 * order to complete the removal process. You must use the provided comparator
	 * (do not use equals) to find those elements that match the target. Do not
	 * implement this method using iterators.
	 * 
	 * @param target     - the data element to be removed
	 * @param comparison - the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<E> remove(E target, Comparator<E> comparison) {
		
		if (head == null)
			return null;
		Node current = head;
		
		do {
			
			if (comparison.compare(current.data, target) == 0) {
				
				if (current != tail)
					current.next.prev = current.prev;
				else
					tail = current.prev;
				
				if (current != head)
					current.prev.next = current.next;
				else
					head = current.next;
				
				current.prev = null;
				current.next = null;
				current = null;
				size--;
				
			}
			
			if (current != null)
				current = current.next;
			
		} while (current != null);
		
		return this;
	}
	
	/**
	 * Removes and returns the first element from the list. If there are no elements
	 * the method returns null. Do not implement this method using iterators.
	 * 
	 * @return data element or null
	 */
	public E retrieveFirstElement() {
		
		if (head == null)
			return null;
		
		E val = head.data;
		Node nextNode = head.next;
		
		head.next = null;
		head = nextNode;
		head.prev = null;
		
		return val;
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements
	 * the method returns null. Do not implement implement this method using
	 * iterators.
	 * 
	 * @return data element or null
	 */
	public E retrieveLastElement() {
		
		if (tail == null)
			return null;
		
		E val = tail.data;
		Node prevNode = tail.prev;
		
		tail.prev = null;
		tail = prevNode;
		tail.next = null;
		
		return val;
	}
	
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of
	 * list
	 * 
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<E> toArrayList() {
		
		ArrayList<E> list = new ArrayList<>();
		Node current = head;
		
		while (current != null) {
			
			list.add(current.data);
			current = current.next;
		}
		
		return list;
	}
	
	class Node {
		
		Node prev;
		E data;
		Node next;
		
		Node(Node p, E d, Node n) {
			
			prev = p;
			data = d;
			next = n;
		}
	}
}
