package com.question.one.entity;

public class QueueList<T extends Comparable<T>> extends LinkedList<T> implements Queue<T>{

	@Override
	public void enqueue(T element) throws Exception {
		addRear(element);
	}

	@Override
	public T dequeue() throws Exception {
		return deletefront();
	}
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

}
