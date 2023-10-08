package part5;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
	
		return stu2.getName().compareTo(stu1.getName()); //DESCENDING SORT
	}
}
