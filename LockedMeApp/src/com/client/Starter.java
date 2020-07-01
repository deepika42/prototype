package com.client;

import java.io.File;
import java.util.Scanner;

import com.handler.FileOperations;

public class Starter {
	
	static int option1 ,  option2;
	public static void main(String[] args) {
		
		FileOperations fo = new FileOperations();
		
		Scanner sc = new Scanner(System.in);
		String directoyName = "";
		String fileName = "";
		File dir;
		
		
			do {
				System.out.println("Create your directory");
				directoyName = sc.nextLine();
				dir = new File(directoyName);
				
				if(!dir.exists()) {
					if(dir.mkdir()) {
						System.out.println("Directory created\n");
						break;
					}
					else {
						System.out.println("Directory creation failed...try again\n");			
						}
					
				}else {
					System.out.println("Directory already exists\n");
				}
			
			}while(!dir.mkdir());

			
			do {			
				System.out.println("\tApplication : LockedMe.com");
				System.out.println("\tDeveloper Name : Deepika Naik\n");
				System.out.println("********************************************************************************");
				System.out.println("1.Retrieve files from the directory");
				System.out.println("2.User Actions");
				System.out.println("----1. Add a file");
				System.out.println("----2. Delete a file");
				System.out.println("----3. Search a file");
				System.out.println("----4. Back");
				System.out.println("3 . Close the application\n");
				System.out.println("********************************************************************************");

				
				try {
				System.out.print("Enter an option :\t");
				option1 = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException ne) {
					ne.printStackTrace();
				}
				
					switch (option1) {
					case 1:
						System.out.print("Files in current directory are :\t");
						fo.displayListOfFiles(dir);
						System.out.println("\n");
						break;
					case 2:
						do {
							System.out.println("1. Add a file");
							System.out.println("2. Delete a file");
							System.out.println("3. Search a file");
							System.out.println("4. Back");
							
							try {
							System.out.print("Enter your choice\t");
							option2 = Integer.parseInt(sc.nextLine());
							}catch(NumberFormatException ne) {
								ne.printStackTrace();
							}
							switch (option2) {
							case 1:
								System.out.print("Enter the file to be created\t ");
								fileName = sc.nextLine();
								fo.addFile(dir+"\\"+fileName);
								System.out.println("\n");
								break;
							case 2:
								System.out.print("Enter the file to be deleted\t ");
								fileName = sc.nextLine();
								fo.deleteFile(dir+"\\"+fileName);
								System.out.println("\n");
								break;
							case 3:
								System.out.print("Enter the file to be searched\t ");
								fileName = sc.nextLine();
								fo.searchFile(dir+"\\"+fileName);
								System.out.println("\n");
								break;
							case 4:
								break;
							default:
								System.out.println("Invalid input...Please enter again");
							}
						}while(option2!=4);
						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.out.println("Enter a valid option");
				}
							
			}while(option1!=3);
			
			

	}

}
