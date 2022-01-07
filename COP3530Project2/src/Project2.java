import java.io.*;

import java.nio.file.*;
import java.util.*;

/**
* COP 3530: Project 2 – Binary Search Trees
* 
* This class uses the Binary Search Tree class to create a tree with the countries2.csv file provided.
* This class uses each of the different methods in the binary search tree to manipulate the csv file and test
* out the different methods.
*
* @author Noah Dancu
* @version 7/19/20
*/
public class Project2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("COP3530 Project 2 - Xudong Liu \n\nBinary Search Trees"
				+ "\n\nEnter the file name: Countries2.csv\n");
	 
        BinarySearchTree binary = new BinarySearchTree();
		
        File Countries = new File("countries2.csv");
		String line;

		//reader.readLine();
		
		List<String> lines = Files.readAllLines(Countries.toPath());
		
		int i;
        for (i = 1; i < lines.size(); i++) 
        {
            line = lines.get(i);

            String[] country = line.split(",");

            double gdp = Double.parseDouble(country[4]) / Double.parseDouble(country[3]);
            binary.insert(country[0], gdp);
        }
        
        
        System.out.println("\nInorder Traversal: ");
        System.out.println("Name\t\t\tGDP Per Capita\n"
        		+ "-------------------------------------");
        binary.printInorder();
        System.out.println();
        
        binary.delete("Australia");
        binary.delete("Czech Republic");
        binary.delete("Norway");
        
        System.out.println("\nPreorder Traversal: ");
        System.out.println("Name\t\t\tGDP Per Capita\n"
        		+ "-------------------------------------");
        binary.printPreorder();
        
        System.out.println();
        
        binary.find("Sri Lanka");
        binary.find("North Cyprus");
        binary.find("Czech Republic");
        binary.find("Norway");
        
        binary.delete("Malawi");
        binary.delete("Somalia");
        binary.delete("Canada");
        binary.delete("Tunisia");
        binary.delete("New  Zealand");
        
        System.out.println("\nPostorder Traversal: ");
        System.out.println("Name\t\t\tGDP Per Capita\n"
        		+ "-------------------------------------");
        binary.printPostorder();
        
        System.out.println("\nBottom ten countries regarding GDP Per Capita: ");
        System.out.println("Name\t\t\tGDP Per Capita\n"
        		+ "-------------------------------------");
        binary.printBottomTen();
        
        System.out.println("\nTop ten countries regarding GDP Per Capita: ");
        System.out.println("Name\t\t\tGDP Per Capita\n"
        		+ "-------------------------------------");
        binary.printTopTen();
	}

}
