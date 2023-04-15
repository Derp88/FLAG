import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Logger {
    public static void main(String[] args){
        Logger testLogger = new Logger();
        testLogger.logData();
    }
    public Logger() {
        
    }//End constructor

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
            System.out.println("Error: API Connection Failure");
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            System.out.println("Error: JSON Parsing Failure");
            e.printStackTrace();
            return null;
        }
    }//End Log Data
    public void storeEntry(JSONObject entryJSON) {
        JSONArray aircraftarrayJSON = (JSONArray) entryJSON.get("states");
    }
}//End Class