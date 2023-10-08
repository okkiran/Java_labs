import java.util.ArrayList;

public class HospitalMemberSys {

	// data member
	private static ArrayList<HospitalMember> hm = new ArrayList<>();

	// member methods
	public static boolean checkId(int id) {

		for (int i = 0; i < hm.size(); i++) { // size() method returns the array list's elements count
			if (hm.get(i).findId(id)) { // get() method returns the element at the index used as parameter
				return false; // id already exists
			}
		}
		return true; // there is no element with the id parameter so it can be added to the array
					 // list
	}

	public static boolean addHospitalMember(int id, String nameSurname, String dept) {

		// variable declaration
		HospitalMember hospitalMember;

		// if there is no element in the array list with the id parameter, add the object of type HospitalMember
		// to the array list and return true
		if (checkId(id)) {
			hospitalMember = new HospitalMember(id, nameSurname, dept);
			hm.add(hospitalMember);
			return true;
		}

		return false; // if there is an element in the array list with the id parameter, return false
	}

	public static String display() {

		String result = "";
		for (HospitalMember hospitalMember : hm) {
			result += hospitalMember.toString() + "\n\n";
		}
		return result;

	}

	public static ArrayList<HospitalMember> getHm() {
		return hm;
	}

}
