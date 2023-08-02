import javax.swing.*;
import java.awt.*;

// this is the front part of the scanner
public class Scanner {

    private int a;
    private int b;
    private Polygon p1;
    private Polygon p2;
    private boolean light;
    
    public Scanner() {
    	this.light = false;
        this.a = 360;
        this.b = 365;
        this.p1 = new Polygon(new int[] {this.a - 30, this.a + 30, this.a + 245, this.a + 295, this.a + 30, this.a}, new int[] {this.b - 180, this.b - 180, this.b-320, this.b -270, this.b + 55, this.b - 130}, 6);
        this.p2 = new Polygon(new int[] {this.a, this.a + 69, this.a + 295, this.a + 295, this.a + 69, this.a}, new int[] {this.b - 130, this.b - 130, this.b - 270, this.b + 200, this.b + 55, this.b + 55}, 6);
    }

    public int getA() {
    	return this.a;
    }
    
    public int getB() {
    	return this.b;
    }
    
    public boolean getLight(){
    	return this.light;
    }
    
    public void setLight(boolean a) {
    	this.light = a;
    }
    
    public Polygon getP1() {
    	return this.p1;
    }
    
    public Polygon getP2() {
    	return this.p2;
    }
    
    // MS. K SAID NO NEED TO ENSCAPSULATE THE COLOR OR ARRAYS !!! :))) I STILL TRIED TO DO IT A BIT BUT I WONT LOSE MARKS!!!
    public void paint(Graphics g2d) {       
        g2d.setColor(Color.GRAY);
        g2d.fillPolygon(getP1());
        g2d.setColor(Color.black);
        g2d.drawPolygon(getP1());
        
        g2d.setColor(Color.gray);
        g2d.fillPolygon(getP2());

        g2d.setColor(Color.black);
        g2d.drawLine(getA() + 30, getB() - 180, getA() + 69, getB() - 130);
        g2d.drawPolygon(getP2());
        
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(363, 360, 58, 58);
        
        //paints the light
        if(getLight()) {
        	g2d.setColor(Color.RED);
            g2d.fillOval(366, 363, 53, 53);
        } else {
        	g2d.setColor(Color.BLACK);
            g2d.fillOval(366, 364, 53, 53);
            
        }
    }
    
}
