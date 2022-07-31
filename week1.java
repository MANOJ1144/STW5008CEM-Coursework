/* Question :(week 1) 
You are provided with kth linked list. Write an algorithm to find median of merged linked
list in sorter order.
input: list 1= [2,4,7,5,10]
list2 = [3,2,7,9]
list3 = [12,5,6,9]
output: 5
Explanation:
after merging above kth linked list i.e three list in sorted order linked list become,
[2,2,3,4,5,5,6,7,7,9,9,10] */

// Solution:

import java.util.*;

public class week1 {

    // First create queue for all input values
    Queue<Integer> list;
    int totalSize;

    week1(LinkedList[] a) {

        // int size = a.length;
        // whole is total sum of sub-linkedlist 
        int whole = 0;

        // Loop through all sub-linkedlist
        for (int i = 0; i < a.length; i++) {

            whole += a[i].size();

        }

        totalSize = whole;
        // Create priority queue for all input values

        list = new PriorityQueue<Integer>(whole);

        LinkedList current;
        // Most priority queue
        // loop through linkedlist to add data

        for (int i = 0; i < a.length; i++) {

            current = a[i];

            int internalItterator = 0;

            while (internalItterator < current.size()) {

                
                int adder = (Integer) current.get(0);
                list.add(adder);
                current.removeFirst();
            }
            internalItterator++;

        }

    }
    // method to return value
    // sorting in array form

    int[] queueItterator() {

        int[] returner = new int[totalSize];

        for (int i = 0; i < totalSize; i++) {
            returner[i] = list.remove();
        }

        return returner;

    }

    public static void main(String[] args) {

        LinkedList a = new LinkedList<Integer>();

        a.add(2);
        a.add(4);
        a.add(7);
        a.add(5);
        a.add(10);

        LinkedList b = new LinkedList<Integer>();

        b.add(3);
        b.add(2);
        b.add(7);
        b.add(9);

        LinkedList c = new LinkedList<Integer>();

        c.add(1);
        c.add(2);
        c.add(5);
        c.add(6);
        c.add(9);

        LinkedList[] list = {a, b, c};

        week1 medianFinder = new week1(list);

        int[] requiredArr = medianFinder.queueItterator();

    //    formula for median is (n+1)/2
        int median = (requiredArr.length + 1) / 2;

        System.out.println(requiredArr.length);

        System.out.println(median);

        System.out.println(requiredArr[median]);
    }
}





