package Robot;

public class Box{
 private Point p;
 private int weight;
	public Box(int x, int y, int w) {
		p=new Point(x,y);
		weight=w;
		// TODO Auto-generated constructor stub
	}
	
	public int getX() {
		return p.x;
	}

	public int getY() {
		return p.y;
	}
	public int getWeight(){
		return weight;
	}
}
