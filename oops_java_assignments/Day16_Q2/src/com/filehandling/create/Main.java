package com.filehandling.create;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	
	public static void ReadingFile(String filePath)
	{
		System.out.println("Reading From File");
		try (
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr))
		
		{
				
			String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		//File file = new File("D:/one.txt");
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter bw = new PrintWriter(new FileWriter("D:/pqr.txt",true));){
//			if(!file.exists()) {
//				file.createNewFile();
//				System.out.println("Fil created");
//			}
			String data;
			System.out.println("Writing from file");
			System.out.println("Please enter text:");
			data = br.readLine();
			while(!data.equals("exit")) {
				bw.println(data);
				System.out.println("Please enter text:");
				data = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		ReadingFile("D:/pqr.txt");
	}
}
