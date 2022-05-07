package com.company.lockers;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
    static final String projectPath = "D:\\Gayathri\\SimpliLearnWorkspace\\CompanyLockersProject\\LockedMeFiles";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		int ch;
		do {
	        displayMenu();
	        System.out.println("Enter your choice : ");
	        ch = Integer.parseInt(obj.nextLine());
	        
	        switch(ch) {
	        case 1: getAllFiles();
	        	
	        	break;
	        case 2: createFiles();
	        	
	        	break;
	        case 3: deleteFiles();
	        	
	        	break;
	        case 4: searchFiles();
	        	
	        	break;
	        case 5: System.exit(0);
	        	break;
	        default: System.out.println("Invalid Option");
	        	break;
	        	
	        }
	       // obj.next();
	}while(ch>0);
        
	}
	
	// display menu method
	public static void displayMenu() {
		System.out.println("***********************************************");
		System.out.println("\tWelcome to CompanyLockers - LockedMe.com");
		System.out.println("\tDeveloper Name : Gayathri R");
		System.out.println("***********************************************");
		System.out.println("\t1. Display all the files");
		System.out.println("\t2. Add files to existing directory");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search a file");
		System.out.println("\t5. Exit");
		System.out.println("***********************************************");
		
		
	}
	
	//get All files
	public static void getAllFiles() {
		File[] listOfFiles = new File(projectPath).listFiles();
		if(listOfFiles.length == 0) {
			System.out.println("No Files exist in the directory");
		}else {
			for(var l : listOfFiles) {
				System.out.println(l.getName());
			}
		}
	}
	
	// create Files
	public static void createFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			int linesCount;
						
			System.out.println("Enter file name : ");
			fileName = obj.nextLine();
			
			System.out.println("Enter how many lines you want to add in file? : ");
			linesCount = Integer.parseInt(obj.nextLine());
			
			FileWriter fw = new FileWriter(projectPath+"\\"+fileName);
			for(int i = 1; i<=linesCount;i++) {
				System.out.println("Enter file content line :");
				fw.write(obj.nextLine()+"\n");
			}
			System.out.println("File created successfully");
			fw.close();
		}catch (Exception e) {
			System.out.println("Some error occured");
		}
	}

	// delete files
	public static void deleteFiles() {
		Scanner obj = new Scanner(System.in);
		try {
			String fileName;
			System.out.println("Enter file name to be deleted : ");
			fileName = obj.nextLine();
			
			File f1 = new File(projectPath+"\\"+fileName);
			if(f1.exists()) {
				f1.delete();
				System.out.println("File deleted successfully");
			}else {
				System.out.println("File not exist");
			}
		}catch (Exception e) {
			System.out.println("Some error occured ");
		}
	}
	
	//
	public static void searchFiles() {
		Scanner obj = new Scanner(System.in);
		try {
			LinkedList<String> fileNames = new LinkedList<String>();
			String fileName;
			System.out.println("Enter the file name to be searched : ");
			fileName = obj.nextLine();
			 
			File[] listOfFiles = new File(projectPath).listFiles(); 
			for(var l : listOfFiles) {
				fileNames.add(l.getName());
			}
			if(fileNames.contains(fileName)) 
				System.out.println("File is available");
			else
				System.out.println("File is not availble");
			
		}catch (Exception e) {
			
		}
	}
	
	//
}
