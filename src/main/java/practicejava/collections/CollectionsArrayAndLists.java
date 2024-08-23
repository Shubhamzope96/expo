package practicejava.collections;

import java.util.*;

public class CollectionsArrayAndLists {
	public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr1 = new int[] {1,2,3,4,5,6};
        CollectionsArrayAndLists hw = new CollectionsArrayAndLists();
        int [] k = new int [5] ;
        System.out.println(k);
        
        LinkedList l1 = new LinkedList(List.of(3,4,5,7));
        LinkedList l2 = new LinkedList(List.of(23,24,46,50));
        l1.addAll(l2);
        System.out.println(l1);
        l1.add(1, 2);
        System.out.println(l1);
        List l = List.of("shu","kri",1,4);
        l1.addAll(2, l);
        System.out.println(l1);
        Queue la= new LinkedList(List.of(4,5,6));
        System.out.println(la);
        
        LinkedList l5 = new LinkedList();
        l5=l1;
        System.out.println(l1);
        System.out.println("-------------------------------");
        l1.descendingIterator().forEachRemaining(System.out::print);
        l1.forEach(System.out::print);
        System.out.println();
        System.out.println("-------------------------------");
        
        int[] a=new int[] {12,32,16,45};
        int[] b=new int[] {12,8,16,44};
        int [] c = a;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        int[] d = a.clone();
        System.out.println(a.equals(d));
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        Arrays.asList(a);
       int r =Arrays.binarySearch(a, 32);
       System.out.println(r);
       System.out.println(Arrays.compare(a, b));
       int [] j = Arrays.copyOf(a, 7);
       //Arrays.fill(j,2,5, 66);
       Arrays.sort(j);
       for(int n:j)
       System.out.println(n);
       System.out.println(Arrays.equals(a,c));
       System.out.println(Arrays.mismatch(a, b));
       Arrays.stream(j).forEach(System.out::println);
       System.out.println("-------------------------------------------------------");
       
      
       
       
       
       
       
       
       
       
       
    }

	/*
	add(obj)- adds obj at the end
	add(collection)- adds collection at end
	add(index,obj/collection)- adds obj or collection at/from the indexed passed
	contains(obj)- return true if contains specific object
	element()- return first element
	equals(obj) returns true if both side values are equal even if they are diff instances.
	get(index)- returns element at index
	getFirst()- return element at first index
	getLast()- returns element at last index
	indexOf(obj)- return first ocurrance index
	lastIndexOf()- returns last ocurrance index
	descendingIterator()- iterates elements in desc order. use with forEachRemaining() ex-l1.descendingIterator().forEachRemaining(System.out::println);
	isEmpty()- returns false if not empty
	offer(obj)- return true after adding element passed at last
	offerFirst(obj)- returns true after adding element at first 
	offerLast(obj)- returns true after adding element at last
    peek()- retrieves but does not remove head (first element) of the queue if linkedLIst 3 is first element returns 3
	peekFirst()- retrieves but does not remove first element of the queue if linkedLIst 3 is first element returns 3
	peekLast()- retrieves but does not remove last element of the queue if linkedLIst 8 is first element returns 8
	poll()- retrieves but does not remove head (first element) of the queue if linkedLIst 3 is first element returns 3
	pollFirst()- retrieves but does not remove first element of the queue if linkedLIst 3 is first element returns 3
	pollLast()- retrieves but does not remove last element of the queue if linkedLIst 8 is first element returns 8
	push(obj)- inserts obj at begining
	remove()- removes and returns first element
	removeFirst()- removes and returns first element
	removeLast()- removes and returns last element
	remove(index)- removes and returns elementat specified index
	removefirstOccurrence()- removes and returns first occurrence element
	removeLastOccurrence()- removes and returns last occurrence of element
	reversed()- returns list of element in reversed order
	set(index,obj) toreplace ilement at index
	sublist(from indx, to index)- return sublist
	toArray()- return array of elements*/
	
	
	
//	---Arrays---
	
	//Arrays.
	//asList(array)- converts the array to new Arraylist internally
	//binarySearch( premitive type array, value)- return index of value in array else returns -1
	//compare(array 1, array 2)- return 0 if same elements in same order if array 1 has less elements return -1 if array 1 has more elements returns 1
	//copyOf(array , new length)- creates array from first one with new specified length adding or truncating with 0
	//equals(array1 , array 2)- compares equality of value
	//array1.equals(array 2)- compares memeory equality
	//fill(array, value)- replaces all elements of array with new value
	//fill(array, from indx, to index, value)- replaces elements with value for specified range (skipping to index)
	//mismatch(array 1, array 2)- return index of first mismatch element 
	//stream(array)- return stream of elements same as stream api output can be pipelined



}
