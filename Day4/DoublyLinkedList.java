import java.util.HashSet;
import java.util.HashSet.*;

class DoublyLinkedList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) {
            data = d;
        }
    }
//problem 1, reverse the list
    public void reverseList() {
        Node temp = null;
        Node current = head;
        //switch references
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            temp = head;
            head = tail;
            tail = temp;
        }
    }
    //problem 2, unite two lists list1 and list2 and return the united list without any duplicate values
    public static DoublyLinkedList union(DoublyLinkedList list1, DoublyLinkedList list2){
        //new hashset
        HashSet<Integer> hashSet = new HashSet<>();
        //new dll
        DoublyLinkedList joinedList = new DoublyLinkedList();
        //loop through lists, add to union once you check hashset
        Node currentNode1 = list1.head;
        while(currentNode1 != null){
            if(hashSet.add(currentNode1.data) == true){
                joinedList.push(currentNode1.data);
            }
            currentNode1 = currentNode1.next;
        }
        Node currentNode2 = list2.head;
        while(currentNode2 != null){
            if(hashSet.add(currentNode2.data) == true){
                joinedList.push(currentNode2.data);
            }
            currentNode2 = currentNode2.next;
        }
        return joinedList;
    }

        //push to beginning of dll
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }
    //add to end of the dll
    public void append(int newData) {
        Node newNode = new Node(newData);
        newNode.next = null;
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }
 // Print the list, begin at head
    public void printList() {
        Node node = head;
        System.out.println("Traversal from head:");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.push(5);
        dll.push(10);
        dll.push(15);

        dll.printList();

        dll.reverseList();

        dll.printList();

        dll.append(20);
        dll.append(25);

        dll.printList();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.push(5);
        dll2.push(2);

        union(dll, dll2).printList();
    }
}
