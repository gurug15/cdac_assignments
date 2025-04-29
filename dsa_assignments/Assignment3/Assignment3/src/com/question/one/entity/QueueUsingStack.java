package com.question.one.entity;

public class QueueUsingStack<T> implements Queue<T> {
	private ResizableStack<T> stack1;
	private ResizableStack<T> stack2;
	
	
	@Override
	public void enqueue(T element) throws Exception {
	}

	@Override
	public T dequeue() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
