package com.question.one.entity;

public class FixedQueue<T> implements Queue<T> {
	private T[] queue;
	private int front;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public FixedQueue(int size) {
		queue =  (T[]) new Object[size];
		front = -1;
		rear = -1;
	}
	//if the queue is full then we caN IMPLEMENT  like shifting the element to right whne dequing whch cause more operatoin that is leanear comlexity;
	
	//else we can do is check both isEmpty and isFull condition for it
	@Override
	public void enqueue(T element) throws Exception {
		
		if(isFull() && isEmpty()) {
			front = -1;
			rear = -1;
		}
		
		if(isFull()) {
			throw new Exception("Queue is full");
		}
		++rear;
		queue[rear] = element;
	}

	@Override
	public T dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return queue[++front];
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
		
		if(rear == (queue.length-1)) {
			return true;
		}
		
		return false;
	}

}
