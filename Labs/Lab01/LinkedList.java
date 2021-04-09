public class LinkedList{
	private int size;
	private Node head;
	private Node tail;

	// Constructor
	public LinkedList(){
		size = 0;
		head = null;
		tail = null;
	}

	// Returns the number of elements in the list.
	public int size(){
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}
		return false;
	}

	// Returns(butdoesnotremove)thefirstelementinthelist.
	public int first(){
		if (isEmpty()) {
			return 0;
		}
		return head.getElement();
	}

	// Returns (but does not remove) the last element in the list.
	public int last(){
		if (isEmpty()) {
			return 0;
		}
		return tail.getElement();
	}

	// addFirst(e): Adds a new element to the front of the list.
	public void addFirst(int element){
		Node newest = new Node(element, null);
		newest.setNext(head);
		head = newest;
		if (size() == 0) {
			tail = head;
		}
		size = size + 1;
	}

	// addLast(e): Adds a new element to the end of the list.
	public void addLast(int element){
		Node newest = new Node(element, null);
		if (isEmpty()) {
			head = newest;
		}
		else{
			tail.setNext(newest);
		}
		tail = newest;
		size = size + 1;
	}
	// returns the head
	public Node head(){
		return head;
	}
	// returns the tail
	public Node tail(){
		return tail;
	}

	// removeFirst(): Removes and returns the first element of the list.
	public int removeFirst(){
		if (isEmpty()) {
			return 0;
		}
		int elementDeleted = head.getElement();
		head = head.getNext();
		size = size - 1;
		if (size() == 0) {
			tail = null;
		}
		return elementDeleted;
	}
}

	// Node creation
	class Node{
		private int element;
		private Node next;

		//Constructor
		public Node(int value, Node n){
			element = value;
			next = n;
		}

		public int getElement(){
			return element;
		}

		public Node getNext(){
			return next;
		}

		public void setNext(Node n){
			next = n;
		}
	}
