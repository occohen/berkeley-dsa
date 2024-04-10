



/* 
Give at least two examples (in real life and in programming) and a short description for:
Stacks: LIFO = Last in first out. 
This means that anything entered into the stack will go to the end of the list, 
and anything removed (popped) will go out from the end of the list.
Programming example: Version history. For example, in a google document. If I make a change, then it gets added to the end of the stack. If I wanted to "undo," I would pop it from the end of the stack. This means that the most recent action will be undone every time, and new actions will be added to the end.
Real life example: Sorting a pile of items. When new items need to be sorted, they are added to the end of the stack. When I take something out of the stack to sort it, I remove it from the top of the list (since taking it from the bottom of the pile would be impractical). The limitation to this is that items can be forgotten at the bottom of the pile as new items are added to the top.

Queues: FIFO = First in first out.
This means that anything entered into the stack will go to the end of the list (the same as in Stacks). 
This is called enqueue.
Queues also mean that anything dequeued from the queue will be removed from the beginning of the list.
Programming example: Printer queues. When you print something, your computer will add it to the end of the queue of things that the printer needs to print. The printer will take items off the queue as it prints them, starting at the bottom and working its way to the top.
Real life example: A line at an ice cream shop. New customers enter the end of the line, and the store serves the people from the front of the line (thereby removing them from the queue).

Deques: Double ended queue.
This means that things can be removed or added to either side of the list (front or back).
Programming example: Search history. As more entries are added to the end (more searches), the deque is expanded to the right (or the front). At a certain point, the capacity for total storage is fulfilled, and the searches from the beginning need to be removed. Using a deque would allow users to also remove searches from the end of the list more efficiently.
Real life example: Task scheduling. High priority tasks can be added to the beginning of the list (and removed once they are complete) and lower priority tasks can be added to the end. When tasks are completed, they can be removed from either end. This allows users to have greater control over the workflow.
*/


package Day2;
import java.util.ArrayDeque;
import java.util.ArrayList;
class assignmenttwo{
    //binary search (problem 4)
    public static int binarySearch(int[] sortedArray, int startIndex, int endIndex, int target){
        //element not found
        if(startIndex > endIndex)
        {
            System.out.println("Element not found");
            return -1;
        }
        //get middle index
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        //target found
        if(sortedArray[middleIndex] == target){
            return middleIndex;
        }
        //target is to the left of mid index
        else if(sortedArray[middleIndex] > target){
            return binarySearch(sortedArray, startIndex, middleIndex - 1, target);
        //target is to the right of mid index
        }else if(sortedArray[middleIndex] < target){
            return binarySearch(sortedArray, middleIndex + 1, endIndex, target);
        }else{
            //should never reach this case.
            System.out.println("Reached end somehow?");
            return -1;
        }
    }
    //class for Deque
    public static class Deque{
        //instance var
        public int[] dequeArray;
        //constructor
        public Deque(int[] dequeArray){
            this.dequeArray = dequeArray;
        }
        public int getCount(){
            return this.dequeArray.length;
        }
        public int peekLeft(){
            return this.dequeArray[0];
        }
        public int peekRight(){
            return this.dequeArray[this.dequeArray.length - 1];
        }
        
        public int popLeft(){
            int poppedElement = this.dequeArray[0];
            int[] newArray = new int[this.dequeArray.length - 1];
            for(int i = 1; i < this.dequeArray.length; i++){
                newArray[i - 1] = this.dequeArray[i];
            }
            this.dequeArray = newArray;
            return poppedElement;
        }
        public int popRight(){
            int poppedElement = this.dequeArray[this.dequeArray.length - 1];
            int[] newArray = new int[this.dequeArray.length - 1];
            for(int i = 0; i < newArray.length; i++){
                newArray[i] = this.dequeArray[i];
            }
            this.dequeArray = newArray;
            return poppedElement;
        }
        public void appendRight(int insertValue){
            int[] newArray = new int[this.dequeArray.length + 1];
            newArray[newArray.length - 1] = insertValue;
            for(int i = 0; i < this.dequeArray.length; i++){
                newArray[i] = this.dequeArray[i];
            }
            this.dequeArray = newArray;
        }
        public void appendLeft(int insertValue){
            int[] newArray = new int[this.dequeArray.length + 1];
            newArray[0] = insertValue;
            for(int i = 0; i < this.dequeArray.length; i++){
                newArray[i+1] = this.dequeArray[i];
            }
            this.dequeArray = newArray;
        }
        public void printDeque(){
            System.out.println("new array is:");
            for(int i = 0; i < this.dequeArray.length; i++){
                System.out.print(this.dequeArray[i] + ",");
            }
            System.out.println("");
        }
        public void setIndex(int index, int value){
            this.dequeArray[index] = value;
        }
    }


    //Check Balanced Braces
    public static Boolean checkBalanced(String input){
        //edgecase, string empty
        if(input.length() == 0)return true;
        //create deque
        ArrayDeque<Character> inputArray = new ArrayDeque<Character>();
        //loop through the input string
        for(int i = 0; i < input.length();i++){
            //add opening braces to stack
            if(Character.toString(input.charAt(i)).equals("(") || Character.toString(input.charAt(i)).equals("{") || Character.toString(input.charAt(i)).equals("[")){
                inputArray.offerLast((input.charAt(i)));
            }
            //check closing braces against most recent opening brace in the stack
            else if(Character.toString(input.charAt(i)).equals(")") || Character.toString(input.charAt(i)).equals("}") || Character.toString(input.charAt(i)).equals("]")){
                if(inputArray.isEmpty())return false;
                String mostRecent = Character.toString(inputArray.removeLast());
                String current = Character.toString(input.charAt(i));
                //mismatches
                if(current.equals(")") && !mostRecent.equals( "(")){
                        return false;
                }
                else if(current.equals("]") && !mostRecent.equals( "[")){
                        return false;
                }
                else if(current.equals("}") && !mostRecent.equals( "{")){
                        return false;
                }
            }
        }
        //if array is empty, all the braces found a match = should return true
        return (inputArray.isEmpty());
    }
    //driver method
    public static void main(String[] args) {
        //loop through test cases
        ArrayList<String> tests = new ArrayList<String>();
        tests.add("[ ]");
        tests.add("{}{}[]()");
        tests.add("[{()}]");
        tests.add("(()[[[()({})]]])");
        tests.add("[ ] [");
        tests.add("{{}[](})");
        tests.add("[{)}]");
        tests.add("(()[()({})]]])");
        for(int i = 0; i < tests.size(); i++){
            System.out.println("test case" + i + checkBalanced(tests.get(i)));
        }
        
        //test deque
        int[] arrayOne = new int[5];
        Deque dequeArray = new Deque(arrayOne);
        dequeArray.setIndex(0,1);
        System.out.println("Create new array");
        dequeArray.printDeque();

        System.out.println("Insert 3 at the left");
        dequeArray.appendLeft(3); 
        dequeArray.printDeque();

        System.out.println("Insert 5 at the right");
        dequeArray.appendRight(5);
        dequeArray.printDeque();

        System.out.println("Pop right");
        System.out.println(dequeArray.popRight());
        dequeArray.printDeque();

        System.out.println("Pop left");
        System.out.println(dequeArray.popLeft());
        dequeArray.printDeque();

        System.out.println("Peek Left" + dequeArray.peekLeft());

        System.out.println("Peek Right" + dequeArray.peekRight());

        System.out.println("Current count is:" + dequeArray.getCount());

        //Test binary search
        int[] sortedArray = new int[30];
        for(int i = 0; i < sortedArray.length; i++){
            sortedArray[i] = (i * 3) - 1;
        }
        Deque sortedDeque = new Deque(sortedArray);
        sortedDeque.printDeque();
        //give some random target, see if it is in
        System.out.println(binarySearch(sortedArray, 0, sortedArray.length - 1, 44));
    } 
}