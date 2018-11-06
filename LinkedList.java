package data_structures;

import java.util.Iterator;

public class LinkedList<E> implements ListI<E> {

	class Node<E> {
		E data;
		Node<E> next;
		public Node (E obj){
			data = obj;
			next = null;
		}
	}
		public Node<E> head;
		public Node<E> tail;
		public int currentSize;
		private Comparable<E> data;

		public LinkedList() {
			head = null;
			tail = null;
			currentSize = 0;

		}
		
		/**
		 * Adds an object to the beginning of the list.
		 * 
		 * @param obj the object to be added to the list.
		 */
		
		public void addFirst(E obj) {
			Node<E> node = new Node<E>(obj);
			node.next = head;
			if (head == null)
				tail = node;
			head = node;
			currentSize++;
			return;
	
		}
		
		/**
		 * Adds an object to the end of the list.
		 * @param obj the object to be added to the list.
		 */
		
		public void addLast(E obj) {
			Node<E> node = new Node<E>(obj);
			if (head == null){
				head = tail = node;
				currentSize++;
				return;
			}
				tail.next = node;
				tail = node;
				currentSize++;
				return;
		}
		
		/**
		 * Removes the first Object in the list and returns it.
		 * Returns null if the list is empty.
		 * @return the object removed.
		 */
		
		public E removeFirst() {
			if (head == null)
				return null;
			E tmp = head.data;
			if (head == tail)
			head = tail = null;
			else 
				head = head.next;
			currentSize--;
			return tmp;
		}
		
		/**
		 * Removes the last Object in the list and returns it.
		 * Returns null if the list is empty.
		 * @return the object removed.
		 */
		
		public E removeLast() {
			if (isEmpty())
				return null;
			if (head == tail)
				return removeFirst();
			E tmp = tail.data;
			Node<E> current = head , previous = null;
			
			while (current != tail) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			tail = previous;
			currentSize--;
			return tmp;
		}
		
		/**
		 * 
		 * @param obj
		 * @return
		 */
		
		public E remove(E obj){
			Node<E> current = head , previous = null;
			while (current != null) {
				if (((Comparable<E>) data).compareTo(current.data)==0) {
					if (current == head) {
						return removeFirst();
					}
					if (current == tail) {
						return removeLast();
					}
				    }
					previous.next = current.next;
					currentSize--;
					return current.data;
				}
				previous = current;
				current = current.next;
				{
				return null;
				}
		}
		
		/**
		 * Returns the first Object in the list, but does not remove it.
		 * Returns null if the list is empty.
		 * @return the object at the beginning of the list.
		 */
		
		public E peekFirst() {
			if (head == null)
				return null;
				return head.data;
		}
		
		/**
		 * Returns the last Object in the list, but does not remove it. 
		 * Returns null if the list is empty.
		 * @return the object at the end of the list.
		 */

		public E peekLast() {
			if (tail == null)
				return null;
				return tail.data;
		}
		
		/**
		 * Return the list to an empty state.
		 * This should generally be a constant time operation.
		 */
		
		public void makeEmpty() {
			tail = head = null;
			currentSize = 0;
		}
		
		/**
		 * Test whether the list is empty.
		 * @return true if the list is empty, otherwise false
		 */
		
		public boolean isEmpty() {
			return head == null;
		}
		
		/**
		 * Test whether the list is full.
		 * @return true if the list is full, otherwise false
		 */
		
		public boolean isFull() {
			return false;
		}
		
		/**
		 * Returns the number of Objects currently in the list.
		 * @return the number of Objects currently in the list.
		 */

		public int size() {
			return currentSize;
		}
		
		/**
		 * Test whether the list contains an object. This will use the object's
		 * compareTo method to determine whether two objects are the same.
		 * 
		 * @param obj The object to look for in the list
		 * @return true if the object is found in the list, false if it is not found
		 */
		
		public boolean contains(Object obj) {
			Node <E> tmp = head;
			while (tmp.next != null) {
				if (tmp.data.equals(obj)) {
					return true;
				}
					tmp = tmp.next;
				}
				return false;
		}
		
		/**
		 * Returns an Iterator of the values in the list, presented in
		 * the same order as the list.
		 * @see java.lang.Iterable#iterator()
		 */
		
		public Iterator<E> iterator() {
			return new IteratorHelper();
		}
		
		class IteratorHelper implements Iterator<E> {
			Node<E> index;
			
			/**
			 * Points the index to head.
			 */
			
			public IteratorHelper() {
				index = head;
			}
			
			/**
			 * @return true if the iteration has more elements.
			 */
			
			public boolean hasNext() {
				return index != null;
			}
			
			/**
			 * @return the next element in the iteration.
			 */
			
			public E next() {
				E tmp = index.data;
				index = index.next;
				return tmp;
			}
			
		}
/**
 * Tester
 * @param args
 * @return list.peekFirst(), list.peekLast()
 */
	public void main(String[] args) {
		LinkedList<Integer> list = new LinkedList();
		list.addLast(123);
		list.addLast(456);
		list.addLast(789);
	System.out.println(list.peekFirst());
	System.out.println(list.peekLast());

	}
}