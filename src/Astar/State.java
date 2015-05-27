package Astar;

import java.util.Comparator;

import Robot.Point;

public class State implements Comparable<State>{
	
	private Point p;
	private int f; 
	private int g;
	private int h;
	private State parent;
	
	public State(int x, int y) {
		p=new Point(x,y);
		// TODO Auto-generated constructor stub
	}
	public State(int x, int y,State pai,int g1, int h1) {
		p=new Point(x,y);
		parent=pai;
		g=g1;
		h=h1;
		f=g+h;
		// TODO Auto-generated constructor stub
	}
	public Point getPoint(){
		return p;
	}
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public int getF() {
		return f;
	}
	
	public int getG() {
		return g;
	}
	
	public int getH() {
		return h;
	}
	
	public void setF(int value) {
		this.f = value;
	}
	
	public void setH(int value) {
		this.h = value;
	}
	
	public void setG(int value) {
		this.g = value;
	}
	
	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}
	public boolean comparar(State estado){
		if(this.getX()==estado.getX() && this.getY()==estado.getY())
			return true;
		return false;
	}
	public int compareTo(State estado) {
		 
		int compare = ((State) estado).getF(); 
 
		//ascendente
		return this.getF() - compare;
 
 
	}
	
	
	
	public static Comparator<State> StateComparator = new Comparator<State>() {
		public int compare(State estado1, State estado2) {
			return estado1.compareTo(estado2);
		}

	};
}
