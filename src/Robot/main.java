package Robot;
import Parser.Reader;
import Astar.Astar;
import Astar.State;
public class main {
	    public static void main(String[] args) {
	        System.out.println("Hello, World!");
	        Reader parser=new Reader();
	        parser.readFile("input.txt");
	        
	        State initial = new State (1,1);
	        State target =  new State (3,3);
	        Astar A = new Astar();
	        A.AStar(initial, target);
	        A.printList();
	    }

}
