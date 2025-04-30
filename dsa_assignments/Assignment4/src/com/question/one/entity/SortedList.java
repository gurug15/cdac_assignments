package com.question.one.entity;



public class SortedList<T extends Comparable<T>>{
	Node<T> head;
	Node<T> tail;
	
	
	public SortedList(){
		head = null;
		tail = null;
	}
	
	public void insert(T element) {
		Node<T> newNode = new Node<T>();
		newNode.element = element;
		newNode.next = null;
		if(isEmpty()) {
			head = newNode;
			return;
		}
		
		Node<T> current = head;
		Node<T> previous = null;
		while(current != null) {
			if(current.element.compareTo(element)>0) {
				break;
			}
			previous = current;
			current = current.next;
		}
		
		if(previous == null) {
			newNode.next = head;
			head = newNode;
			return;	
		}
		
		previous.next = newNode;
		newNode.next = current;
	}
	
	public void delete(T element) {
		
		if(isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		
		Node<T> current = head;
		Node<T> previous = null;
		while(current != null) {
			if(current.element.equals(element)) {
				break;
			}
			previous = current;
			current = current.next;
		}
		
		if(current == null) {
			return;
		}
		
		if(previous == null) {
			head = head.next;
			return;
		}
		
		previous.next = current.next;
		current = null;
	}
	
	
	
	
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