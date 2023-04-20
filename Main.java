public class Main {
    public GUI aircraftGUI = new GUI();
    public Logger aircraftLogger = new Logger();

    public void runGraph(int delaySeconds){
        int initTime = (int) System.currentTimeMillis();
        int periodTime = initTime - 1000*(delaySeconds); //Remove delaySeconds seconds to the starting time, so we run once before waiting.

        while (true){
            if ((int) System.currentTimeMillis() > periodTime + 1000*(delaySeconds)){//This only runs every delaySeconds seconds
                aircraftLogger.storeEntry(aircraftLogger.logData());
                aircraftGUI.updatePaths(aircraftLogger.getAircraftList());
                periodTime = (int) System.currentTimeMillis();
            }
        }
    }

    public static void main(String[] args) {
        Main mainFLAG = new Main();
        mainFLAG.runGraph(10);
        
    }

}
