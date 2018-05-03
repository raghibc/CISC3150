package javaWork;

import java.io.*;
import java.util.Scanner;

public class DirTree
{
	   public static void main(String[] args) throws IOException {
	       Scanner sc = new Scanner(System.in);

	       System.out.print("Enter the path of the directory to start tree from:");
	       String path = sc.nextLine();
	       
	       travelPath(path, "");

	       sc.close();
	   }
	   
	   
	   
	   

	   public static void travelPath(String path, String str) throws IOException {

		   File rootFile = new File(path);
		   
		   if(!rootFile.exists()) {
			   System.out.println("Path does not exist. Try again.");
			   return;
		   }
		   
		   File[] children = rootFile.listFiles();
		   
	       FileWriter fw = new FileWriter("dir_tree.txt");
	       BufferedWriter bw = new BufferedWriter(fw);
	
	
	       
	       for (File myFile:children) {
	    	   
	           if (myFile.isDirectory() ) {
	        	   travelPath(myFile.getAbsolutePath(), "|");
	               bw.write(str + myFile.getAbsoluteFile());
	               bw.newLine();
	           }
	           else {
	               bw.write("|" + "_____" + myFile.getAbsoluteFile());
	               bw.newLine();
	           }
	       }
	
	       System.out.println("Written successfully");
	       bw.close();
	       fw.close();
	   }
}

