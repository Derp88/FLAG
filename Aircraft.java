import java.util.ArrayList;

public class Aircraft {
    private String icao24;
    private String callSign;
    private ArrayList<Double> longitude;
    private ArrayList<Double> latitude;

    //Less important data that is tracked
    private double altitude;
    private double velocity;

    public Aircraft(){
        icao24 = "Undefined";
        callSign = "Undefined";
        longitude = new ArrayList<Double>();
        latitude = new ArrayList<Double>();
        
        altitude = 0;
        velocity = 0;
    }//End constructor
    public Aircraft(String icao24, String callSign, double longitude, double latitude, double altitude, double velocity){
        this.icao24 = icao24;
        this.callSign = callSign;

        this.longitude = new ArrayList<Double>();
        this.longitude.add(longitude);

        this.latitude = new ArrayList<Double>();
        this.latitude.add(latitude);

        this.altitude = altitude;
        this.velocity = velocity;

    }//End Constructor
    public void addEntry(double longitude, double latitude, double altitude, double velocity){
        this.longitude.add(longitude);
        this.latitude.add(latitude);
        this.altitude = altitude;
        this.velocity = velocity;
    }
    public String getICAO(){
        return this.icao24;
    }
    public String getCallSign(){
        return this.callSign;
    }
    public ArrayList<Double> getLongitude(){
        return longitude;
    }
    public ArrayList<Double> getLatitude(){
        return latitude;
    }

    public double getAltitude(){
        return this.altitude;
    }
    public double getVelocity(){
        return this.velocity;
    }

    @Override
    public String toString(){
        return ("ICAO: " + icao24 + " Call Sign: " + callSign + " Position: LONG " + longitude + " LAT " + latitude);
    }
}//End class
