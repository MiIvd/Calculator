package data_structures;

import java.util.Iterator;

public class Stack<E> {
	private ListI<E> list;
	public Stack()	{
		list = new LinkedList<E>();
	}
	
	/**
	 * Adds an object to the beginning of the list
	 * @param obj the object to be added to the list
	 */
	
	public void push (E obj) {
		list.addFirst(obj);
	}
	
	/**
	 * Removes the first object in the list and returns it. Return null if list is empty.
	 * @return the object removed
	 */
	
	public E pop() {
		return list.removeFirst();
	}
	
	/**
	 * Returns the number of objects currently in the list.
	 * @return the number of objects currently in the list
	 */
	
	public int size()	{
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
	 * Test whether the list is full.
	 * @return true if the list is full, otherwise false
	 */
	
	public boolean isFull() {
		return list.isFull();
	}
	
	/**
	 * Returns the last object in the list, but does not remove it. Returns null if the list is empty.
	 * @return the object at the end of the list
	 */
	
	public E peek () {
		return list.peekFirst();
	}
	
	/**
	 * Test whether the list contains an object. This will use the object's compareTo method
	 * to determine whether two objects are the same.
	 * @param obj the object to look for in the list
	 * @return true if the object is found in the list, return false if it is not found
	 */
	
	public boolean contains (E obj) {
		return list.contains(obj);
	}
	
	/**
	 * Returns list to an empty state. Constant time operation.
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
