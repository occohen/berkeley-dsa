package Day4;
public class DoublyLinkedList {
    //node class
    public class Node {
        int data;
        Node prev;
        Node next;
    
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    Node head;

    public DoublyLinkedList() {
        head = null;
    }

    // append data to our list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    // reverse dll
    public void reverse() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}