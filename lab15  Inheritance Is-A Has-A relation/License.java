import java.util.Scanner;

public class License {
	
	// data members
	protected int id;
    protected String nameSurname;
    protected String institution;
    protected double fee;

    // no-arg constructor
    public License() {
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
    // member methods
    public boolean checkId(int id){
        return this.id == id;
    }

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name surname: ");
        nameSurname = sc.nextLine();
        System.out.print("Enter the institution: ");
        institution = sc.nextLine();
    }

    @Override
    public String toString() {
        return "\nId= " + id
                + "\nName Surname= " + nameSurname
                + "\nInstitution= " + institution
                + "\nFee= " + fee;
    }
}
