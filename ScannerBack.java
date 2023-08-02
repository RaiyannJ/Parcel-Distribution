import javax.swing.*;
import java.awt.*;

// this is the back part of the scanner
public class ScannerBack {

    private int a;
    private int b;
    private Polygon p;
    private int x2;
	private int y2;
	private int length2;
	private int width2;
	private int height2;
	private int a2;
	private int[] xVal2 = new int[6];
	private int[] yVal2 = new int[6];
	

    public ScannerBack() {
    	this.x2 = 250;
		this.y2 = 431;
		this.width2 = 60;
		this.length2 = 90;
		this.height2 = 60;
		this.a2 = (int) Math.sqrt((this.length2*this.length2)/2); 
		this.xVal2 = new int[]{this.x2, this.x2 -  this.width2, this.x2 - this.width2 - this.a2, this.x2 - this.width2 - this.a2, this.x2 - this.a2, this.x2};
		this.yVal2 = new int [] {this.y2, this.y2, this.y2 - this.a2, this.y2 - this.height2 - this.a2, this.y2 - this.height2 - this.a2, this.y2 - this.height2};
        this.a = 360;
        this.b = 365;
        this.p = new Polygon(new int[] {this.a - 30, this.a - 30, this.a, this.a}, new int[] {this.b - 180, this.b , this.b + 55, this.b - 130}, 4);
    }
    
    public Polygon getP() {
    	return this.p;
    }
    
    // MS. K SAID NO NEED TO ENSCAPSULATE THE COLOR OR ARRAYS !!! :))) I STILL TRIED TO DO IT A BIT BUT I WONT LOSE MARKS!!!
    public void paint(Graphics g2d) {
        g2d.setColor(Color.black);
        g2d.drawPolygon(getP());
        g2d.fillPolygon(getP());
        
        // the box thing that holds the light
        g2d.setColor(Color.GRAY);
		g2d.fillPolygon(this.xVal2, this.yVal2, 6);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.xVal2, this.yVal2, 6);
		g2d.drawLine(this.xVal2[0], this.yVal2[5], this.xVal2[1], this.yVal2[5]);
		g2d.drawLine(this.xVal2[1], this.yVal2[5], this.xVal2[1], this.yVal2[0]);
		g2d.drawLine(this.xVal2[1], this.yVal2[5], this.xVal2[3], this.yVal2[3]);
    }
}
