public class LinkedListTest{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		Node n1 = new Node(1, null);
		Node n2 = new Node(2, null);
		Node n3 = new Node(3, null);


		list.addFirst(n3.getElement());
		list.addFirst(n2.getElement());
		list.addFirst(n1.getElement());
		list.addLast(4);

		assert(n1.getElement() == list.first());
	    assert(n2.getElement() == list.head().getNext().getElement());
	    assert(n3.getElement() == list.head().getNext().getNext().getElement());
	    assert(list.size() == 4);
	    assert(list.tail().getElement() == 4);
	    // System.out.println(list.removeFirst()); 
	    assert(list.removeFirst() == 1);
	    System.out.println("All Testcases Passed!!!");
	}
}