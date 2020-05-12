import java.util.ArrayList;

public class Car {
    private String carID;
    private boolean isOnTrip=false;
    Trip trip;
    public Car(){
        //create a new car
    }

    public String getPosition(){
        return "";
    }

    public void move(ArrayList<String> route){
        double time = 0;
        boolean isFinished=false;
        // make the car move according to the route

        //update the Agent with the info about the trip after it finished
        if(isFinished){
            Agent.updateValueFunctions(trip.getId(), time);
        }
    }

    public void requestInstructions(Trip trip){
        this.move(Agent.getInstructions(carID, getPosition(), trip.getDestination()));
    }
    public void requestNewInstructions(Trip trip){
        this.move(Agent.updateInstructions(carID, trip.getId(), getPosition()));
    }

}
