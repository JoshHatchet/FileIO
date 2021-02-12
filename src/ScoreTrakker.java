import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner readFile = new Scanner(reader);
		while(readFile.hasNextLine()) { 
			String name = readFile.nextLine();
			int score = Integer.parseInt(readFile.nextLine());
			students.add(new Student(name, score));
		}
	}
	public void printInOrder() {
		Collections.sort(students);
		for(Student i : students) {
			System.out.println(i.toString());
		}
	}
	public void processFiles(String inFile) throws FileNotFoundException {
		loadDataFromFile(inFile);
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter a File Name: ");
		String inputFile = scanner.next();
		ScoreTrakker test = new ScoreTrakker();
		test.processFiles(inputFile);
	}

}
