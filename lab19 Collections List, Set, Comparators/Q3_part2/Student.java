package part2;


public class Student {
	private int id;
	private String name;
	private String surname;
	
	public Student(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "\nID: " + id + ", Name=" + name + ", Surname=" + surname+"\n";
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

	
	
}
