package com.Question;

import java.util.LinkedList;

class Node {
    String key;
    String value;
    
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
//Hashtabel logic and create LinkedList
class HashTable {
    private int size;
    private LinkedList<Node>[] table;

    @SuppressWarnings("unchecked")
	public HashTable(int size) {
        this.size = size;
        table = (LinkedList<Node>[]) new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        return Math.abs(key.hashCode()) % size;
    }
    
    
    //to insert HashTable
    public void insert(String key, String value) {
        int index = hashFunction(key);
        LinkedList<Node> bucket = table[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; 
                return;
            }
        }

        bucket.add(new Node(key, value)); 
    }
    
    
    //to search in the key table
    public String search(String key) {
        int index = hashFunction(key);
        LinkedList<Node> bucket = table[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        
        return null; 
    }
    
    
    //to delete the key
    public boolean delete(String key) {
        int index = hashFunction(key);
        LinkedList<Node> bucket = table[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert("name", "Aditya");
        hashTable.insert("age", "23");

        System.out.println("Name in HashTable : " + hashTable.search("name"));
        System.out.println("Age before : " + hashTable.delete("age"));
        System.out.println("After deleting Age: " +hashTable.search("age"));
    }
}
