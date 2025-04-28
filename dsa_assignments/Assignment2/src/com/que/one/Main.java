package com.que.one;

public class Main {

	public static void main(String[] args) {
		Stack stack = new ResizableStack();
		try {
			
			System.out.println("Capacity: " + stack.capacity() + " Size: "+ stack.size());
			stack.push(10);
			
			for(int i=0;i<9;i++) {
				stack.push(i*10);
			}
			System.out.println("Capacity: " + stack.capacity() + " Size: "+ stack.size());
			
			System.out.println(stack.peek());
			stack.push(210);
			System.out.println("Capacity: " + stack.capacity() + " Size: "+ stack.size());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

}
