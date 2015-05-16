package Robot;

public class Wall extends Point {

	//Vai ser preciso criar 2 pontos para contruir a "parede"
	public Wall(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int value) {
		this.x = value;
	}

	public void setY(int value) {
		this.y = value;
	}

}
