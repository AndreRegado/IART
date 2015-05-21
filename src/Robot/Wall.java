package Robot;

import java.util.ArrayList;

public class Wall{
	private Point p1;
	private Point p2;
	//Vai ser preciso criar 2 pontos para contruir a "parede"
	public Wall(int x1, int y1, int x2, int y2) {
		
		// TODO Auto-generated constructor stub
	}
	
	public int getX1() {
		return p1.x;
	}

	public int getY1() {
		return p1.y;
	}
	public int getX2() {
		return p2.x;
	}
	public int getY2() {
		return p2.y;
	}
	public ArrayList<Point> getCoord(){
		ArrayList<Point> x = new ArrayList<Point>();
		x.add(p1);
		x.add(p2);
		return x;
	}

}
