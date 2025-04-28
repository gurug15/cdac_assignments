package com.que.one;

import com.que.one.exception.StackException;

public class ResizableStack implements Stack  {
	private int size =10;
	private int arr[];
	private int top;
	
	public ResizableStack() {
		//int size = 10;
		arr = new int[size];
		top = -1;
	}
	
	public int[] resizeArr() {
		int prevSize = size;
		size = size*2;
		int newArr[] = new int[size];
		for(int i=0;i<prevSize;i++) {
			newArr[i] = arr[i];
		}
			
		return newArr;
	}
	
	@Override
	public void push(int ele) throws StackException {
		 if (top >= 9 * size / 10) {
		        arr = resizeArr();
		    }
		    if (top >= size - 1) {
		        throw new StackException("Stack is full, even after resizing");
		    }
		    arr[++top] = ele;
	}

	@Override
	public int pop() throws StackException {
		
		if(isEmpty()) {
			throw new StackException("Stack is Empty");
		}
		
		return arr[top--];
	}

	@Override
	public int peek() {
		
		return arr[top];
	}

	@Override
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(top == arr.length -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public int capacity() {
		return size;
	}
	
	@Override
	public int size() {
		return top;
	}

}
