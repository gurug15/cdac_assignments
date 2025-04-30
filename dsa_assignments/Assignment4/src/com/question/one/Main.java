package com.question.one;

import com.question.one.entity.LinkedList;
import com.question.one.entity.List;
import com.question.one.entity.Queue;
import com.question.one.entity.QueueList;

public class Main {

	public static void main(String[] args) {
		List<Integer> list  = new LinkedList<Integer>();
		list.addFront(10);
		list.addFront(20);
		list.addFront(30);
		list.addRear(100);
		list.addRear(100);
		list.print();
		System.out.println("\n" +list.deletefront());
		System.err.println(list.deleteRear());
		list.print();
		System.out.println("\n///////////////////////////////////////");
		Queue<Integer> queue = new QueueList<Integer>();
		try{
		 for(int i=0;i<10;i++) {
			queue.enqueue(10+i);
			System.out.print(10+i + " ");
		 }
		 System.out.println();
		 while(!queue.isEmpty()) {
			 System.out.print(" "+queue.dequeue());
		 }
		 
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
