package Astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Robot.Box;
import Robot.Point;

public class A_star_Robot {
	private List<State> openList = new ArrayList<State>();
	private List<State> closeList = new ArrayList<State>();
	private List<Point> points = new ArrayList<Point>();
	private List<Point> path1 = new ArrayList<Point>();
	private List<State> boxes = new ArrayList<State>();
	private Heuristic heuristic = new Heuristic();
	private State goal,inicio;
	int maxCost,totalBoxes;
	
	String heuristicOption;
	public A_star_Robot(State inicial, State goal1, String heuristicOpt,List<Box> box){

		for(Box caixa:box){
			boxes.add(boxtoState(caixa));
		}
		totalBoxes=box.size();
		inicio=inicial;
		goal=goal1;
		heuristicOption=heuristicOpt;
		openList.clear();
		closeList.clear();
		openList.add(inicial);
	}
	public List<Point> start(){
		State present = null;
		while(!openList.isEmpty()){
			
			present= openList.get(0);
			closeList.add(present);
			openList.remove(0);
			if(getSurrounding(present)==1)
				break;
			
			
		}
		maxCost=goal.getF();
		backtrack(goal);
		points.remove(points.size() -1);
		
		return points;
	}
	public int getCost(){
		return goal.getF();
	}
	private void backtrack(State estado){
			
		if(!estado.comparar(inicio)){
			backtrack(estado.getParent());
		}
		points.add(estado.getPoint());
	}
	public void printList(){
		for(Point point : points){
			System.out.println("X: "+point.x+" , Y: "+point.y);
		}

	}
	private State boxtoState(Box caixa){
		State estado = new State(caixa.getX(), caixa.getY(), null, 0, 0,caixa.getWeight(),null);
		return estado;
	}
	private int getSurrounding(State estado){
		
		for(State novoestado: boxes){
			if(!novoestado.comparar(estado)){
				checkPoint(estado, novoestado);
			}
		}
		if(estado.getCurrentWeight()!=0)
			checkPoint(estado, goal);
		Collections.sort(openList,State.StateComparator);
		State ne =openList.get(0);
		if(ne.comparar(goal) && ne.getboxCounter()==totalBoxes)
		{
			goal.setParent(ne);
			goal.setF(ne.getF());
			return 1;
		}
		return 0;
	}
	private int checkPoint(State estado, State estadonovo){
		
		//State estadonovo= new State(ponto.x,ponto.y, estado,0,0);
		
		//////////////////////////7777
		//calcular h e g e f
		int g=findG(estado,estadonovo),h=findH(estadonovo),f=g+h;
		estadonovo.setG(g);
		estadonovo.setPath(path1);
		///////////////////////////////////heuristica
		estadonovo.setH(h);	
		estadonovo.setF(f);
						
		
		int index,sizeOpen=openList.size(),sizeClose=closeList.size();
		if(openList.contains(estadonovo)){
			for(index=0;index<sizeOpen;index++){
				if(openList.get(index).getPoint().equals(estadonovo.getPoint())){
					if(openList.get(index).getF()>estadonovo.getF()){
						openList.remove(index);
						openList.add(estadonovo);
						return 0;
					}
					return 0;
				}		
			}
		}
		if(closeList.contains(estadonovo)){
			for(index=0;index<sizeClose;index++){
				if(closeList.get(index).getPoint().equals(estadonovo.getPoint())){
					if(closeList.get(index).getF()>estadonovo.getF()){
						closeList.remove(index);
						closeList.add(estadonovo);
						return 0;
					}
					return 0;
				}		
			}
		}
		
		openList.add(estadonovo);
		return 0;
	}
	private int findG(State estado,State novoestado){
		path1.clear();
		State initial = new State (estado.getX(),estado.getY(),null,0,0);
    	State target =  new State (novoestado.getX(),novoestado.getY());
    	List<Point> paredes = new ArrayList<Point>();
    	A_star B = new A_star(initial, target, paredes, "Diagonal","8d");
    	path1=B.start();
    	return B.getCost()+estado.getG();
	}
	private int findH(State estado){
		return 0;
	}
	

}
