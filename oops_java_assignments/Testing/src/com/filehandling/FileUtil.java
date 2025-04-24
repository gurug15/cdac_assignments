package com.filehandling;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.entity.Person;
import com.utils.DateUtils;
import com.validation.DateRelatedException;

public class FileUtil {
	private static final String textFile = "C:/Users/gurug/OneDrive/Desktop/Java-Workspaace/PersonLogs.txt";
	private static final String binaryFile = "C:/Users/gurug/OneDrive/Desktop/Java-Workspaace/Persons.dat";
	
	private FileUtil() {}
	
	public static void writeLogs(String message) {
		File file  = new File(textFile);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
			bw.write(message+ " "+DateUtils.timeStamp());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (DateRelatedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void writeBData(List<Person> persons) {
		File file  = new File(binaryFile);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,true))){
			for(Person person: persons) {
				oos.writeObject(person);
			}
			System.out.println("__Written to  person.dat__");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Person> readBData() throws ClassNotFoundException {
		File file  = new File(binaryFile);
		List<Person>persons =  new ArrayList<Person>();
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(file))){
			
			while(true) {
				try {
					Person p = (Person)ois.readObject();
					persons.add(p);
				} catch(ClassNotFoundException e) {
					throw e;
				}
				catch (EOFException e) {
					break;
				}
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return persons;
	}
	
}
