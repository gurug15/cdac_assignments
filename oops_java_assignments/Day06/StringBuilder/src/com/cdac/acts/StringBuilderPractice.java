package com.cdac.acts;

public class StringBuilderPractice {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder("Hello");
        //1
        sb.append(" World!");
        System.out.println("After append: " + sb);
        //2
        sb.insert(5, ", Beautiful");
        System.out.println("After insert: " + sb);
        //3
        sb.replace(7, 16, "Amazing");
        System.out.println("After replace: " + sb);
        //4
        sb.delete(5, 13);
        System.out.println("After delete: " + sb);
        //5
        sb.reverse();
        System.out.println("After reverse: " + sb);
        //6
        System.out.println("Current capacity: " + sb.capacity());
        //7
        sb.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity: " + sb.capacity());
        //8
        System.out.println("Length of StringBuilder: " + sb.length());
        //9
        char ch = sb.charAt(4);
        System.out.println("Character at index 4: " + ch);
        //10
        sb.setCharAt(4, 'X');
        System.out.println("After setCharAt: " + sb);
       //11
        String sub = sb.substring(2, 8);
        System.out.println("Substring from index 2 to 8: " + sub);
        //12
        int index = sb.indexOf("World");
        System.out.println("Index of 'World': " + index);
        //13
        int lastIndex = sb.lastIndexOf("o");
        System.out.println("Last index of 'o': " + lastIndex);
        //14
        sb.deleteCharAt(3);
        System.out.println("After deleteCharAt(3): " + sb);
        
        String finalString = sb.toString();
        System.out.println("Converted to String: " + finalString);
    }
}
