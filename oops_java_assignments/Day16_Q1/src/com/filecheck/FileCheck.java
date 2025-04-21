package com.filecheck;

import java.io.File;

public class FileCheck {

	public static void fileCheck(File file) {
		String[] paths;
		
		try {
		if (file.exists()) {
			if (file.isDirectory()||file.isFile()) {
				paths = file.list();
				for (String path : paths) {
					System.out.println(path);
				}
			}
			else {
				System.out.println("The specified path is neither a file nor a directory.");
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
