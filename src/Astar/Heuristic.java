package Astar;

public class Heuristic {

	public int Manhattan(State estado, State goal){
		 return 10*(Math.abs(estado.getX()-goal.getX()) + Math.abs(estado.getY()-goal.getY()));
	}
	
	public int Diagonal(State estado, State goal){
		int x = Math.abs(estado.getX()-goal.getX());
		int y = Math.abs(estado.getY()-goal.getY());
				if (x > y)
				     return 14*y + 10*(x-y);
				else
				     return 14*x + 10*(y-x);
	}
}
