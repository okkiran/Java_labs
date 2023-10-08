
public class HospitalMember {
	
	// data members
	private int id;
	private String nameSurname;
	private String dept;

	// constructor
	public HospitalMember(int id, String nameSurname, String dept) {
		this.id = id;
		this.nameSurname = nameSurname;
		this.dept = dept;		
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	// member methods
	public boolean findId(int id) {
		return this.id == id;
	}

	// overriding toString method of the Object class to get the modified string
	@Override
	public String toString() {
		return "Hospital Member" + "\nId= " + id
			+ "\nName Surname= " + nameSurname
			+ "\nDept= " + dept;
	}
}
