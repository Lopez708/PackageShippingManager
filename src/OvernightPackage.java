/**
 * This class creates an overnight package object and calculates cost of sending overnight packages.
 * @author Juan Lopez
 */
public class OvernightPackage extends Package {
	
	private double[][] rates = new double[][] { {13.65, 15.9, 19.35, 20.7, 21.05, 21.85, 22.2},
												{15.7,  20.7, 24.7,  25.3, 25.85, 26.2,  26.3}, 
												{17.05, 21.85,27.15, 27.75,28.3,  28.5,  28.9}, 
												{18.1,  23.2, 31.2,  31.95,32.6,  32.8,  33.1},
												{19.45, 24.7, 35.3,  36.6, 36.75, 36.9,  37.25},
												{20.2,  26.4, 39.3,  40.8, 40.9,  41.1,  41.4},
												{23.65, 31.75,42.95, 44.85,44.95, 45.95, 45.7},
												{27.15, 37,   47,    48.35,49.1,  49.4,  49.7},
												{28.5,  38.15,50.6,  52.55,53.35, 53.6,  54}};
	
	
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
	public OvernightPackage(String type, String toLn, String toFn, String toStr, String toC, String toSt, int toZ, String fromLn, String fromFn, String fromStr, 
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
	 */
	public double calulateShippingCosts() {
		if (this.weight <= 0.5) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[0][0];
			} else {
				return rates[0][this.zone - 2];
			}
		} else if (this.weight > 0.5 && this.weight <= 1) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[1][0];
			} else {
				return rates[1][this.zone - 2];
			}
		} else if (this.weight > 1 && this.weight <= 2) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[2][0];
			} else {
				return rates[2][this.zone - 2];
			}
		} else if (this.weight > 2 && this.weight <= 3) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[3][0];
			} else {
				return rates[3][this.zone - 2];
			}
		} else if (this.weight > 3 && this.weight <= 4) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[4][0];
			} else {
				return rates[4][this.zone - 2];
			}
		} else if (this.weight > 4 && this.weight <= 5) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[5][0];
			} else {
				return rates[5][this.zone - 2];
			}
		} else if (this.weight > 5 && this.weight <= 6) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[6][0];
			} else {
				return rates[6][this.zone - 2];
			}
		} else if (this.weight > 6 && this.weight <= 7) {
			if (this.zone == 1 || this.zone == 2) {
				return rates[7][0];
			} else {
				return rates[7][this.zone - 2];
			}
		}  else if (this.weight > 7 && this.weight <= 8) {
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
	public int compareTo(OvernightPackage p) {
		if (this.zipT < (p.getZip())) {
			return -1;
		} else if (this.zipT > ((OvernightPackage)p).getZip()) {
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
		String ovString = "";
		ovString = "TO: " + this.firstNameT + " " + this.lastNameT + "\n" +
				            "    " + this.streetT + "\n" + 
				            "    " + this.cityT + ", " + this.stateT + "  " + this.zipT + "\n \n" +
				            
				   "FROM: " + this.firstNameF + " " + this.lastNameF + "\n" +
				   			"    " + this.streetF + "\n" + 
				   			"    " + this.cityF + ", " + this.stateF + "  " + this.zipF + "\n \n";
		return ovString;
	}
}
