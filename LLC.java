import java.util.*;

class LLC {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      // Write your code here.
			if(head == null){
				head = node;
				tail = node;
				return;
			}
			insertBefore(head,node);
    }

    public void setTail(Node node) {
      // Write your code here.
			if(tail== null){
				setHead(node);
				return;
			}
			insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      // Write your code here.
			if(nodeToInsert ==  head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;

			if(node.prev == null){
				head = nodeToInsert;}
			else{
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;

    }

    public void insertAfter(Node node, Node nodeToInsert) {
      // Write your code here.
			if(nodeToInsert ==  head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;

			if(node.next == null)
					tail = nodeToInsert;
			else
				node.next.prev = nodeToInsert;

			node.next = nodeToInsert;


    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
			if(position == 1){
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int currentPos = 1;
			while(node != null && currentPos++ != position ) node = node.next;
			if(node != null){
				insertBefore(node, nodeToInsert);
			}
			else{
				setTail(nodeToInsert);
			}

    }

    public void removeNodesWithValue(int value) {
			// Write your code here.
			Node node = head;
			 while(node != null){
				 Node nodeRemove = node;
				 node = node.next;
				 if(nodeRemove.value == value) remove(nodeRemove);
			 }
    }

    public void remove(Node node) {
      // Write your code here.
			if (node == head) head = head.next;
			if (node == tail) tail = tail.prev;
			removebindNode(node);
    }
		public void removebindNode(Node node){
			if(node.prev != null) node.prev.next = node.next;
			if(node.next != null) node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
    public boolean containsNodeWithValue(int value) {
      // Write your code here.
			Node node = head;
			while(node != null && node.value != value){
				node = node.next;
			}
      return node != null;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
