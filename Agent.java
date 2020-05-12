import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Agent {

    private ArrayList<ArrayList<Integer>> actionsSet; // will hold all the action about how important the factor of {distance} [1-100], and the factor of {traffic density} [1-100]
    ArrayList<Map<List<Integer>, Double>> actionValue_Functions; //will hold the value function of each pair of the values of the 2 factors (Distance, trafficDensity)
    public static ArrayList<String> getInstructions(String carID, String position, String destination){
        ArrayList<ArrayList<String>> availableRoutes = new ArrayList<>();
        ArrayList<String>route=new ArrayList<>();

        // initiate the trip
        availableRoutes=checkMap(position, destination); // Invoke the api that will figure all the available routes
        // Do the calculation based on the value function to figure the best edges to follow (the route)

        return route;
    }
    public static ArrayList<String> updateInstructions(String carID, String tripID, String position){
        boolean isNewTrip=true;
        String destination="";  // destination=tripID.destination;
        ArrayList<ArrayList<String>> availableRoutes = new ArrayList<>();
        ArrayList<String>route=new ArrayList<>();

        //modify the old trip
        availableRoutes=checkMap(position, destination); // Invoke the api that will figure all the available routes
        // Do the calculation based on the value function to figure the best edges to follow (the route)

        return route;
    }

    public static ArrayList<ArrayList<String>> checkMap(String position, String Destination){
        return new ArrayList<>();
    }

    public static void updateValueFunctions(String tripID, double time){
        // according to the algorithm & the route, update the value functions
    }
}
