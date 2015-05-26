/**
 * This class creates an express package object and calculates cost of sending express packages.
 * @author Juan Lopez
 */
public class ExpressPackage extends Package {
	
	private double[][] rates = new double[][] { {4.9,  4.95, 5.05, 5.15, 5.25, 5.35, 5.55},
											    {5,    5.35, 5.95, 7.5,  8.1,  8.6,  9.55}, 
											    {5.7,  6.55, 7.5,  9,    9.95, 10.7, 12.7}, 
											    {6.45, 7.55, 8.6,  11.9, 13,   13.8, 15.3},
											    {7.65, 8.75, 9.85, 13.5, 14.85,15.85,17.55},
											    {8.3,  9.65, 11,   15.05,16.65,17.8, 19.9},
											    {8.95, 10.55,11.75,16.8, 18.4, 20.05,22.4},
											    {9.6,  11.45,13.3, 18.2, 20.2, 22.05,25.1},
											    {10.25,12.35,14.4, 19.75,22,   23.95,27.95}};
	
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
	public ExpressPackage(String type, String toLn, String toFn, String toStr, String toC, String toSt, int toZ, String fromLn, String fromFn, String fromStr, 
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
	 * CalculateShippingCosts uses the rates array to return the cost of a packages base on weight and zone.
	 * @return double representation of the corresponding price
	 */
	public double calulateShippingCosts() {
		if (this.weight <= 1) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[0][0];
			} else {
				return rates[0][this.zone - 2];
			}
		} else if (this.weight > 1 && this.weight <= 2) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[1][0];
			} else {
				return rates[1][this.zone - 2];
			}
		} else if (this.weight > 2 && this.weight <= 3) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[2][0];
			} else {
				return rates[2][this.zone - 2];
			}
		} else if (this.weight > 3 && this.weight <= 4) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[3][0];
			} else {
				return rates[3][this.zone - 2];
			}
		} else if (this.weight > 4 && this.weight <= 5) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[4][0];
			} else {
				return rates[4][this.zone - 2];
			}
		} else if (this.weight > 5 && this.weight <= 6) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[5][0];
			} else {
				return rates[5][this.zone - 2];
			}
		} else if (this.weight > 6 && this.weight <= 7) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[6][0];
			} else {
				return rates[6][this.zone - 2];
			}
		} else if (this.weight > 7 && this.weight <= 8) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[7][0];
			} else {
				return rates[7][this.zone - 2];
			}
		}  else if (this.weight > 8 && this.weight <= 9) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[8][0];
			} else {
				return rates[8][this.zone - 2];
			}
		}
		return 0;
	}
	
	/**
	 * Gets the package recipient's zip code
	 * @return package zip code
	 */
	public int getZip() {
		return this.zipT;
	}
	
	/**
	 * CompareTo compares two packages zip codes.
	 * @param p a Package object
	 * @return -1 if the parameters zip code is greater, 1 if the parameters zip code is less or 0 if the zip codes are equal
	 */
	public int compareTo(ExpressPackage p) {
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
		String exString = "";
		exString = "TO: " + this.firstNameT + " " + this.lastNameT + "\n" +
	            		"    " + this.streetT + "\n" + 
	            		"    " + this.cityT + ", " + this.stateT + "  " + this.zipT + "\n \n" +
	            
	   			   "FROM: " + this.firstNameF + " " + this.lastNameF + "\n" +
	   			        "    " + this.streetF + "\n" + 
	   			        "    " + this.cityF + ", " + this.stateF + "  " + this.zipF + "\n \n";
		return exString;
	}

}
