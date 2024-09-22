package Day4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import java.util.LinkedList;
class ListNode {
    int value;
    ListNode next;

    ListNode(int x) {
        value = x;
        next = null;
    }
}
public class sandboxfour {
   
    public static void main(String[] args) {

        ListNode start = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        start.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; 

        boolean hasCycle = hasCycle(start);
        System.out.println("Cycle detected: " + hasCycle);
    }

    private static boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true; 
            }
            visited.add(current);
            current = current.next;
        }

        return false; 
    }
    //Used ChatGPT to help ideate solution
}
