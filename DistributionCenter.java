import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DistributionCenter extends JPanel {

	private Parcel[] p = new Parcel[20];
    private Scanner s = new Scanner();
    private ScannerBack sb = new ScannerBack();
	private ConveyorBelt c = new ConveyorBelt(0, 370, 350, true, true);
	private ConveyorBelt c1 = new ConveyorBelt(645, 370, 325, false, false);
	private ConveyorBelt c2 = new ConveyorBelt(645, 520, 325, false, false);
	private ConveyorBelt c3 = new ConveyorBelt(645, 220, 325, false, false);
	private Plane pp = new Plane();
	private Truck t = new Truck();
	private Question q = new Question();
	
	 public DistributionCenter() {
	        for(int i = 0; i < 20; i++) {
	            this.p[i] = new Parcel(0 - 500 *i);            
	        }
	        
	       addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {}
				@Override
				public void keyReleased(KeyEvent e) {
				c.keyReleased(e);
				}
				@Override
				/*
				 my switch works so as long as the parcel is still visible on the first belt it will stop/start moving,
				 but once the parcel goes into the scanner/is not visible/the scanner light goes red/the image appears, it is no longer
				 apart of the first belt, so it will not stop moving when the switch is pressed and will get sorted.
				 However, other parcels on the first belt will still stop/start with the switch
				 */
				
				public void keyPressed(KeyEvent e) {
				c.keyPressed(e);
				for(int i = 0; i < 20; i ++) {
					if(c.getStatus() == false) {
						if(p[i].getXVal(2) < 360)
						p[i].setXa(0);
					} else {
						if(p[i].getXVal(2) < 360)
						p[i].setXa(1);
					}
				}
					}
				});
				setFocusable(true);
	    }
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, 1020, 640);
		g2d.setColor(Color.BLACK);
        g2d.fillRect(5, 455, 140, 140);
		sb.paint(g2d);
		c1.paint(g2d);
		c2.paint(g2d);
		c3.paint(g2d);
		c.paint(g2d);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
				for(Parcel p1:p) {
					p1.paint(g2d);
				}
		s.paint(g2d);
		for(int i = 0; i < 20; i ++) {
			if(this.p[i].getXVal(2)>360) {
				if(p[i].getRandom() == 1) {
		        	pp.paint(g2d);
		        } else if(p[i].getRandom() == 2) {
		        	t.paint(g2d);
		        } else if(p[i].getRandom() == 3) {
		        	q.paint(g2d);
		        }
			}
		}
	}
	
	private void move() throws InterruptedException{
		for(Parcel p1:p) {
			p1.move();
		}
		c.move();
		c1.move();
		c2.move();
		c3.move();
		
	}
	//turns light on and off
	private void lightCheck() {
		for(int i = 0; i < 20; i++ ) {
			if(this.p[i].getXVal(2)>360 && this.p[i].getXVal(2)< 650 ) {
				s.setLight(true);
				break;
			} else {
				s.setLight(false);
			}
		}
	}
	
	//turns belts on and off
	private void beltCheck() {
		for(int i = 0; i < 20; i ++) {
			if(this.p[i].getRandom() == 1 && this.p[i].getXVal(2) > 572 && this.p[i].getXVal(2) < 1020) {
				c3.setRun(true);
				break;
			} else {
				c3.setRun(false);
			}
			if(this.p[i].getRandom() == 2 && this.p[i].getXVal(2) > 572 && this.p[i].getXVal(2) < 1020) {
				c1.setRun(true);
				break;
			} else {
				c1.setRun(false);
			}
			if(this.p[i].getRandom() == 3 && this.p[i].getXVal(2) > 572 && this.p[i].getXVal(2) < 1020) {
				c2.setRun(true);
				break;
			} else {
				c2.setRun(false);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
	JFrame frame = new JFrame("EmptyFrame");
	DistributionCenter d = new DistributionCenter(); 
	frame.setSize(1020, 640);
	frame.setVisible(true);
	frame.add(d);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	while (true){
		d.move();
		d.repaint();
		d.lightCheck();
		d.beltCheck();
		Thread.sleep(10); 
		}
 	}

}
