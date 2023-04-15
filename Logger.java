import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Logger {
    private ArrayList<Aircraft> aircraftList = new ArrayList<Aircraft>();
    public static void main(String[] args){
        Logger testLogger = new Logger();
        
        //testLogger.storeEntry(testLogger.logData());
        for (int i = 0; i < 5; i++){
            testLogger.storeEntry(testLogger.logData());
        }
    }
    
    public JSONObject logData() {
        try {
            //Gets connection and puts into a string format.
            URLConnection apiConnection = new URL("https://opensky-network.org/api/states/all?lamin=39.631077&lomin=-86.374823&lamax=39.927642&lomax=-85.937323").openConnection();
            InputStream input = apiConnection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader buffReader = new BufferedReader(inputReader);
            
            //Parses string/bufferedReader into a JSONObject
            JSONParser parser = new JSONParser();
            JSONObject dataJsonObject = (JSONObject) parser.parse(buffReader);
            return dataJsonObject;

        } catch (IOException e) {
            System.out.println("Logger Error: API Connection Failure");
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            System.out.println("Logger Error: JSON Parsing Failure");
            e.printStackTrace();
            return null;
        }
    }//End Log Data
    public void storeEntry(JSONObject entryJSON) {
        JSONArray aircraftArrayJSON = (JSONArray) entryJSON.get("states");
        for (int i = 0; i < aircraftArrayJSON.size(); i++){ //This gets the individual array for each aircraft
            JSONArray individualaircraftArray = (JSONArray) aircraftArrayJSON.get(i);

            String icao24 = (String) individualaircraftArray.get(0);
            String callSign = (String) individualaircraftArray.get(1);
            double longitude = (double) individualaircraftArray.get(5);
            double latitude = (double) individualaircraftArray.get(6);

            //Check to see if the plane already exists
            if (findICAOMatch(icao24) != -1){
                //Plane already exists. Update it's position
                System.out.println("Logger: Updating aircraft: " + icao24);
                aircraftList.get(findICAOMatch(icao24)).addEntry(longitude, latitude);;
            }else{
                //This plane does not exist. Create a new one.
                System.out.println("Logger: Adding aircraft: " + icao24);
                Aircraft aircraftEntry = new Aircraft(icao24, callSign, longitude, latitude);
                aircraftList.add(aircraftEntry);
            }
        }//End for loop

        for (int i = 0; i < aircraftList.size(); i++){
            System.out.println(aircraftList.get(i));
        }
    }//End Store Entry
    //Finds the index of the aircraft with the matching ICAO24. Returns -1 if there is not a match.
    public int findICAOMatch(String icao24){
        int match = -1;
        for (int i = 0; i < aircraftList.size(); i++){
            if (aircraftList.get(i).getICAO().equals(icao24)){
                //System.out.println("Logger: Found a match for " + icao24);
                match = i;
            }
        }
        return match;
    }
}//End Class