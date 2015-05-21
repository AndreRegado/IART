package Robot;

public class Box{
 private Point p;
 private float weight;
	public Box(int x, int y, float w) {
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
	public float getWeight(){
		return weight;
	}
}
