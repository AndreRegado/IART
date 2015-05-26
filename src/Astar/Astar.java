package Astar;

import java.util.ArrayList;
import java.util.List;

import Robot.Wall;

public class Astar {

	List<State> openList = new ArrayList<State>();
	List<State> closeList = new ArrayList<State>();

	// calcula a distancia em linha reta entre a origem ao destino
	public double Heuristic(State initial, State target) {

		double result;
		result = Math.sqrt(Math.pow((target.getX() - initial.getX()), 2) + Math.pow((target.getY() - initial.getY()), 2));

		return result;
		
	}

	public State getLowF() {

		double menor = 9999;
		State state = null;
		for (int i = 0; i < openList.size(); i++) {
			if (openList.get(i).getF() < menor) {
				menor = openList.get(i).getF();
				state = openList.get(i);
			}
		}

		return state;
	}
	
public boolean ExistObstacles(int x, int y, List<Wall> obstacles) {
		
		for(int i =0; i < obstacles.size(); i++) {
			
			//esta na horizontal
			if(obstacles.get(i).getY2() == obstacles.get(i).getY1()  && obstacles.get(i).getY1() == y) {
				if(obstacles.get(i).getX2() - obstacles.get(i).getX1() > 0)
					if(x <= obstacles.get(i).getX2() && x >= obstacles.get(i).getX1()){
						return true;
						
					}
				else {
					if(x <= obstacles.get(i).getX1() && x >= obstacles.get(i).getX2()){
						return true;
					}
				}
				continue;
			}
			//esta na vertical
			else if (obstacles.get(i).getX2() == obstacles.get(i).getX1() && obstacles.get(i).getX1() == x) {
				if(obstacles.get(i).getY2() - obstacles.get(i).getY1() > 0)
					if(y <= obstacles.get(i).getY2() && y >= obstacles.get(i).getY1()){
						return true;
					}
				else {
					if(y <= obstacles.get(i).getY1() && y >= obstacles.get(i).getY2()){
						return true;
					}
				}
				continue;
			}
			/*else {
				if((obstacles.get(i).getY2() - obstacles.get(i).getY1() > 0 && y <= obstacles.get(i).getY2() && y >= obstacles.get(i).getY1()) ||  (obstacles.get(i).getY2() - obstacles.get(i).getY1() < 0 && y <= obstacles.get(i).getY1() && y >= obstacles.get(i).getY2())) {
					//eq da reta: y = mx+b
					float m = (obstacles.get(i).getY2()- obstacles.get(i).getY1()) / (obstacles.get(i).getX2()-obstacles.get(i).getX1());
					float b = obstacles.get(i).getY1() - m * obstacles.get(i).getX1();
					
					float reta =m*x+b;
					
					System.out.print("M- " + m + " B- " + b +" X- "+x+"Y- "+y +" ");
					
					System.out.print(Math.floor((y-b)/m));
					if(x ==  (y-b)/m || x ==  Math.floor((y-b)/m)+1 || x == Math.floor((y-b)/m)-1) {
						System.out.println(" OBS");
						return true;
					}
					System.out.print("\n");
				}
			}*/
			
			/*if(obstacles.get(i).getX1() == x && obstacles.get(i).getY1() == y ||
					obstacles.get(i).getX2() == x && obstacles.get(i).getY2() == y ){
				return true;
			}*/
		}
		
		return false;
	}

	public boolean Exist(int x, int y, List<Wall> obstacles) {
		
		for (int i = 0; i < closeList.size(); i++) {
			
			if (closeList.get(i).getX() == x && closeList.get(i).getY() == y) {
				return true;
			}
			
		}
		
		if(ExistObstacles(x,y,obstacles)) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean ChegouDestino(State target) {

		for (int i = 0; i < closeList.size(); i++) {
			if (closeList.get(i).getX() == target.getX() && closeList.get(i).getY() == target.getY()) {
				return true;
			}
		}
		return false;
	}

	public void printList() {

		for (int i = 0; i < closeList.size(); i++) {
			System.out.println(closeList.get(i).getX());
			System.out.println(closeList.get(i).getY());
		}
	}

	public void AStar(State initial, State target, List<Wall> obstacles) {

		// Limpar as listas
		openList.clear();
		closeList.clear();

		// adionar o ponto inicial a lista aberta
		openList.add(initial);

		int times = 0;

		while (!openList.isEmpty()) {
			
			
			// escolher o que tem o f mais baixo do que esta na lista aberta e
			// meter na fechada
			if (times > 0) {
				State Move = getLowF();
				initial=Move;
				closeList.add(Move);
				openList.remove(Move);

				// Limpar as lista open
				openList.clear();
			}
			//printList();
			//System.out.println("MUDA");
			
			// hipotese 1 X+1
			int x1 = initial.getX() + 1;
			int y = initial.getY();
			if (!Exist(x1, y, obstacles)) {
				State h1 = new State(x1, y);
				h1.setG(1);
				h1.setH(Heuristic(h1, target));
				h1.setF(h1.getG() + h1.getH());
				openList.add(h1);
			}
			else {
				System.out.println("PO CRL");
			}
			

			// hipotese 2 Y+1
			int x = initial.getX();
			int y1 = initial.getY() + 1;
			if (!Exist(x, y1, obstacles)) {
				State h2 = new State(x, y1);
				h2.setG(1);
				h2.setH(Heuristic(h2, target));
				h2.setF(h2.getG() + h2.getH());
				openList.add(h2);
			}
			
			// hipotese 3 X-1
			int x11 = initial.getX() - 1;
			if (!Exist(x11, y, obstacles)) {
				State h3 = new State(x11, y);
				h3.setG(1);
				h3.setH(Heuristic(h3, target));
				h3.setF(h3.getG() + h3.getH());
				openList.add(h3);
			}
			
			// hipotese 4 Y-1
			int y11 = initial.getY() - 1;
			if (!Exist(x, y1, obstacles)) {
				State h4 = new State(x, y1);
				h4.setG(1);
				h4.setH(Heuristic(h4, target));
				h4.setF(h4.getG() + h4.getH());
				openList.add(h4);
			}
			

			// hipotese 5 X+1 e Y+1
			if (!Exist(x1, y1, obstacles)) {
				State h5 = new State(x1, y1);
				h5.setG(1);
				h5.setH(Heuristic(h5, target));
				h5.setF(h5.getG() + h5.getH());
				openList.add(h5);
			}
			
			// hipotese 6 X-1 e Y-1
			if (!Exist(x11, y11, obstacles)) {
				State h6 = new State(x11, y11);
				h6.setG(1);
				h6.setH(Heuristic(h6, target));
				h6.setF(h6.getG() + h6.getH());
				openList.add(h6);
			}

			// hipotese 7 X+1 e Y-1
			if (!Exist(x1, y11, obstacles)) {
				State h7 = new State(x1, y11);
				h7.setG(1);
				h7.setH(Heuristic(h7, target));
				h7.setF(h7.getG() + h7.getH());
				openList.add(h7);
			}
			
			// hipotese 8 X-1 e Y+1
			if (!Exist(x1, y1, obstacles)) {
				State h8 = new State(x1, y1);
				h8.setG(1);
				h8.setH(Heuristic(h8, target));
				h8.setF(h8.getG() + h8.getH());
				openList.add(h8);
			}

			if (times == 0) {
				// remover o pai inicial da lista aberta e meter na lista
				// fechada
				closeList.add(initial);
				openList.remove(initial);
			}
			times++;
			

			// quando o destino está na lista fechada, acaba o while
			if (ChegouDestino(target))
				break;

		}

	}
}
