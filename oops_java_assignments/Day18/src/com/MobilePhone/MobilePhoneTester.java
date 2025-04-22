package com.MobilePhone;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MobilePhoneTester {

	public static void main(String[] args) {
		
		List<MobilePhone> mobilePhones  = new ArrayList<>();
		
		Scanner in = new Scanner (System.in);
		
		
		   mobilePhones.add(new MobilePhone(101, "Samsung", "Android", "Black", 25000.0, 6));
	        mobilePhones.add(new MobilePhone(102, "OnePlus", "Android", "Blue", 30000.0, 8));
	        mobilePhones.add(new MobilePhone(103, "Xiaomi", "Android", "Red", 15000.0, 4));

	        // Adding iOS mobile phones
	        mobilePhones.add(new MobilePhone(201, "Apple", "iOS", "White", 70000.0, 6));
	        mobilePhones.add(new MobilePhone(202, "Apple", "iOS", "Red", 85000.0, 8));
	        
	        
	        Map<Boolean,List<MobilePhone>>  mobile = mobilePhones.stream().
	        		collect(Collectors.partitioningBy(s->s.getOs().equals("iOS")));
	        	mobile.forEach((key,value)->System.out.println("Key: "+(!key?"Android":"iOS")+" Value: "+ value));
	        
//	        List<MobilePhone>  sortedMobiles = mobilePhones.stream()
//	        		.sorted(Comparator.comparing(MobilePhone::getColor).thenComparing(MobilePhone::getRam))
//	        		.collect(Collectors.toList());
//	        System.out.println(sortedMobiles);
	        //By using Lambda
	        mobilePhones.stream()
    		.sorted(Comparator.comparing(MobilePhone::getColor).thenComparing(MobilePhone::getRam))
    		.forEach(s->System.out.println(s));
	        //Storing List into Set
	        Set<MobilePhone>  MobilesSet= mobilePhones.stream()
	        		.sorted(Comparator.comparing(MobilePhone::getColor).thenComparing(MobilePhone::getRam))
	        		.collect(Collectors.toSet());
	        System.out.println("____________________________________");
	        mobilePhones.stream()
	        .filter(s->s.getOs().equals("iOS"))
	        .forEach(System.out::println);
	        System.out.println("____________________________________");
	        mobilePhones.stream()
	        .filter(s->s.getPrice()>=30000)
	        .forEach(System.out::println);
	        System.out.println("____________________________________");
	        mobilePhones.stream()
	        .filter(s->s.getColor().equals("Red"))
	        .forEach(System.out::println);
	}

}
