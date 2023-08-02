import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.*;
import java.util.*;

public class ConveyorBelt {
	private int x;
	private int x1;
	private int y;
	private int y1;
	private int length;
	private int width;
	private int height;
	private int[] xVal = new int[6];
	private int[] yVal = new int[6];
	private int a;
	private int xa;
	private static int radius = 16;
	private static int radius2 = 4;
	private int xx;
	private boolean run;
	private boolean button;
	private boolean status;
	private boolean spin;
	
	public ConveyorBelt(int x, int y, int width, boolean run, boolean button) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = 70;
		this.height = 20;
		this.run = run;
		this.button = button;
		this.status = true;
		this.xa = 1;
		this.a = (int) Math.sqrt((this.length*this.length)/2); 
		this.xVal = new int[]{this.x, this.x + this.width + this.a, this.x + this.width + this.a, this.x + this.width + this.a, this.x, this.x};
		this.yVal = new int [] {this.y, this.y, this.y - this.a, this.y - this.height - this.a, this.y - this.height - this.a, this.y - this.height};
		this.xx = this.x - 53;
		this.x1 = x;
		this.y1 = y;
		this.spin = false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public int getRadius2() {
		return this.radius2;
	}
	
	public int getA() {
		return a;
	}
	
	public int getXa() {
		return this.xa;
	}
	
	public void setXa(int a) {
		this.xa = a;
	}
	
	public int getXx() {
		return this.xx;
	}
	
	public void setXX(int a) {
		this.xx = a;
	}
	
	public int getX1() {
		return this.x1;
	}
	
	public void setX1(int a) {
		this.x1 = a;
	}
	
	public int getY1() {
		return this.y1;
	}
	
	public void setY1(int a) {
		this.y1 = a;
	}
	
	public boolean getRun() {
		return this.run;
	}
	
	public void setRun(boolean a) {
		this.run = a;
	}
	
	public boolean getButton() {
		return this.button;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	
	public void setStatus(boolean a) {
		this.status = a;
	}
	
	public boolean getSpin() {
		return this.spin;
	}
	
	public void setSpin(boolean a) {
		this.spin = a;
	}
	
	public void keyReleased(KeyEvent e) {
    	
    }
	
	// switch controls for belt
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
        	
        	if(getButton()) {
        		if(getStatus()) {
                		setXa(0);
        		} else {
                		setXa(1);
        		}
        	}
        	setStatus(!getStatus());
        }
    }
    
	//moves the belt
	public void move(){
		int place = getXx();
		if(getRun() == true) {
			if(getXx() > getX()) {
				setXX(place-53);
			}
			setXX(getXx()+ getXa());
			//this moves the wheels, the wheels have to move fast because they are bad wheels
			if(getXx()%10==0) {
			setSpin(!getSpin());
			}
			
		}
	}
	
	// MS. K SAID NO NEED TO ENSCAPSULATE THE COLOR OR ARRAYS !!! :))) I STILL TRIED TO DO IT A BIT BUT I WONT LOSE MARKS!!!
	public void paint(Graphics2D g2d){
		g2d.setColor(Color.GRAY);
		g2d.fillPolygon(this.xVal, this.yVal, 6);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.xVal, this.yVal, 6);
		g2d.drawLine(this.xVal[0], this.yVal[5], this.xVal[1], this.yVal[5]);
		g2d.drawLine(this.xVal[1], this.yVal[5], this.xVal[1], this.yVal[0]);
		g2d.drawLine(this.xVal[1], this.yVal[5], this.xVal[3], this.yVal[3]);
		
		//lines on the belt
		for(int i = 0; i <= 8; i++) {
			g2d.drawLine(getXx() + i * 53, this.yVal[5], getXx() - getA() + i * 53, this.yVal[5] - getA());	
		}
		
		// wheels on the belt
		for(int i = 0; i <= getWidth()/getRadius(); i++)
		g2d.fillOval(getX() + i * (getRadius() + getRadius()/8), getY() - (getRadius()+2), getRadius(), getRadius());
		
		// white circles in the wheels
		g2d.setColor(Color.WHITE);
		
		if(getSpin()) {
			for(int i = 0; i <= getWidth()/getRadius(); i++) {
				g2d.fillOval(getX1() + 4 + i * (getRadius() + getRadius()/8) + 5, 2 + getY1() - (getRadius()+2), getRadius2(), getRadius2());
				g2d.fillOval(getX1() + 4 + i * (getRadius() + getRadius()/8), 2 + getY1() - (getRadius()+2) + 7, getRadius2(), getRadius2());
				}	
		} else if(!getSpin()) {
			for(int i = 0; i <= getWidth()/getRadius(); i++) {
				g2d.fillOval(getX1() + 4 + i * (getRadius() + getRadius()/8), 2 + getY1() - (getRadius()+2), getRadius2(), getRadius2());
				g2d.fillOval(getX1() + 4 + i * (getRadius() + getRadius()/8) + 5, 2 + getY1() - (getRadius()+2) + 7, getRadius2(), getRadius2());	
			}
			}
		
        
		// the actual color of the light
        if(getStatus()) {
        	g2d.setColor(Color.GREEN);
            g2d.fillOval(195, 375, 53, 53);
        } else {
        	g2d.setColor(Color.BLACK);
            g2d.fillOval(195, 375, 53, 53);
        }
		
	}
}

