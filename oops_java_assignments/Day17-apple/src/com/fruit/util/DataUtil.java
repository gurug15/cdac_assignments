package com.fruit.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fruit.Apple;

public class DataUtil {

	public static List<Apple> addApples(){
		List<Apple> apples = new LinkedList<>();

        apples.add(new Apple(150.5, 10, "Red", "Sweet"));
        apples.add(new Apple(120.0, 5, "Green", "Tart"));
        apples.add(new Apple(200.0, 8, "Yellow", "Sweet"));
        apples.add(new Apple(130.3, 12, "Red", "Mild"));
        apples.add(new Apple(180.0, 7, "Green", "Sour"));
        apples.add(new Apple(170.2, 9, "Yellow", "Sweet"));
        apples.add(new Apple(145.6, 4, "Red", "Crisp"));
        apples.add(new Apple(155.0, 6, "Green", "Tart"));
        apples.add(new Apple(190.4, 10, "Yellow", "Juicy"));
        apples.add(new Apple(160.7, 15, "Red", "Sweet"));
        apples.add(new Apple(140.0, 3, "Green", "Sour"));
        apples.add(new Apple(210.1, 11, "Yellow", "Smooth"));
        apples.add(new Apple(175.3, 7, "Red", "Juicy"));
        apples.add(new Apple(165.5, 9, "Green", "Mild"));
        apples.add(new Apple(185.0, 6, "Yellow", "Sweet"));
        apples.add(new Apple(125.2, 13, "Red", "Tart"));
        apples.add(new Apple(135.4, 8, "Green", "Sweet"));
        apples.add(new Apple(195.6, 5, "Yellow", "Crisp"));
        apples.add(new Apple(220.0, 4, "Red", "Bold"));
        apples.add(new Apple(205.8, 10, "Green", "Mellow"));
        apples.add(new Apple(145.6, 4, "Red", "Crisp"));
        apples.add(new Apple(155.0, 6, "Green", "Tart"));
        apples.add(new Apple(190.4, 10, "Yellow", "Juicy"));
        apples.add(new Apple(160.7, 15, "Red", "Sweet"));
        apples.add(new Apple(140.0, 3, "Green", "Sour"));
        apples.add(new Apple(210.1, 11, "Yellow", "Smooth"));
        apples.add(new Apple(175.3, 7, "Red", "Juicy"));
	
	
	return apples;
	}
}
