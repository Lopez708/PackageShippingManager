/**
 * This class creates an first class package object and calculates cost of sending first class packages.
 * @author Juan Lopez
 */
public class FirstClassPackage extends Package {
	
	private double[] rates = {1.22, 
							  1.39,  
							  1.56, 
							  1.73,  
							  1.90, 
							  2.07,  
							  2.24, 
							  2.41,
							  2.58,
							  2.75,
							  2.92,
							  3.09,
							  3.26};
	
	/**
	 * Constructor
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
     * @param zn zone of package
	 */
	public FirstClassPackage(String type, String toLn, String toFn, String toStr, String toC, String toSt, int toZ, String fromLn, String fromFn, String fromStr, 
			    String fromC, String fromSt, int fromZ, double wt, int zn) {
		
		shipType = type;
		lastNameT = toLn;
		firstNameT = toFn;
		streetT = toStr;
		cityT = toC;
		stateT = toSt;
		zipT = toZ;
		lastNameF = fromLn;
		firstNameF = fromFn;
		streetF = fromStr;
		cityF = fromC;
		stateF = fromSt;
		zipF = fromZ;
		weight = wt;
		zone = zn;
	}
	
	/**
	 * CalculateShippingCosts uses the rates array to return the cost of a packages base on weight only.
	 */
	public double calulateShippingCosts() {
		if (this.weight <= 1) {
			return rates[0];
		} else if (this.weight > 1 && this.weight <= 2) {
			return rates[1];
		} else if (this.weight > 2 && this.weight <= 3) {
			return rates[2];
		} else if (this.weight > 3 && this.weight <= 4) {
			return rates[3];
		} else if (this.weight > 4 && this.weight <= 5) {
			return rates[4];
		} else if (this.weight > 5 && this.weight <= 6) {
			return rates[5];
		} else if (this.weight > 6 && this.weight <= 7) {
			return rates[6];
		} else if (this.weight > 7 && this.weight <= 8) {
			return rates[7];
		} else if (this.weight > 8 && this.weight <= 9) {
			return rates[8];
		} else if (this.weight > 9 && this.weight <= 10) {
			return rates[9];
		} else if (this.weight > 10 && this.weight <= 11) {
			return rates[10];
		} else if (this.weight > 11 && this.weight <= 12) {
			return rates[11];
		} else if (this.weight > 12 && this.weight <= 13) {
			return rates[12];
		}
		return 0;
	}
	
	/**
	 * Gets the package recipient's zip code
	 * @return
	 */
	public int getZip() {
		return this.zipT;
	}
	
	/**
	 * CompareTo compares two packages zip codes.
	 * @param p a Package object
	 * @return -1 if the parameters zip code is greater, 1 if the parameters zip code is less or 0 if the zip codes are equal
	 */
	public int compareTo(FirstClassPackage p) {
		if (this.zipT < (p).getZip()) {
			return -1;
		} else if (this.zipT > (p).getZip()) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
     * Creates the To and From Label
     * @return a String with the To and From information of the package
     * Mailing Labels will be in the following format:
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
	public String toString() {
		String fcString = "";
		fcString = "TO: " + this.firstNameT + " " + this.lastNameT + "\n" +
        			    "    " + this.streetT + "\n" + 
        			    "    " + this.cityT + ", " + this.stateT + "  " + this.zipT + "\n \n" +
        
			       "FROM: " + this.firstNameF + " " + this.lastNameF + "\n" +
			        	"    " + this.streetF + "\n" + 
			        	"    " + this.cityF + ", " + this.stateF + "  " + this.zipF + "\n \n";
		return fcString;
	}
}
