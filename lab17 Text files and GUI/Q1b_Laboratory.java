
public class Laboratory {

	// data members
	private String labName;
    private int size;
    private int renewYear;
    private String labMaintainer;

    // constructor
    public Laboratory(String labName, int size, int renewYear, String labMaintainer) {
        this.labName = labName;
        this.size = size;
        this.renewYear = renewYear;
        this.labMaintainer = labMaintainer;
    }

    // getter
    public String getLabName() {
        return labName;
    }

    // member methods
    public boolean findLabName(String name) {
        if (labName.equalsIgnoreCase(name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nLaboratory"
                + "\nLab Name= " + labName
                + "\nSize= " + size
                + "\nRenew Year= " + renewYear
                + "\nLab Maintainer= " + labMaintainer;
    }
	
}
