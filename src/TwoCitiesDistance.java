
import java.util.Scanner;
import javax.swing.JOptionPane;

/* Calculates the distance between two cities and allows the user to specify 
 * a unit of distance. This program may require finding coordinates for the 
 * cities like latitude and longitude.
 */

public class TwoCitiesDistance {
	
	static double latitude1; //Stores latitude of city #1
	static double longitude1; //Stores longitude of city #1
	static double latitude2; //Stores latitude of city #2
	static double longitude2; //Stores longitude of city #2
	static int unitchoice; //Stores unit type as picked by user
	static double result; //Stores result of Haversine formula (convertUnits())
	
	
	public static void setCitiesLatLong() {
		Scanner input = new Scanner(System.in);
		latitude1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the latitude of City #1:"));
		longitude1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the longitude of City #1:"));
		latitude2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the latitude of City #2:"));
		longitude2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the longitude of City #2:"));
		unitchoice = Integer.parseInt(JOptionPane.showInputDialog("What units would you like the distance to be calculated in? Enter 1 for kilometers or 2 for miles."));
		input.close();
	}
	
	public static double calcCityDistance(double lat1, double lon1, double lat2, double lon2) {
		double radiusOfEarth = 6371; //radius of Earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        result = radiusOfEarth * c;
        return result;
	}
	
	public static void convertUnits() {
		switch(unitchoice) {
		case 1:
			JOptionPane.showMessageDialog(null, "The distance between these two cities is " + result + " km.");
			break;
		case 2:
			result = result * 0.6213711922;
			JOptionPane.showMessageDialog(null, "The distance between these two cities is " + result + " miles.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "You have entered an invalid choice of units. Please try again.");
			break;
		}
	}
	
	public static void main(String[] args) {
		setCitiesLatLong(); //takes user input of lat/long for 2 cities
		calcCityDistance(latitude1, longitude1, latitude2, longitude2); //Haversine formula calc, takes lat/longs of two cities as args
		convertUnits(); //switch statement - either prints result or converts to miles/different unit
	}
}
