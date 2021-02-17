/**
 * Mark Shonbeck and Joshua Bordick
 * 2/17/21
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private static String[] files = {"scores.txt", "badscore.txt", "nofile.txt" }; // Array of file names
	private ArrayList<Student> students = new ArrayList<Student>(); // contains all the students
	
	/**
	 * loads names and scores into students
	 * checks if file is correct format
	 * @throws FileNotFoundException handled in processFiles
	 */
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		students.clear();
		FileReader reader = new FileReader(fileName);
		Scanner readFile = new Scanner(reader);
		
		while(readFile.hasNextLine()) { 
			String name = readFile.nextLine();
			String line = readFile.nextLine();
			try {
				
				int score = Integer.parseInt(line);
				students.add(new Student(name, score));
			}
			catch(NumberFormatException e) {
				System.out.println();
				System.out.println("Incorect Formatting for " + name + " not a valid score: " + line);
				System.out.println();
			}

		}
		readFile.close();
	}
	
	/**
	 * sorts and prints the names and scores of the students
	 */
	public void printInOrder() {
		Collections.sort(students);
		for(Student i : students) {
			System.out.println(i.toString());
		}
	}
	
	/**
	 * loads data and prints the students for all the files
	 * Handles FileNotFoundException with an error message
	 */
	public void processFiles(String[] files)  {
		for(String i: files) {
			try {
				loadDataFromFile(i);
				printInOrder();
			}
			catch(FileNotFoundException e) {
				System.out.println();
				System.out.println("Cannot Open File: " + i);
				System.out.println();
			}
		
		}
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker test = new ScoreTrakker();
		test.processFiles(files);
	}

}
