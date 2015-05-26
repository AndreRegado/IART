package Robot;
import java.util.ArrayList;

import java.util.List;

import Parser.Reader;
import Astar.Astar;
import Astar.State;
import Gui.Interface;
public class main {
	    public static void main(String[] args) {
	        System.out.println("Hello, World!");
	        Reader parser=new Reader();
	        
	        
	        List<Object> allobject=parser.readFile("input.txt");
	        
		    Interface intObj = new Interface();
	       
	        Robot rob=null;
	        Warehouse ware=null;
	        List<Boxes> boxes = new ArrayList<Boxes>();
	        List<Wall> obstacles = new ArrayList<Wall>();
	        System.out.println(allobject);
	        int size=allobject.size();
	        for(int counter=0; counter<size;counter++){
	        	Object what=allobject.get(counter);
	        	System.out.println(what);
	        	if(what instanceof Robot)
	        		rob=(Robot) what;
	        	else if(what instanceof Warehouse)
	        		ware=(Warehouse) what;
	        	else if(what instanceof Boxes)
	        		boxes.add((Boxes) what);
	        	else if(what instanceof Wall)
	        		obstacles.add((Wall) what);
	        	else{
	        		System.out.println("Argument error");
	        		System.exit(4);
	        	}
	        }
	        
	        System.out.println("MEUUU");
	        State initial = new State (1,1);
	        State target =  new State (4,1);
	        Astar A = new Astar();
	        A.AStar(initial, target, obstacles);
	        A.printList();
	    }
	   


}
