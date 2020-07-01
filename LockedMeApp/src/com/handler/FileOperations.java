package com.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileOperations {
	
	ArrayList<File> fl = new ArrayList<File>();

	public void addFile(String path) {
		
		try {
			File file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
				try {
				fl.add(file);
				}catch(NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println("New file added");
				}
			else {
				System.out.println("File already exists");
			}
		}
		catch(IOException ie) {
			System.out.println(ie);
		}
	}
	
	public void deleteFile(String path) {
		
		File file = new File(path);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("File deleted");
				try {
				int pos = fl.indexOf(file);
				fl.remove(pos);
				}catch(ArrayIndexOutOfBoundsException ae) {
					ae.printStackTrace();
				}
			}
		}else {
			System.out.println("File not found");
		}
	}
	
	public void searchFile(String path) {
		File file = new File(path);
		if(fl.contains(file)) {
			System.out.println("File found successfully");
		}
		else {
			System.out.println("File not found");
		}

}
	public void displayListOfFiles(File dir) {
		
		fl = new ArrayList<File>(Arrays.asList(dir.listFiles()));
		System.out.println(fl);
	}

}
