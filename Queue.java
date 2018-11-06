package data_structures;

import java.util.Iterator;

public class Queue<E> {
	private ListI<E> list;
	public Queue()	{
		list = new LinkedList<E>();
	}
	
	/**
	 * Adds an object to the end of the list.
	 * @param obj the object to be added to the list
	 */
	
	public void enqueue(E obj) {
		list.addLast(obj);
	}
	
	/**
	 * Tests whether the list is empty, then removes the first object in the list and returns it.
	 * @return the object removed, null if list is empty
	 */
	
	public E dequeue() {
			return list.removeFirst();
	}
	
	/**
	 * Returns the number of objects currently in the list.
	 * @return number of objects currently in the list
	 */
	
	public int size() {
		return list.size();
	}
	
	/**
	 * Test whether the list is empty.
	 * @return true if the list is empty, otherwise false
	 */
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Returns the first object in the list but does not remove it. Returns null if list is empty.
	 * @return the object at the beginning of the list.
	 */
	
	public E peek() {
		return list.peekFirst();
	}
	
	/**
	 * Test whether the list contains an object. Uses the object's compareTo method
	 * to determine whether two objects are the same.
	 * @param obj The object to look for in the list
	 * @return true if the object is found, false if not
	 */
	
	public boolean contains(E obj) {
		return list.contains(obj);
	}
	
	/**
	 * Return list to an empty state. Constant time operation.
	 */
	
	public void makeEmpty() {
		list.makeEmpty();
	}
	
	/**
	 * Allows the caller to remove elements from the underlying collection during the iteration
	 * @return an iterator of the values in the list, presented in the same order as the list
	 */
	
	public Iterator<E> iterator() {
		return list.iterator();
	}
}
