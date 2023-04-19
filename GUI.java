import javax.swing.JFrame;

public class GUI extends JFrame{
    public GUI() {
        BackgroundPanel BackGround = new BackgroundPanel();
        this.setContentPane(BackGround);
        this.setSize(BackGround.getImageWidth(), BackGround.getImageHeight());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        GUI demo = new GUI();
        System.out.println(demo.getHeight());
        System.out.println(demo.getWidth());
    }
}
