package com.question.one.entity;

public interface List<T> {
	public void addFront(T element);
	public void addRear(T element);
	public T deleteRear();
	public T deletefront();
	boolean isEmpty();
	void print();
}
