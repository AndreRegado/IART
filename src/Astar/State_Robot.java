package Astar;

public class State_Robot extends State {
	private int boxes_picked;
	private int weight;
	private int current_weight;
	public State_Robot(int x, int y,int weight,int g1, int h1,State_Robot estado_pai) {
		super(x, y, estado_pai, g1, h1);
		this.weight = weight;
		boxes_picked = 0;
		current_weight = weight;
		// TODO Auto-generated constructor stub
	}
	public int getCurrentWeight(){
		return current_weight;
	}
	public void incBoxesPicked(){
		boxes_picked++;
	}
	public int getWeight(){
		return weight;
	}
	public void setCurrentWeight(int w){
		current_weight=w;
	}
	public int getBoxesPicked(){
		return boxes_picked;
	}

}
