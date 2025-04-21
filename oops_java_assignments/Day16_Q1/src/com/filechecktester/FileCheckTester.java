package com.filechecktester;
import java.io.File;

import com.filecheck.FileCheck;

public class FileCheckTester {

	public static void main(String[] args) {
		File f = new File("D:/SupShi/JavaAssignments/Day6");
		FileCheck.fileCheck(f);
	}

}
