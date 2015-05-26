import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PackagesTest {

	private Packages testPackages;
	private Packages testPackages2;
	private double pkg1Cost, pkg2Cost, pkg3Cost, pkg4Cost;
	@Before
	public void setUp() throws Exception {
		testPackages = new Packages();
		//add an Overnight Package
		pkg1Cost = testPackages.addPackage("overnight", "Smith", "John", "22 Oak St.", "Gaithersburg", "MD", 20879, 
				"Marble", "Mable", "45 Elm Ave.", "Somewhere", "MN", 55443, 2.2, 3);
		//add a First Class Package
		pkg2Cost = testPackages.addPackage("firstClass", "Johnson", "Bob", "65 W. Sycamore Dr.", "Darnestown", "MD", 20874, 
				"Johnson", "Amy", "876 Spruce Ct.", "Boise", "ID", 83723, 7.3, 0);
		
		//STUDENT - Create a new Packages object and add packages to it.  The data for your packages object 
		// must be different than the data in testPackage.  Use your packages object for the Student Tests
		testPackages2 = new Packages();
		pkg3Cost = testPackages2.addPackage("firstClass", "Jones", "Mike", "802 South Lee", "Houston", "TX", 68025, 
				"Yim", "Tai", "35 Abbey Rd.", "Gary", "IN", 30295, 12, 0);
		
		pkg4Cost = testPackages2.addPackage("overnight", "Lopez", "Juan", "65 W. Military Dr.", "Chevy Chase", "MD", 20015, 
				"Hill", "Joffrey", "256 Main Ct.", "Chicago", "IL", 52986, 3.6, 6);
	}

	@After
	public void tearDown() throws Exception {
		testPackages = null;
		testPackages2 = null;
	}

	@Test
	public void testCalculateShipping()
	{
		assertEquals(pkg1Cost,23.20,.001);
		assertEquals(pkg2Cost,2.41,.001);
		
	}
	
	@Test
	public void testCalculateShippingSTUDENT()
	{
		assertEquals(pkg3Cost,3.09,.001);
		assertEquals(pkg4Cost,36.75,.001);
	}
	
	@Test
	public void testAddPackage() {
		//Check which packages are currently in ArrayList
		String delivery = testPackages.printDeliverySchedule();
		Scanner scan = new Scanner(delivery);
		scan.nextLine(); //Delivery Schedule
		scan.nextLine(); // blank line
		assertEquals("20874",scan.next());// Zip for Johnson,Bob
		scan.nextLine(); // Johnson, Bob
		assertEquals("20879",scan.next());// Zip for Smith,John
		//Add an Express Package
		pkg3Cost = testPackages.addPackage("express", "Jungle", "George", "10984 Elm Ct.", "Germantown", "MD", 20876, 
				"Johnson", "Amy", "876 Spruce Ct.", "Boise", "ID", 83723, 5.5, 2);
		assertEquals(pkg3Cost,8.30,.001);
		//Check which packages are currently in ArrayList
		delivery = testPackages.printDeliverySchedule();
		scan = new Scanner(delivery);
		scan.nextLine(); //Delivery Schedule
		scan.nextLine(); // blank line
		assertEquals("20874",scan.next());// Zip for Johnson,Bob
		scan.nextLine(); // Johnson, Bob
		assertEquals("20876",scan.next());// Zip for Jungle, George
		assertEquals("Jungle,", scan.next());
	}
	
	@Test
	public void testAddPackageSTUDENT()
	{
		String delivewy = testPackages2.printDeliverySchedule();
		Scanner scan = new Scanner(delivewy);
		scan.nextLine(); //Delivery Schedule
		scan.nextLine(); // blank line
		assertEquals("20015",scan.next());
		scan.nextLine(); 
		assertEquals("68025",scan.next());
		pkg3Cost = testPackages2.addPackage("express", "Soliman", "Riky", "88 Bark Way.", "Derwood", "MD", 20855, 
				"Squall", "DJ", "4301 Knowles Ave.", "Kensington", "MD", 20893, 6.9, 7);
		assertEquals(pkg3Cost,20.05,.001);
		delivewy = testPackages2.printDeliverySchedule();
		scan = new Scanner(delivewy);
		scan.nextLine(); //Delivery Schedule
		scan.nextLine(); // blank line
		assertEquals("20015",scan.next());
		scan.nextLine(); 
		assertEquals("20855",scan.next());
		assertEquals("Soliman,", scan.next());
	}

	@Test
	public void testPrintDeliverySchedule() {
		String delivery = testPackages.printDeliverySchedule();
		Scanner scan = new Scanner(delivery);
		scan.nextLine(); //Delivery Schedule
		scan.nextLine(); // blank line
		assertEquals("20874",scan.next());// Zip for Johnson,Bob
		scan.nextLine(); // Johnson, Bob
		assertEquals("20879",scan.next());// Zip for Smith,John
		
	}
	
	@Test
	public void testPrintDeliveryScheduleSTUDENT()
	{
		String delivewy = testPackages2.printDeliverySchedule();
		Scanner scan = new Scanner(delivewy);
		scan.nextLine(); //Delivery Schedule
		scan.nextLine(); // blank line
		assertEquals("20015",scan.next());
		scan.nextLine(); 
		assertEquals("68025",scan.next());
	}

	@Test
	public void testPrintMailingLabels() {
		String labels = testPackages.printMailingLabels();
		Scanner scan = new Scanner(labels);
		System.out.println(labels);
		scan.nextLine(); //Labels
		scan.nextLine(); // blank line
		assertEquals("TO:",scan.next());
		assertEquals("John",scan.next()); // John
		assertEquals("Smith",scan.next());// Smith
	}

}