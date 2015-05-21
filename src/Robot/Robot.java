package Robot;

public class Robot{
	private Point p;
	private float capacity;
	public Robot(int x, int y, float cap) {
		p=new Point(x,y);
		capacity=cap;
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return p.x;
	}

	public int getY() {
		return p.y;
	}
	public float getCap(){
		return capacity;
	}

}
