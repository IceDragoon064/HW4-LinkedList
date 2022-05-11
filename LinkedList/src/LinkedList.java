import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Leon Lu
 * @version May 10, 2022
 * @Due_Date: May 11, 2022 @ 7:00 PM
 * @param <T> The type that will be used as the element type for the nodes
 * This class is to simulate LinkedList without the use of import
 */
public class LinkedList<T> implements List<T> 
{
	private Node headNode = null; //First node
	private Node tailNode = null; //Last Node
	private int size = 0; //Number of items in the list
			
	/**
	 * Empty constructor
	 */
	public LinkedList()
	{
		// Do nothing
	}
	
	/**
	 * @author Leon Lu
	 * Embedded Node class within LinkedList. Tracks previous and next nodes and data for node.
	 */
	private class Node
	{
		Node next, prev;
		T data;
		
		public Node()
		{
			//do nothing
		}
		
		public Node(T data)
		{
			this.data = data;
		}
		
		private void SetNextNode(Node next)
		{
			this.next = next;
		}
		
		private void SetPrevNode(Node prev)
		{
			this.prev = prev;
		}
		
		private void clearNode()
		{
			this.next = null;
			this.prev = null;
		}
		
		private T getItem()
		{
			return this.data;
		}
	}
	
	
	/**
	 * Add item to the end of the linked list
	 */
	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		Node newNode = new Node(item);
		newNode.next = null;
		
		// If there is no node, add new node as head node
		if (this.isEmpty() == true)
		{
			this.headNode = newNode;
		}

		// Add new node to the end of the linked list
		else
		{
			this.tailNode.SetNextNode(newNode);
		}
		this.tailNode = newNode;
		this.size++;
	}

	/**
	 * Empty out the nodes in the linked list
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		Node tempNode = new Node();
		while(this.isEmpty() == false)
		{
			tempNode = this.headNode;
			this.headNode = this.headNode.next;
			tempNode = null;
		}
		this.size = 0;
	}

	/**
	 * Search item in the linked list.
	 * @return true if the item is in the linked list; false otherwise
	 */
	@Override
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		
		//Check if list is empty
		if(this.isEmpty() == true)
		{
			return false; 
		}
		
		else
		{
			Node currentNode = this.headNode;
			
			// Start at head node and move to the next node 
			// While loop stops when currentNode is null
			while(currentNode != null)
			{
				if(currentNode.data == item)
				{
					return true;
				}
				currentNode = currentNode.next;
			}
			return false;
		}
	}

	/**
	 * Check if linked list is empty
	 * @return true if the linked list is empty; false otherwise
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		// Head node should always be the first node, and only node if one node exists
		if(this.headNode == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	/**
	 * Return an item found in the linked list; delete node and associated item if found
	 * @return item from the linked list; null if item doesn't exist in the linked list
	 */
	@Override
	public T remove(Object item) {
		// TODO Auto-generated method stub

		// Return null if linked list is empty
		if(this.isEmpty() == true)
		{
			return null;
		}
		
		else
		{
			Node currentNode = headNode;
			int index = 0;
			
			// Search linked list for node containing item
			while(currentNode != null)
			{
				if(currentNode.data == item)
				{
					T dataToSend = currentNode.data;
					this.remove(index);
					return dataToSend;
				}
				currentNode = currentNode.next;
				index++;
			}
			return null;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		if(this.isEmpty() == true)
		{
			return null;
		}
		
		else
		{
			return this.iterator();
		}	
	}

	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		
		// Throw error if index is out of bounds
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		else
		{
			// Start "search" on the head node
			int currentIndex = 0;
			Node currentNode = this.headNode;
			
			while(currentNode != null)
			{
				if(currentIndex == index)
				{
					// Index at 0 means new node will be a head node
					if(currentIndex == 0)
					{
						this.addFirst(item);
					}
					
					// Last index means new node will be tail node
					else if(currentIndex == this.size - 1)
					{
						this.addLast(item);
					}
					
					// Create node in between two existing nodes (A and B)
					// Previous Node - New Node - Next Node
					// A - X - B
					else
					{
						// Node 
						Node prevNode = currentNode.prev; // A
						Node nextNode = currentNode.next; // B
						
						// Create new links for the new node
						Node newNode = new Node (item);
						newNode.SetNextNode(nextNode); // Link X to B
						newNode.SetPrevNode(prevNode); // Link X to A
						
						// Change links from the existing nodes
						prevNode.SetNextNode(newNode); // Link A to X
						nextNode.SetPrevNode(newNode); // Link B to X
					}
				}
				currentNode = currentNode.next; // Move to the next node
				currentIndex++; // Increment index
			}
		}
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if(this.isEmpty() == true)
		{
			return null;
		}
		
		else if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		else
		{
			Node currentNode = this.headNode;
			int currentIndex = 0;
			while(currentNode != null)
			{
				if(currentIndex == index)
				{
					return currentNode.data;
				}
				currentNode = currentNode.next;
				currentIndex++;
			}
			return null;
		}
		
	}

	@Override
	public int indexOf(Object item) {
		// TODO Auto-generated method stub
		if(this.isEmpty() == true)
		{
			return -1;
		}
		
		else
		{
			Node currentNode = this.headNode;
			int currentIndex = 0;
			while(currentNode != null)
			{
				if(currentNode.data == item)
				{
					return currentIndex;
				}
				currentNode = currentNode.next;
				currentIndex++;
			}
			return -1;
		}
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			Node currentNode = this.headNode;
			int cNodeIndex = 0;
			
			while(currentNode != null)
			{
				if(cNodeIndex == index)
				{
					T itemToSend = currentNode.data;
					Node prevNode = currentNode.prev;
					Node nextNode = currentNode.next;
					
					// Link the previous and next nodes with each other
					prevNode.next.SetNextNode(nextNode);
					nextNode.prev.SetPrevNode(prevNode);
					
					currentNode.clearNode();
					currentNode = null;
					size--;
					return itemToSend;
				}
				currentNode = currentNode.next;
				cNodeIndex++;
			}
			return null;
		}
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		// TODO method stub
		if(headNode == null)
		{
			throw new NoSuchElementException();
		}
		
		else
		{
			return headNode.getItem();
		}
		
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		// TODO method stub\
		if(tailNode == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return tailNode.getItem();
		}
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		// TODO method stub
		Node newNode = new Node(item);
		
		// Create a new head node to start a new linked list
		if(isEmpty() == true)
		{
			newNode.SetNextNode(this.headNode);
			this.headNode = newNode;
		}
		
		else
		{
			newNode.next = this.headNode;
			this.headNode.prev = newNode;
			this.headNode = newNode;
		}	
		this.size++;
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		// TODO method stub
		
		Node newNode = new Node(item);
		newNode.SetNextNode(null);
		
		// If there is no node, create a new node
		if(this.isEmpty() == true)
		{
			this.headNode = newNode;
		}
		
		// Link current tail node to the new node
		else
		{
			newNode.SetPrevNode(this.tailNode);
			this.tailNode.SetNextNode(newNode);
		}
		
		// Assign tail node as the newly created node
		this.tailNode = newNode;
		this.size++;
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		// TODO method stub
		
		if(this.isEmpty() == true)
		{
			throw new NoSuchElementException();
		}

		else
		{
			T item = this.headNode.data;
			Node temp = this.headNode;
			this.headNode = this.headNode.next;
			this.headNode.prev = null;
			temp = null;
			this.size--;
			return item;
		}
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		// TODO method stub
		if(this.isEmpty() == true)
		{
			throw new NoSuchElementException();
		}

		else
		{
			T item = this.tailNode.data;
			Node tempNode = this.tailNode;
			this.tailNode = this.tailNode.prev;
			this.tailNode.next = null;
			tempNode = null;
			this.size--;
			return item;
		}
	}
}