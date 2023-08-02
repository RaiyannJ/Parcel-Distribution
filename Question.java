import java.awt.*;
import javax.swing.*;
import java.util.Random;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage; 

public class Question{

    private BufferedImage img = null;

    public Question() {

    		try {
   			 this.img = ImageIO.read(new File("/Users/raiyannjacob/Desktop/Projects/ParcelDistributionCenter/question.png"));
   			} catch (IOException e) {
   			}

    }
    
    public BufferedImage getImg() {
    	return this.img;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImg(), 20, 470, 110, 110, null);
        
    }
    
}
