package Robot;
import java.util.ArrayList;
import java.util.List;

import Parser.Reader;
import Astar.Astar;
import Astar.State;
public class main {
	    public static void main(String[] args) {
	        System.out.println("Hello, World!");
	        Reader parser=new Reader();
	        
	        List<Object> allobject=parser.readFile("input.txt");
	        
	        Robot rob=null;
	        Warehouse ware=null;
	        List<Box> boxes = new ArrayList<Box>();
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
	        	else if(what instanceof Box)
	        		boxes.add((Box) what);
	        	else if(what instanceof Wall)
	        		obstacles.add((Wall) what);
	        	else{
	        		System.out.println("Argument error");
	        		System.exit(4);
	        	}
	        }
	        
	        
	        State initial = new State (1,1);
	        State target =  new State (3,3);
	        Astar A = new Astar();
	        A.AStar(initial, target);
	        A.printList();
	    }

}
