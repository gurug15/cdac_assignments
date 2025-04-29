package com.question.one.entity;



public class ResizableStack<T> implements Stack<T>  {
	private int size =10;
	private T arr[];
	private int top;
	
	@SuppressWarnings("unchecked")
	public ResizableStack() {
		arr = (T[])new Object[size];
		top = -1;
	}
	
	@SuppressWarnings("unchecked")
	public T[] resizeArr() {
		int prevSize = size;
		size = size*2;
		T newArr[] = (T[])new Object[size];
		for(int i=0;i<prevSize;i++) {
			newArr[i] = arr[i];
		}
			
		return newArr;
	}
	
	@Override
	public void push(T ele) throws Exception {
		 if (top >= 9 * size / 10) {
		        arr = resizeArr();
		    }
		    if (top >= size - 1) {
		        throw new Exception("Stack is full, even after resizing");
		    }
		    arr[++top] = ele;
	}

	@Override
	public T pop() throws Exception {
		
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		
		return arr[top--];
	}

	@Override
	public T peek() {
		
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
