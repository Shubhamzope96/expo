package practicejava.collections;

import java.util.ArrayDeque;

public class CollectionsArrayDeque {

	public static void main(String[] args) {
		ArrayDeque adq1 = new ArrayDeque();
        ArrayDeque<Integer> adq2 = new ArrayDeque();
        // add values

        adq1.add(1);
        adq1.add(5);
        adq1.add(3);
        adq1.add(4);
        adq1.add(6);
        adq1.add(2);
        System.out.println(adq1);
        
        // use offerFirst(), peekFirst(), pollFirst() methods to work with front end of
        // queue add values to front end of the queue
        adq2.offerFirst(10);
        adq2.offerFirst(20);
        adq2.offerFirst(30);
        adq2.offerFirst(40);
        adq2.offerFirst(50);
        System.out.println("All values: " + adq2);

        // get head from front end of the queue but does not remove
        int x = adq2.peekFirst();
        System.out.println("Head of queue from front end: " + x);

        // remove head from front end of the queue
        int a = adq2.pollFirst();
        System.out.println("Head of queue from front end: " + a);

        // remove head from front end of the queue
        a = adq2.pollFirst();
        System.out.println("Head of queue from front end: " + a);

        System.out.println("All values after poll: " + adq2);

        // use offerLast(), peekLast(), pollLast() methods to work with tail end of
        // queue
        // add values to rear end of the queue
        adq2.offerLast(11);
        adq2.offerLast(22);
        adq2.offerLast(33);
        adq2.offerLast(44);
        System.out.println("All values: " + adq2);

        // get head from rear end of the queue
        int y = adq2.peekLast();
        System.out.println("Head of queue from rear end: " + y);

        // remove head from rear end of the queue
        a = adq2.pollLast();
        System.out.println("Head of queue from rear end: " + a);

        // remove head from rear end of the queue
        a = adq2.pollLast();
        System.out.println("Head of queue from rear end: " + a);

        System.out.println("All values after poll: " + adq2);
	}


}
