package model.util;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * LinkedList provides the functionality of having a LinkedList of objects with the ability to iterate through the list
 * using a LinkedListIterator object. LinkedList extends the AbstractSequentialList super class and provides concrete implementation
 * to its ListIterator(), size(), and add and set method. LinkedList does not allow null or duplicate elements. The LinkedList
 * class will be utilized to contain a LinkedList of String objects and Memoir objects.
 * 
 * @param <E> the generic object type variable
 * 
 * @author Zach Haymore
 */
public class LinkedList<E> extends AbstractSequentialList<E> {
	
	/**The ListNode that represents the front of the list*/
	private ListNode front;
	/**The ListNode that represents the back of the list*/
	private ListNode back;
	/**The number of elements inside the list*/
	private int size;
	
	/**
	 * Constructs a LinkedList by setting the field front to a null ListNode and the node back to a null ListNode 
	 * and having the nodes to point to each other through the nodes reference. The List size is set to 0. 
	 */
	public LinkedList() {
		front = new ListNode(null);
		back = new ListNode(null);
		front.next = back; 
		back.prev = front;
		size = 0;
	}
	
	/**
	 * Creates and returns a LinkedListIterator to iterate through the list starting from the passed index
	 * An IndexOutOfBoundsException is thrown from the iterator if the index is out of bounds. 
	 * 
	 * @param index the index of the value the next reference of the iterator will point to.
	 * @return the LinkedListIterator object that points to the object at the passed index
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator(index);
	}
	
	/**
	 * Overrides the AbstractSequentialList's add method to check to see if the element is a duplicate before 
	 * placing it into the list. If the element is already in the list, then an IllegalArgumentException is thrown. 
	 * Otherwise the element is placed in the corresponding index of the list. 
	 * 
	 * @param index the index to add the element
	 * @param element the element to add the index in the list
	 * @throws IllegalArgumentException if the element to add is a duplicate of an element already in the list. 
	 */
	@Override
	public void add(int index, E element) {
		if (element != null && contains(element)) {
			throw new IllegalArgumentException();
		}
		super.add(index, element);
	}

	
	/**
	 * Overrides the AbstractSequentialList's set method to check to see if the element is a duplicate before 
	 * placing it into the list. If the element is already in the list, then an IllegalArgumentException is thrown. 
	 * Otherwise the element is set to the corresponding index of the list. 
	 * 
	 * @param index the index to set the element
	 * @param element the element to set at the index in the list
	 * @throws IllegalArgumentException if the element to add is a duplicate of an element already in the list. 
	 */
	@Override
	public E set(int index, E element) {
		if (element != null && contains(element)) {
			throw new IllegalArgumentException();
		}
		return super.set(index, element);
	}

	/**
	 * Returns the current size of the LinkedList
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * The private inner ListNode class that make up the linked data structure for the LinkedList. 
	 * A ListNode object knows its data, the next reference to the next ListNode in the list, and
	 * a reference to the previous ListNode in the list. 
	 * 
	 * @author Zach Haymore
	 */
	private class ListNode {
		/**The data the ListNode contains*/
		public E data;
		
		/**A reference to the next ListNode in the list*/
		public ListNode next;
		
		/**A reference to the previous ListNode in the list*/
		public ListNode prev;
		
		/** 
		 * Constructs a ListNode object by being passed the data that the object contains. 
		 * The prev and next ListNode references are set to null.
		 * 
		 * @param data the data to store in the ListNode
		 */
		public ListNode(E data) {
			this(data, null, null);
		}
		
		/**
		 * Constructs a ListNode object by being passed the data the the object contains, a reference to the previous ListNode in the list, 
		 * and a reference to the next ListNode in the list. 
		 * 
		 * @param data the data object that is stored in the node
		 * @param prev the previous ListNode in the list
		 * @param next the next ListNode in the list. 
		 */
		public ListNode(E data, ListNode prev, ListNode next) {
			this.data = data;
			
			this.prev = prev;
			
			this.next = next;
		}
	}
	
	/**
	 * The private class LinkedListIterator provides the concrete implementation needed to construct an Iterator object
	 * that will be used to iterate throughout the LinkedList. The LinkedListIterator implements the ListIterator interface
	 * and provides the concrete implementation to its abstracted methods. The LinkedListIterator knows the previous ListNode
	 * in the list relative to the Iterators position, the next ListNode in the list relevant to its position, the indexes of 
	 * both the next and previous ListNodes, and the last retrieved ListNode that was returned by the a call to next() or previous().
	 * 
	 * @author Zach Haymore
	 */
	private class LinkedListIterator implements ListIterator<E> {
		/**The reference to the ListNode that would be returned on a call to previous()*/
		public ListNode previous; 
		/**The reference to the ListNode that would be returned on a call to next()*/
		public ListNode next;
		/**The index of the previous ListNode in the iterator*/
		public int previousIndex;
		/**The index of the next ListNode in the iterator*/
		public int nextIndex;
		/**The last ListNode retrieved and returned by the last class to the previous() or next() methods. Set to null if no method calls to either have been made*/
		private ListNode lastRetrieved;
		
		/**
		 * Constructs a LinkedListIterator by taking in the index parameter of where the ListIterator should start. 
		 * @param index the index of where the iterator should be positioned initially. 
		 * @throws IndexOutOfBoundsException if the passed index is less than 0 or greater than or equal to the size of the list. 
		 */
		public LinkedListIterator(int index) {
			
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException();
			}
			
			ListNode current = front; 
			
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			
			previous = current; 
			
			next = current.next;
			
			previousIndex = index - 1;
			
			nextIndex = index;
			
			lastRetrieved = null; 
			
		}
		
		/**
		 * Returns true if a call to next() would return data and not a null element
		 * @return true if there is a next element to return in the list. Returns false if there is not another element to return . 
		 */
		public boolean hasNext() {
			return next.data != null;
		}
		
		/**
		 * Returns true if a call to previous() would return data and not a null element. 
		 * @return true if there is a previous element in the list. Returns false is there is not an element in the previous position in  the list. 
		 */
		public boolean hasPrevious() {
			return previous.data != null; 
		}
		
		/**
		 * Returns the index of the element that would be returned from a call to the next()
		 * @return the index of the element in the next position of the iterator. Returns the size if at the end of the list. 
		 */
		public int nextIndex() {
			return nextIndex;
		}
		
		/**
		 * Returns the index of the element in the previous position of the iterator. 
		 * @return the index of the element that would be returned from a call to previous(). Returns -1 if at the front of the list. 
		 */
		public int previousIndex() {
			return previousIndex;
		}
		
		/**
		 * Returns the data of the ListNode in the next position of the iterator. Throws a NoSuchElementException 
		 * if the data in the next reference is null. Iterates the next and previous ListNodes forward, and sets
		 * the lastRetrived to the ListNode that just returned data. 
		 * 
		 * @return the data in the next ListNode reference 
		 * @throws NoSuchElementException if the data in the next reference is null.
		 */
		public E next() {
			
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			E dataToReturn = next.data;
			
			lastRetrieved = next; 
			
			previous = previous.next;
			
			next = next.next;
			
			nextIndex++; 
			
			previousIndex++; 
			
			return dataToReturn; 
			
		}
		
		/** 
		 * Returns the data of the ListNode in the previous position of the iterator. Throws a NoSuchElementException 
		 * if the data in the previous reference is null. Iterates the next and previous ListNodes backwards, and sets
		 * the lastRetrived to the ListNode that just returned data. 
		 * 
		 * @return the data in the next ListNode reference 
		 * @throws NoSuchElementException if the data in the next reference is null.
		 */
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			
			E dataToReturn = previous.data;
			
			lastRetrieved = previous;
			
			previous = previous.prev;
			
			next = next.prev;
			
			previousIndex--;
				
			nextIndex--;
			
			return dataToReturn;
		}
		
		/**
		 * Adds an element in the LinkedList between the previous element and the next element in the iterator. 
		 * Throws a NullPointerException if the passed element is null. Sets the lastRetrieved field to null. 
		 * 
		 * @param data the object to place into the list
		 * @throws NullPointerException if the passed element is null. 
		 */
		public void add(E data) {
			if (data == null) {
				throw new NullPointerException();
			}
			
			ListNode newNode = new ListNode(data, previous, next);
			
			previous.next = newNode;
			
			previous = newNode;
			
			next.prev = newNode; 
			
			lastRetrieved = null; 
			size++;
		}
		
		/**
		 * Removes the last retrieved element in the list through the next() or previous() methods. If the last retrieved is null, meaning 
		 * no previous calls to next or previous were made, then an IllegalStateException is thrown. 
		 * 
		 * @throws IllegalStateException if the last retrieved is null.
		 */
		@Override
		public void remove() {
			if (lastRetrieved == null) {
				throw new IllegalStateException();
			}
			
			previous = previous.prev;
			previous.next = next; 
			next.prev = previous;
			
			size--; 
			lastRetrieved = null; 
		}
		
		/**
		 * Sets the passed element in the ListNode that was last returned by the subsequent next() or previous() calls. 
		 * If the lastRetrieved ListNode is currently null (due to a subsequent call to add or remove), then an IllegalStateException
		 * is thrown. If the element to place in the list is null, then a NullPointerException is thrown. 
		 * 
		 * @param element the element to set in the list in the last retrieved ListNode
		 * @throws IllegalStatException if the last retrieved ListNode field is null. 
		 * @throws NullPointerException if the element to set in the list is null. 
		 */
		@Override
		public void set(E element) {
			if (lastRetrieved == null) {
				throw new IllegalStateException();
			}
			
			if (element == null) {
				throw new NullPointerException();
			}
			
			lastRetrieved.data = element;
			
		}
	}
}

