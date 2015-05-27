package Astar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Robot.Point;


public class A_star {
	List<State> openList = new ArrayList<State>();
	List<State> closeList = new ArrayList<State>();
	List<Point> obstacles = new ArrayList<Point>();
	List<Point> points = new ArrayList<Point>();
	Heuristic heuristic = new Heuristic();
	State goal,inicio;
	
	String heuristicOption,directions;
	public A_star(State inicial, State goal1,List<Point> obs, String heuristicOpt, String direction){
		directions=direction;
		inicio=inicial;
		goal=goal1;
		heuristicOption=heuristicOpt;
		obstacles=obs;
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
		backtrack(goal);
		return points;
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
	private int getSurrounding(State estado){
		Point ponto = new Point(estado.getX(),estado.getY());
		ponto.x-=1;
		ponto.y-=1;
		checkPoint(estado, ponto,true);
		
		ponto.y+=1;
		checkPoint(estado, ponto,false);
		
		ponto.y+=1;
		checkPoint(estado, ponto,true);
		
		ponto.x+=1;
		checkPoint(estado, ponto,false);
		
		ponto.x+=1;
		checkPoint(estado, ponto,true);
		
		ponto.y-=1;
		checkPoint(estado, ponto,false);
		
		ponto.y-=1;
		checkPoint(estado, ponto,true);
		
		ponto.x-=1;
		checkPoint(estado, ponto,false);
		
		Collections.sort(openList,State.StateComparator);
		State ne =openList.get(0);
		if(ne.comparar(goal))
		{
			goal.setParent(ne);
			return 1;
		}
		return 0;
	}
	private int checkPoint(State estado, Point ponto,boolean diagonal){
		if(diagonal && directions.equals("4d"))
			return 0;
		State estadonovo= new State(ponto.x,ponto.y, estado,0,0);
		if(closeList.contains(estadonovo))
			return 0;
		if(isWall(ponto))
			return 0;
		//////////////////////////7777
		//calcular h e g e f
		int g=findG(diagonal,estado),h=findH(estadonovo),f=g+h;
		estadonovo.setG(g);
		///////////////////////////////////heuristica
		estadonovo.setH(h);	
		estadonovo.setF(f);
						
		
		int index,sizeOpen=openList.size(),sizeClose=closeList.size();
		for(index=0;index<sizeOpen;index++){
			if(openList.get(index).getPoint().equals(estadonovo.getPoint())){
				if(openList.get(index).getF()>estadonovo.getF()){
					openList.remove(index);
					openList.add(estadonovo);
					return 0;
				}
				break;
			}
				
		}
		
			
			
		
		openList.add(estadonovo);
		return 0;
	}
	private int findG(boolean diag,State estado){
		if(!diag)
			return estado.getG()+10;
		else
			return estado.getG()+14;
		
	}
	private int findH(State estado){
		if(heuristicOption.equals("Manhattan"))
			return heuristic.Manhattan(estado, goal);
		else
			return heuristic.Diagonal(estado, goal);
	}
	private boolean isWall(Point ponto){
		if(!obstacles.isEmpty())
			if(obstacles.contains(ponto))
				return true;
		return false;
	}

}
