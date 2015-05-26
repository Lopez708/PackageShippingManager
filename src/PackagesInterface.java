/**
 * Interface for the Packages class.  Data Manager class for
 * Assignment 8.
 * @author Professor Myers
 */
import java.util.*;
import java.text.*;

public interface PackagesInterface {
/**
 * Adds a package object to the ArrayList of Packages
 * Used for testing
 * @param p the package to be added to the ArrayList
 */
    public void addPackage(Package p);
    
    /**
     * Creates a package object and adds it to the ArrayList of Packages
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
     */
    public double addPackage(String type, String toLn, String toFn, String toStr, String toC, String toSt, int toZ,
  		  String fromLn, String fromFn, String fromStr, String fromC, String fromSt, int fromZ,
  		  double wt, int zone);
    
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
    public String printMailingLabels();
    
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
    public String printDeliverySchedule();
    
}