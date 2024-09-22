package Day4;


public class assignmentfour {

    public static void main(String[] args) {
        //create new dll
        DoublyLinkedList dll = new DoublyLinkedList();
        //append data to it
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
        //shift/print
        System.out.println("Pre-shift list:");
        dll.printList();
        dll.reverse();
        System.out.println("Post-shift list:");
        dll.printList();
    }
  
    
}