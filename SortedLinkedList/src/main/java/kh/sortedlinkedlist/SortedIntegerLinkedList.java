package kh.sortedlinkedlist;

import java.util.*;
/**
 * This class takes integers as input from the user.
 * These integers are then added into a Linked List in order (smallest to largest)
 * @author kholl
 * @version 1.0.0
 */
public class SortedIntegerLinkedList {
    
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
     * The main method takes a list of integers as input from the user
     * These numbers are then placed into a Linked List in the correct order using addToList()
     * @param args not used
     */
    public static void main(String args[]) {
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
        System.out.println("\nSORTED LIST: " + list);
    }
}
