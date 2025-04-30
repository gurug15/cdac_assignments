package com.question.one.entity;


class Node<T extends Comparable<T>> {
	T element;
	Node<T> next;
}


public class LinkedList<T extends Comparable<T>> implements List<T>{
	Node<T> head;
	Node<T> tail;
	
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	@Override
	public void addFront(T element) {
		Node<T> node = new Node<T>();
		node.element = element;
		node.next = head;
		head = node;
		
		if(tail == null) {
			tail = head;
		}
		
	}
	@Override
	public void addRear(T element) {
		Node<T> newNode = new Node<T>();
		newNode.element = element;
		newNode.next = null;
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		
		tail.next = newNode;
		tail = newNode;
		
	}
	@Override
	public T deleteRear()  {
		if(isEmpty()) {
			throw new RuntimeException("List is Empty");
		}
		 Node<T> temp = tail;
		 if (head == tail) {
		        head = tail = null;
		    } else {
		        Node<T> move = head;
		        while (move.next != tail) {
		            move = move.next;
		        }
		        move.next = null;
		        tail = move;
		    }		
		
	    return temp.element;
	}
	
	
	@Override
	public T deletefront() {
		if(isEmpty()) {
			throw new RuntimeException("List is Empty");
		}
		
		Node<T> temp = head;
		head = head.next;
		if(isEmpty()) {
			tail = head;
		}
		return temp.element;
	}
	@Override
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
	
	public void print() {
		Node<T> n = head;
		while(n != null) {
			System.out.print(n.element + " ");
			n = n.next;
		}
	}
	
	
	
}
