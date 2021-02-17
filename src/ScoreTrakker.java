import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private static String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	private ArrayList<Student> students = new ArrayList<Student>();
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
	}
	public void printInOrder() {
		Collections.sort(students);
		for(Student i : students) {
			System.out.println(i.toString());
		}
	}
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
