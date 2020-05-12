public class Trip {
    private String id;
    private String carID;
    private String destination;

    public Trip(String carID, String destination){
        this.carID=carID;
        this.destination=destination;
        // generate tripID
    }

    public String getDestination() {
        return destination;
    }

    public String getId() {
        return id;
    }
}
