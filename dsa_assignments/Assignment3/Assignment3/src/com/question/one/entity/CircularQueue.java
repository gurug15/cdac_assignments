package com.question.one.entity;

public class CircularQueue<T> implements Queue<T> {
	private static int count = 1;
	private int size = 10;
	private T[] queue;
	private int front;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public CircularQueue() {
		queue =  (T[]) new Object[size];
		front = -1;
		rear = -1;
	}
	
	
	@Override
	public void enqueue(T element) throws Exception {
		if(isFull()|| count>=queue.length) {
			throw new Exception("Queue is full");
		}
		rear = (rear + 1)% size;
		queue[rear] = element;
		count++;
	}

	@Override
	public T dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		front = (front +1)%size;
		count--;
		return queue[front];
		
	}

	@Override
	public boolean isEmpty() {
		if(front == rear) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		
		if(front == (rear+1)%queue.length) {
			return true;
		}
		
		return false;
	}

}

