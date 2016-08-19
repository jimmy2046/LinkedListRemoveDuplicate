// This demonstrate to duplicated notes in a linked list.
// Firstly, sort the linked list.
// Then, remove the duplicate node the the next node is equal to the current node.

public class LinkedList {
	// This class has a default constructor:
	public LinkedList(){
		length = 0;
	}

	// This is the only field of the class. It holds the head of the list
	ListNode head;
	
	// Length of the linked list
	private int length = 0;

	// Return the first node in the list
	public synchronized ListNode getHead(){
		return head;
	}
	
	// Insert a node at the beginning of the list
	public synchronized void insertAtBegin(ListNode node){
		node.setNext(head);
		head = node;
		length++;
	}
	
	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	public void remove(int position){
		// fix position
		if (position < 0){
			position = 0;
		}
		if (position >= length){
			position = length - 1;
		}
		// if nothing in the list, do nothing
		if (head == null){
			return;
		}
		// if removing the head element ...
		if (position == 0){
			head = head.getNext();			
		}
		// else advance to the correct position and remove
		else {
			ListNode temp = head;
			for (int i=1; i<position; i+=1){
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		// reduce the length of the list
		length -= 1;			
	}
	
	// Return a string presentation of this collection, in the form ["str1","str2",...].
	public String toString(){
		String result = "[";
		if (head == null){
			return result+"]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();
		
		while (temp!=null){
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result+"]";			
	}

	// Return the current length of the list.
	public int length(){
		return length;
	}
	
	// Find the position of the first value that is equal to a given value.
	// The equals method us used to determine equality.
	public int getPosition(int data){
		// go looking for the data
		ListNode temp = head;
		int pos = 0;
		
		while (temp != null){
			if (temp.getData() == data){
				// return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		// else return some larger value
		return Integer.MIN_VALUE;
	}
	
	// Remove everything from the list.
	public void clearList(){
		head = null;
		length = 0;
	}
	
	
    // sort
    // bubble sort algorithm
    public void bubbleSort(){
    	int i, j, k, tempData ;
    	ListNode current;
    	ListNode next;
    	int size = length();
    	k = size ;
    	
    	for ( i = 0 ; i < size - 1 ; i++, k-- ) {
    		current = head;
    		next = head.getNext() ;
    		
    	      for ( j = 1 ; j < k ; j++ ) {
    	          if ( current.getData() > next.getData() ) {
    	        	  tempData = current.getData() ;
    	        	  current.setData(next.getData());
    	        	  next.setData(tempData);    	        	  
    	          }
    	          current = current.getNext();
    	          next = next.getNext(); 
    	      }
    	}    	
    }
    
    // remove duplicate
    // sort first, then remove duplicate
    public void removeDuplicate(){
    	
    	bubbleSort();
    	
		ListNode temp = head;
			
		while (temp.getNext() !=null){
			if (temp.getData() == temp.getNext().getData()) {
				temp.setNext(temp.getNext().getNext());
				length -= 1;				
			}
			else {				
				temp = temp.getNext();
			}
		}    	    					    		    	
    }        
			
}


public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return data;
	}
	public void setNext(ListNode next){
		this.next = next;
	}
	public ListNode getNext(){
		return this.next;
	}
	public int ListLength(ListNode headNode){
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}		
}


public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.insertAtBegin(new ListNode(3));
		list.insertAtBegin(new ListNode(1));
		list.insertAtBegin(new ListNode(3));
		list.insertAtBegin(new ListNode(2));
		list.insertAtBegin(new ListNode(3));
		list.insertAtBegin(new ListNode(4));
		list.insertAtBegin(new ListNode(5));
		list.insertAtBegin(new ListNode(1));
		list.insertAtBegin(new ListNode(2));
		list.insertAtBegin(new ListNode(3));
		list.insertAtBegin(new ListNode(2));		
		System.out.println(list.toString());		
				
		list.removeDuplicate();
		System.out.println(list.toString());
	}

}
