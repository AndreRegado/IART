package Astar;

import Robot.Point;

public class State {
	
	private Point p;
	private double f; 
	private double g;
	private double h;
	private Point parent;
	
	public State(int x, int y) {
		p=new Point(x,y);
		// TODO Auto-generated constructor stub
	}
	
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public double getF() {
		return f;
	}
	
	public double getG() {
		return g;
	}
	
	public double getH() {
		return h;
	}
	
	public void setF(double value) {
		this.f = value;
	}
	
	public void setH(double value) {
		this.h = value;
	}
	
	public void setG(double value) {
		this.g = value;
	}
	
	public Point getParent() {
		return parent;
	}

	public void setParent(Point parent) {
		this.parent = parent;
	}
}
