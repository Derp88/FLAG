import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class GUI extends JFrame{
    private ArrayList<Path2D> flightPathList = new ArrayList<Path2D>();
    private Color[] colors = new Color[] {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW,
    };
    private BackgroundPanel BackGround;
    //Map details
    private double mapLongLeft = -87.525964;
    private double mapLongRight = -84.815118;
    private double mapLongDelta = mapLongRight - mapLongLeft;
    private double mapLatBottom = 39.567746;
    private double mapLatBottomDegree = (mapLatBottom * Math.PI)/ 180;

    public GUI() {
        BackGround = new BackgroundPanel();
        this.setContentPane(BackGround);
        this.setSize(BackGround.getImageWidth(), BackGround.getImageHeight());
        this.setVisible(true);
    }
    public void updatePaths(ArrayList<Aircraft> aircraftList){
        flightPathList.clear();
        for (int i = 0; i < aircraftList.size(); i++){//For each aircraft
            Path2D flightPath = new Path2D.Double(); //Create a new flight path
            flightPath.moveTo(getLongitudeX(aircraftList.get(i).getLongitude().get(0)), getLatitudeY(aircraftList.get(i).getLatitude().get(0)));//Set the path to the first recorded position
            for (int j = 1; j < aircraftList.get(i).getLongitude().size(); j++){ //Get the position of every entry
                flightPath.lineTo(getLongitudeX(aircraftList.get(i).getLongitude().get(j)), getLatitudeY(aircraftList.get(i).getLatitude().get(j)));

            }
            flightPathList.add(flightPath);
            this.repaint();
        }
    }
    public Double getLongitudeX(double longitude){
        return (longitude - mapLongLeft) * (BackGround.getImageWidth() / mapLongDelta);
    }
    public Double getLatitudeY(double latitude){
        double worldMapWidth = ((BackGround.getWidth() / mapLongDelta) * 360) / (2 * Math.PI);
        double mapOffsetY = (worldMapWidth / 2 * Math.log((1 + Math.sin(mapLatBottomDegree)) / (1 - Math.sin(mapLatBottomDegree))));
        double latitudeRad = latitude * Math.PI / 180;
        double y = BackGround.getImageHeight() - ((worldMapWidth / 2 * Math.log((1 + Math.sin(latitudeRad)) / (1 - Math.sin(latitudeRad)))) - mapOffsetY);
        return y;
    } 


    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        if (!flightPathList.isEmpty()){
            int colorIndex = 0;
            for (int i = 0; i < flightPathList.size(); i++){
                colorIndex = i % 9;
                graphics2D.setColor(colors[colorIndex]);
                Stroke stroke = new BasicStroke(3f);
                graphics2D.setStroke(stroke);
                graphics2D.draw(flightPathList.get(i));
                
            }
        }
    }
}
