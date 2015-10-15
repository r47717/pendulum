package pendulumapp;

import java.util.*;

public class PendulumModel {
	private PendulumTools tools;
	private int length;
	private int speed;
	private double resistance;
	private final int WIDTH;
	private final int HEIGHT;
	private double time;
	private int nullX;
	private int nullY;
	private int posX;
	private int posY;
	
	public PendulumModel(int WIDTH, int HEIGHT, PendulumTools tools) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.tools = tools;
		
		nullX = WIDTH/2;
		nullY = HEIGHT/4;
		length = HEIGHT/2;
		posX = nullX;
		posY = nullY + length;
		speed = 15;
		time = 0;
		resistance = 0.05;
		tools.updateInfo(this.generateInfo());
	}

	public void step() {
		double dt = 0.01;
		time += dt;
		int x = (int)(length * Math.cos(time) * Math.exp(-time*resistance));
		int dx = (int)(-length * Math.exp(-time*resistance) * (Math.sin(time) + Math.cos(time) * resistance) * dt);
		x += dx;
		int y = (int)Math.sqrt(length*length - x*x); 
		
		posX = x + nullX;
		posY = y + nullY;
	}
	
	public void restart() {
		posX = nullX;
		posY = nullY + length;
		time = 0;
		tools.updateInfo(this.generateInfo());
	}
	
	public String generateInfo() {
		String str = "<html><table border=1>";
		str += "<tr><td>Length:</td><td>" + length + "</td></tr>";
		str += "<tr><td>Resistance:</td><td>" + resistance + "</td></tr>";
		str += "<tr><td>Speed:</td><td>" + speed + "</td></tr>";
		str += "</table></html>";
		
		return str;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
		tools.updateInfo(this.generateInfo());
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		tools.updateInfo(this.generateInfo());
	}
	
	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
		tools.updateInfo(this.generateInfo());
	}

	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public int getNullX() {
		return nullX;
	}
	
	public int getNullY() {
		return nullY;
	}
}
