package kh.sortedstack;
import java.util.*;
/**
 * This class takes integers as input from the user.
 * Input integers are added to a Linked List in ascending order.
 * The elements are then pushed from the Linked List to a Stack, maintaining the order
 * Adapted from version 1.0.0 of SortedIntegerLinkedList
 * @author Kat Holland
 * @version 2.0.0
 */
public class SortedIntegerStack {
    /**
     * This method adds an integer to the Linked List in the correct position.
     * @param PList The sorted Linked List
     * @param PNum  The integer to add to the Linked List
     */
    public static void addToList(LinkedList<Integer> PList, int PNum) {
        ListIterator<Integer> iter = PList.listIterator();
        while (iter.hasNext()) {
            int nxt = iter.next();
            if (PNum < nxt) {
                iter.previous();
                iter.add(PNum);
                return;
            }
        }
        PList.addLast(PNum);
    }
    
    /**
     * This method takes a list of numbers as input and creates a stack with the
     * numbers in the same order as the list.
     * @param PNumbers The list of numbers
     * @return Stack The stack created from the given list
     */
    public static Stack<Integer> createStack(List<Integer> PNumbers){
        Stack<Integer> Stack = new Stack<>();
        Stack.addAll(PNumbers);
        return Stack;
    }
    
    /**
     * The main method takes a list of integers as input from the user.
     * These numbers are then placed into a Linked List in ascending order using addToList()
     * This list is then used to create a Stack in the same order
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Enter a list of numbers. Press Enter after each number. \n Type 'quit' to finish");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);
                addToList(list, num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!!\nPlease enter either an integer or 'quit' to finish");
            }
        }
        
        Stack<Integer> sortedStack = createStack(list);
        System.out.println("\nSORTED STACK:  " + sortedStack);
    }
}
