/**
 * Mark Shonbeck and Joshua Bordick
 * 2/17/21
 */
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	/**
	 * Constructs student from a name and a score
	 */
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Compares the students based on score
	 * returns -1 if this student is less 
	 * returns 0 if the students are equal
	 * returns 1 if this student is greater
	 */
	@Override
	public int compareTo(Student student) {
		if(score < student.score) {
			return -1;
		} else if (score == student.score){
			return 0;
		} else {
			return 1;
		}
	}
	@Override
	public String toString() {
		return name + " " + score;
	}
	
}
