package com.question.one;

import com.question.one.entity.CircularQueue;
//import com.question.one.entity.FixedQueue;
import com.question.one.entity.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> ueue = new CircularQueue<Integer>();
		try {
			ueue.enqueue(1);
			ueue.enqueue(3);
			ueue.enqueue(5);
			ueue.enqueue(4);
			ueue.enqueue(2);
			ueue.enqueue(10);

			ueue.enqueue(4);
			ueue.enqueue(2);
			ueue.enqueue(10);

			while(true) {
				System.out.println(ueue.dequeue());
			}
//			System.out.println(ueue.dequeue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
