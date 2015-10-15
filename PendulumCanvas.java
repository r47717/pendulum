package pendulumapp;

import javax.swing.*;
import java.awt.*;
import java.awt.*;


public class PendulumCanvas extends JPanel implements Runnable {
	PendulumModel model;
	Thread t;

	public PendulumCanvas() {
		super();
		this.setBorder(BorderFactory.createEtchedBorder());
	}
	
	public void setModel(PendulumModel model) {
		this.model = model;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		
		while(true) {
			model.step();
			this.repaint();
			try {
				Thread.sleep(model.getSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		g2d.drawLine(model.getNullX(), model.getNullY(), model.getX(), model.getY());
		
		int d = 20;
		int x = model.getX() - d/2;
		int y = model.getY() - d/2;
		g2d.fillOval(x, y, d, d);
		
		d = 10;
		x = model.getNullX() - d/2;
		y = model.getNullY() - d/2;
		g2d.fillOval(x, y, d, d);
	}
}
