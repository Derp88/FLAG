import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel{
    Image img = null;

    public BackgroundPanel(){
        try {
            File imagefile = new File("background.png");
            img = ImageIO.read(imagefile);
        } catch (IOException e) {
            System.out.println("GUI Error: Issue with opening background");
            e.printStackTrace();
        }
    }

    public int getImageHeight(){
        return img.getHeight(null);
    }
    public int getImageWidth(){
        return img.getWidth(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawImage(img, 0, 0, null); //Might need to set observer to "this", not sure
        //g.drawImage(img, 0, 0, getWidth(), getHeight(), this); //This works to fix the issue of the image not fitting, but it scales weirdly
    }
}
