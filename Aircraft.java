import java.util.ArrayList;

public class Aircraft {
    private String icao24;
    private String callSign;
    private ArrayList<Double> longitude;
    private ArrayList<Double> latitude;

    public Aircraft(){
        icao24 = "Undefined";
        callSign = "Undefined";
        longitude = new ArrayList<Double>();
        latitude = new ArrayList<Double>();
    }//End constructor
    public Aircraft(String icao24, String callSign, double longitude, double latitude){
        this.icao24 = icao24;
        this.callSign = callSign;

        this.longitude = new ArrayList<Double>();
        this.longitude.add(longitude);

        this.latitude = new ArrayList<Double>();
        this.latitude.add(latitude);
    }//End Constructor
    public void addEntry(double longitude, double latitude){
        this.longitude.add(longitude);
        this.latitude.add(latitude);
    }
    public String getICAO(){
        return this.icao24;
    }

    @Override
    public String toString(){
        return ("ICAO: " + icao24 + " Call Sign: " + callSign + " Position: LONG " + longitude + " LAT " + latitude);
    }
}//End class
