package Astar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Astar {

	PriorityQueue<State> openList = new PriorityQueue<State>();
    List<State> closeList = new ArrayList<State>();
		
    //calcula a distancia em linha reta entre a origem ao destino
    public double Heuristic(State initial, State target) {
    	
    	double result;
    	result = Math.sqrt(Math.pow(target.getX()-initial.getX(),2) + (Math.pow(target.getY()-target.getY(),2)));
    	
    	return result;
    }
    
  
    public void printList() {
    	
    	for(int i=0; i < closeList.size(); i++) {
    		System.out.println(closeList.get(i).getX());
    		System.out.println(" ");
    		System.out.println(closeList.get(i).getY());
    	}
    }
    
    public void Astar(State initial, State target) {
    	
    	//Limpar as listas
    	openList.clear();
    	closeList.clear();
    	
    	//adionar o ponto inicial a lista aberta
    	openList.add(initial);
    	
    	int times=0;
    	
    	while(!openList.isEmpty()) {
    		
    		//escolher o que tem o f mais baixo do que esta na lista aberta e meter na fechada
    		//closeList.add();
    		openList.remove();
    		
    		//Limpar as lista open
        	openList.clear();
    		
    		//hipotese 1  X+1
    		int x1 = initial.getX()+1;
    		int y = initial.getY();
    		State h1 = new State(x1, y);
    		h1.setG(1);
    		h1.setH(Heuristic(initial, h1));
    		h1.setF(h1.getG()+ h1.getH());
    		openList.add(h1);
    		
    		//hipotese 2 Y+1
    		int x = initial.getX();
    		int y1 = initial.getY()+1;
    		State h2 = new State(x, y1);
    		h2.setG(1);
    		h2.setH(Heuristic(initial, h2));
    		h2.setF(h2.getG()+ h2.getH());
    		openList.add(h2);
    		
    		//hipotese 3 X-1
    		int x11 = initial.getX()-1;
    		State h3 = new State(x11, y);
    		h3.setG(1);
    		h3.setH(Heuristic(initial, h3));
    		h3.setF(h3.getG()+ h3.getH());
    		openList.add(h3);
    		
    		//hipotese 4 Y-1
    		int y11 = initial.getY()-1;
    		State h4 = new State(x, y11);
    		h4.setG(1);
    		h4.setH(Heuristic(initial, h4));
    		h4.setF(h4.getG()+ h4.getH());
    		openList.add(h4);
    		
    		//hipotese 5 X+1 e Y+1
    		State h5 = new State(x1, y1);
    		h5.setG(1);
    		h5.setH(Heuristic(initial, h5));
    		h5.setF(h5.getG()+ h5.getH());
    		openList.add(h5);
    		
    		//hipotese 6 X-1 e Y-1
    		State h6 = new State(x11, y11);
    		h6.setG(1);
    		h6.setH(Heuristic(initial, h6));
    		h6.setF(h6.getG()+ h6.getH());
    		openList.add(h6);
    		
    		//hipotese 7 X+1 e Y-1
    		State h7 = new State(x1, y11);
    		h7.setG(1);
    		h7.setH(Heuristic(initial, h7));
    		h7.setF(h7.getG()+ h7.getH());
    		openList.add(h7);
    		
    		//hipotese 8 X-1 e Y+1
    		State h8 = new State(x11, y1);
    		h8.setG(1);
    		h8.setH(Heuristic(initial, h8));
    		h8.setF(h8.getG()+ h8.getH());
    		openList.add(h8);
    		
    		
    		if(times == 0) {
    		//remover o pai inicial da lista aberta e meter na lista fechada
    		closeList.add(initial);
    		openList.remove(initial);
    		} 
    		times++;    		
    		
    		//quando o destino está na lista fechada, acaba o while
    		if(closeList.contains(target))
    			break;
    		
    	}
    	
    }
}
