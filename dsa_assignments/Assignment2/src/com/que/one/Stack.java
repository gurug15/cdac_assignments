package com.que.one;

import com.que.one.exception.StackException;

public interface Stack {
	void push(int ele) throws StackException;
	int pop() throws StackException;
	int peek();
	boolean isEmpty();
	boolean isFull();
	int capacity();
	int size();
	
}
