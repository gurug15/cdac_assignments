package com.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.entity.Person;

public class CollectionConversion {
	
	private CollectionConversion() {}
	
	public static Set<Person> listToSet(List<Person> persons) {
		return persons.stream().collect(Collectors.toSet());
	}
	
	public static Map<Long,Person> listToMap(List<Person> persons) {
		return persons.stream().collect(Collectors.toMap(s->s.getId(),s->s));
	}

}
