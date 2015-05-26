import java.util.ArrayList;

/**
 * This class is the data manager of all three packages.  
 * @author Juan Lopez
 */
public class Packages implements PackagesInterface {
	
	private double cost;
	ArrayList<Comparable> packages;
	
	/**
	 * Constructor.  Initializes a Arraylist of Comparable objects
	 */
	public Packages() {
		packages = new ArrayList<Comparable>();
	}

	/**
	 * Adds a package object to the ArrayList of Comparable
	 * Used for testing
	 * @param p the package to be added to the ArrayList
	 */
	public void addPackage(Package p) {
		packages.add(p);
	}
	
	/**
     * Creates a package object and adds it to the ArrayList of Comparable
     * @param type type of package: firstClass, express, overnight
     * @param toLn Last Name of receiver of package
     * @param toFn First Name of receiver of package
     * @param toStr Street Address of receiver of package
     * @param toC City of of receiver of package
     * @param toSt State of receiver of package
     * @param toZ Zipcode of receiver of package
     * @param fromLn Last Name of sender of package
     * @param fromFn First Name of sender of package
     * @param fromStr Street Address of sender of package
     * @param fromC City of sender of package
     * @param fromSt State of sender of package
     * @param fromZ Zipcode of sender of package
     * @param wt weight of package
     * @param zone zone of package
     * @return the ship cost of the package
     */
	public double addPackage(String type, String toLn, String toFn,
			String toStr, String toC, String toSt, int toZ, String fromLn,
			String fromFn, String fromStr, String fromC, String fromSt,
			int fromZ, double wt, int zone) {
		
		if (type.equals("overnight")) {
			OvernightPackage ov = new OvernightPackage(type, toLn, toFn, toStr, toC, toSt, toZ, fromLn, fromFn, fromStr, fromC, fromSt, fromZ, wt, zone);
			packages.add(ov);
			cost = ov.calulateShippingCosts();
		} else if (type.equals("firstClass")) {
			FirstClassPackage fc = new FirstClassPackage(type, toLn, toFn, toStr, toC, toSt, toZ, fromLn, fromFn, fromStr, fromC, fromSt, fromZ, wt, zone);
			packages.add(fc);
			cost = fc.calulateShippingCosts();
		} else if (type.equals("express")) {
			ExpressPackage ex = new ExpressPackage(type, toLn, toFn, toStr, toC, toSt, toZ, fromLn, fromFn, fromStr, fromC, fromSt, fromZ, wt, zone);
			packages.add(ex);
			cost = ex.calulateShippingCosts();
		}		
		return cost;
	}

	/**
     * Creates the To and From Labels for all the packages in the ArrayList
     * @return a String with the To and From Labels of all packages
     * 			in the ArrayList.  Each label is separated by 2 blank lines
     * Mailing Labels will be in the following format for each package in ArrayList:
     * <p>Labels
     * <p>(blank line)
     * <p>TO:(space)FirstName(space)LastName
     * <p>(spaces)StreetAddress
     * <p>(spaces)City(comma)(space)State(spaces)ZipCode
     * <p>(blank line)
     * <p>(blank line)
     * <p>Example:
     * <p>Labels
     * <p>(blank line)
     * <p>TO: John Smith
     * <p>    22 Oak St.
     * <p>    Gaithersburg, MD  20879
     * <p>(blank line)
     * <p>(blank line)
     * <p>FROM: Mable Marble
     * <p>      45 Elm Ave.
     * <p>      Somewhere, MN  55443
     * <p>(blank line)
     * <p>(blank line)
     */
	public String printMailingLabels() {
		String toFromString = "";
		for (int x = 0; x < packages.size(); x++) {
			toFromString += packages.get(x).toString();
		}
		
		return "Labels \n\n" + toFromString;
	}

	/**
     * Creates a delivery Schedule for all packages in the ArrayList
     * sorted by ZipCode of receiver of package
     * @return a String with the all the Packages in the ArrayList
     * 			sorted by ZipCode and displaying the first and last
     * 			name of the receiver of the package
     * <p>Delivery schedule will be in the following format:
     * <p>Delivery Schedule
     * <p>(blank line)
     * <p>ZipCode(space)LastName(comma)(space)FirstName
     * <p>Example:
     * <p>Delivery Schedule
     * <p>(blank line)
     * <p>20874 Johnson, Bob
     * <p>20879 Smith, John
     */
	public String printDeliverySchedule() {
		SortUtility.selectionSort(packages);
		String toZipString = "";
		Package currPack;
		for (int x = 0; x < packages.size(); x++) {
			currPack = (Package) packages.get(x);
			toZipString += currPack.zipT + " " + currPack.lastNameT + ", " + currPack.firstNameT + "\n"; 
		}
		return "Delivery Schedule\n\n" + toZipString;
	}

}
