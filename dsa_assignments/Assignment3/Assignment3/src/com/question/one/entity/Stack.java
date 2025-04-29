package com.question.one.entity;


public interface Stack<T> {
	void push(T ele) throws Exception;
	T pop() throws Exception;
	T peek();
	boolean isEmpty();
	boolean isFull();
	int capacity();
	int size();
	
}
