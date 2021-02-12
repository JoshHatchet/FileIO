
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
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
