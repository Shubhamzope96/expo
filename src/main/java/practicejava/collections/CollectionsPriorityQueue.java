package practicejava.collections;

import java.util.PriorityQueue;

public class CollectionsPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue pq1 = new PriorityQueue();

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();

        // add values

        pq1.add(1);

        pq1.add(5);

        pq1.add(3);

        pq1.offer(4);

        pq1.offer(6);

        pq1.offer(2);

        System.out.println("All values: " + pq1);//[1,5,3,4,6,2]

        pq2.addAll(pq1);//[1,5,3,4,6,2]



        // peek will return the value from the head of the queue but does not remove the

        // element

        Object o1 = pq1.peek();

        System.out.println("Head of queue: " + o1);//1

        System.out.println("Size after after peek: " + pq1.size());//6

        System.out.println("All values after peek: " + pq1);//[1,5,3,4,6,2]



        int i = pq2.peek();

        System.out.println("Head of queue: " + i);//1

        System.out.println("Size after after peek: " + pq2.size());//6

        System.out.println("All values after peek: " + pq2);//[1,5,3,4,6,2]



        // poll will return the value from the head of the queue and will remove the

        // element

        int x = pq2.poll();

        System.out.println("Head of queue: " + x);

        System.out.println("Size after after poll: " + pq2.size());

        System.out.println("All values after poll: " + pq2);

        // element() returns the element at the head of the queue. The element is not

        // removed.

        Object o2 = pq1.element();

        System.out.println(o2);

        System.out.println("Size after after element: " + pq1.size());

        // remove() removes the element at the head of the queue, returning the element

        // in the process.

        Object o3 = pq1.remove();

        System.out.println(o3);

        System.out.println("Size after after remove: " + pq1.size());
        System.out.println("Size after after remove: " + pq2.size());

}
}
