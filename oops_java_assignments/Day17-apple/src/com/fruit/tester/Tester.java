package com.fruit.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fruit.Apple;
import com.fruit.util.DataUtil;

public class Tester {

	public static void main(String[] args) {
			List<Apple> appleList = DataUtil.addApples();
			
			System.out.println("Filer by weight");
			appleList.stream().filter(a->a.getWeight()>=150).forEach(System.out::println);
			System.out.println("Filer by color");
			appleList.stream().filter(a->a.getColor().equals("Red")).forEach(System.out::println);
			Predicate<Apple> colorFilter = a->a.getColor().equalsIgnoreCase("green");
			Predicate<Apple> weightFilter = a->a.getWeight()>170;
			System.out.println("______________________________________");
			appleList.stream().filter(colorFilter.and(weightFilter)).forEach(System.out::println);
			System.out.println("______________________________________");
			Collections.sort(appleList, Comparator.naturalOrder());
			System.out.println("______________________________________");
			Collections.sort(appleList,(a,b)->a.getColor().compareTo(b.getColor()));
			appleList.forEach(System.out::println);
			Collections.sort(appleList,Comparator.comparing(Apple::getColor));
			appleList.forEach(System.out::println);
			System.out.println("______________________________________");
			appleList.stream().filter(s->s.getColor().equalsIgnoreCase("red")).forEach(System.out::println);
			System.out.println("______________________________________");
			appleList.stream().filter(s->s.getColor().equalsIgnoreCase("green")).forEach(System.out::println);
			System.out.println("______________________________________");
			System.out.println(appleList.size());
			Set<Apple> appleSet = appleList.stream().collect(Collectors.toSet());
			System.out.println(appleSet.size());
			appleSet.forEach(System.out::println);
			
			
			
	}

}
