public class User {
    private String id;
    private String carID;
    private String destination;
    Car car;
    Trip trip;
    public User(String id, String carID){
        this.id=id;
        this.carID=carID;
    }

    public String pickDestination(){
        //opens the map the pick a destination from it and assign it the this.destination
        return "";
    }

    public void startTrip(){
        if(destination!=null){
            trip=new Trip(carID, destination);
            car.requestInstructions(trip);
        }
        else{
            // make a notice to the user to pick a destination first
        }
    }
}