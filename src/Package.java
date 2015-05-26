/**
 * Packages holds all the instance variables and methods common to all packages.
 * @author Juan Lopez
 */
public abstract class Package implements Comparable<Package> {
	
	String shipType;
	String firstNameT;
	String lastNameT;
	String streetT;
	String cityT;
	String stateT;
	int zipT;
	String firstNameF;
	String lastNameF;
	String streetF;
	String cityF;
	String stateF;
	int zipF;
	double weight;
	int zone;

	/**
	 * CalculateShippingCosts uses the rates array to return the cost of a packages base on weight and zone.
	 */
	public abstract double calulateShippingCosts();
	
	/**
	 * CompareTo compares two packages zip codes.
	 * @param p a Package object
	 * @return -1 if the parameters zip code is greater, 1 if the parameters zip code is less or 0 if the zip codes are equal
	 */
	public int compareTo(Package p) {
		if (this.zipT < p.getZip()) {
			return -1;
		} else if (this.zipT > p.getZip()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the package recipient's zip code
	 * @return
	 */
	public int getZip() {
		return zipT;
	}
}

