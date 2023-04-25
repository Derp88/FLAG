import java.util.Scanner;

public class Main {
    public GUI aircraftGUI;
    public Logger aircraftLogger = new Logger();
    private int choice;

    public void runGraph(int delaySeconds, boolean simpleMode){
        aircraftGUI = new GUI(simpleMode);
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
    public void loggerOnly(int delaySeconds){
        int initTime = (int) System.currentTimeMillis();
        int periodTime = initTime - 1000*(delaySeconds); //Remove delaySeconds seconds to the starting time, so we run once before waiting.
        while (true){
            if ((int) System.currentTimeMillis() > periodTime + 1000*(delaySeconds)){//This only runs every delaySeconds seconds
                aircraftLogger.storeEntry(aircraftLogger.logData());
                periodTime = (int) System.currentTimeMillis();
            }
        }
    }
    public int menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("FLAG version: 1.0");
        System.out.println("1) Graph");
        System.out.println("2) Simple Graph");
        System.out.println("3) Data Only");
        try {
            choice = input.nextInt();
            input.close();
            return choice;
        } catch (Exception e){
            System.out.println("Bad Input!");
            System.out.println(e.getMessage());
            input.close();
            return 1;
        }
    }

    public static void main(String[] args) {
        Main mainFLAG = new Main();
        int selection = mainFLAG.menu();;

        if (selection == 2){
            mainFLAG.runGraph(10, true);
        } else if (selection == 3){
            mainFLAG.loggerOnly(10);
        } else{
            mainFLAG.runGraph(10, false);
        }
    }
}
