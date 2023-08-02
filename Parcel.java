import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Parcel {
	private int x;
	private int y;
	private int length;
	private int width;
	private int height;
	private static final int max = 50;
	private static final int min = 20;
	private static final int min2 = 10;
	private int xa;
	private int[] xVal = new int[6];
	private int[] yVal = new int[6];
	private int a;
	private int d;
	private int random;
	
	public Parcel(int x) {
		this.x = x;
		this.y = 342;
		this.xa = 1;
		this.d = 0;
		this.random = (int)(Math.random()*3 + 1);
		this.length = (int)(Math.random()*(this.max - this.min+1) + this.min);
		this.width = (int)(Math.random()*(this.max - this.min2 +1)+this.min2);
		this.height = (int)(Math.random()*(this.max - this.min+1) + this.min);
		this.a = (int) Math.sqrt((this.length*this.length)/2); 
		this.xVal = new int[]{this.x, this.x -  this.width, this.x - this.width - this.a, this.x - this.width - this.a, this.x - this.a, this.x};
		this.yVal = new int [] {this.y, this.y, this.y - this.a, this.y - this.height - this.a, this.y - this.height - this.a, this.y - this.height};
	}
	
	public int getRandom() {
		return this.random;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setD(int a) {
		this.d = a;
	}
	
	public int getD() {
		return this.d;
	}
	
	public int getXa() {
		return this.xa;
	}
	
	public void setX(int a) {
		this.x = a;
	}
	
	public void setXa(int a) {
		this.xa = a;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getH() {
		return this.height;
	}
	
	public int getA() {
		return this.a;
	}
	
	public void setY(int a) {
		this.y = a;
	}
	
	public int getXVal(int a) {
		return this.xVal[a];
	}
	
	public void setYVal(int a, int b) {
		this.yVal[a] = b;
	}
	
	public int getYVal(int a) {
		return this.yVal[a];
	}
	public void setXVal(int a, int b) {
		this.xVal[a] = b;
	}
	
	// MS. K SAID NO NEED TO ENSCAPSULATE THE COLOR OR ARRAYS !!! :))) I STILL TRIED TO DO IT A BIT BUT I WONT LOSE MARKS!!!
	public void paint(Graphics2D g2d){
		if(getRandom() == 1) {
			g2d.setColor(Color.CYAN);
		} else if (getRandom() == 2) {
			g2d.setColor(Color.GREEN);
		} else {
			g2d.setColor(Color.YELLOW);
		}
		g2d.fillPolygon(this.xVal, this.yVal, 6);
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.xVal, this.yVal, 6);
		g2d.drawLine(this.xVal[0], this.yVal[5], this.xVal[1], this.yVal[5]);
		g2d.drawLine(this.xVal[1], this.yVal[5], this.xVal[1], this.yVal[0]);
		g2d.drawLine(this.xVal[1], this.yVal[5], this.xVal[3], this.yVal[3]);
	}
	
	// moves parcels forwards and up/down depending on their color
	public void move(){
		for(int i = 0; i < 6; i++) {
			if(getXVal(2) == 572) {
				setXa(0);
				if(random == 1) {
					setD(150);
				} else if (random == 3) {
					setD(-150);
				} else {
					setD(0);
				}
				this.yVal = new int [] {getY() - getD(), getY() - getD(), getY() - getA() - getD(), getY() - getH() - getA() - getD(), getY() - getH() - getA() - getD(), getY() - getH() - getD()}; 
				setXVal(i, getXVal(i) + getXa());
				setXa(1);
			}
			setXVal(i, getXVal(i) + getXa());
			}
	}
}
