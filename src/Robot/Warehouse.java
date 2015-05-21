package Robot;

public class Warehouse{
	private Point p;
	public Warehouse(int x, int y) {
		p=new Point(x,y);
		// TODO Auto-generated constructor stub
	}
	
	public int getX() {
		return p.x;
	}

	public int getY() {
		return p.y;
	}

	public void setX(int value) {
		this.p.x = value;
	}

	public void setY(int value) {
		this.p.y = value;
	}

}
