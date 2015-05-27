package Robot;
import java.util.ArrayList;
import java.util.List;

import Parser.Reader;
import Astar.A_star;
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
	        

	        List<Point> obs = new ArrayList<Point>();
	        List<Point> o = new ArrayList<Point>();
	        for(Wall obstaculos : obstacles){
	        	State initial = new State (obstaculos.getX1(),obstaculos.getY1(),null,0,0);
		        State target =  new State (obstaculos.getX2(),obstaculos.getY2());
		        A_star A = new A_star(initial, target, o, "Manhattan","4d");
		        obs.addAll(A.start());
		       // A.printList();
	        }
	        
	        State initial = new State (rob.getX(),rob.getY(),null,0,0);
	        State target =  new State (5,5);
	        A_star B = new A_star(initial, target, obs, "Diagonal","8d");
	        B.start();
	        B.printList();
	        
	        
	    }
	   


}
