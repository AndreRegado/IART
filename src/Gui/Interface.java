package Gui;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Gui.Pane;
import Robot.Box;
import Robot.Point;
import Robot.Robot;
import Robot.Warehouse;
public class Interface extends JFrame{
	

	private static final int WIDTH = 800;

	  private static final int HEIGHT = 600;
	  
	  JButton playB;
	  JButton exitB;
	  
	  private Pane background; 
	  private JLabel robot;
	  private JLabel obst2;
	  private JLabel box2;
	  private JLabel war2;
	  /*private JLabel rob = new JLabel(new ImageIcon("images/robot.png"));
	  private JPanel pane;*/
	  

	    //Button handlers:
	  	
	  	private PlayButtonHandler pbHandler;
	    private ExitButtonHandler ebHandler;
	 
	 public Interface(Robot ObjRobot, Warehouse ObjWare, List<Box> ObjBoxes, List<Point> ObjObstacles)

	    {	

	        setTitle("Robot box catching Simulator!");
	        setLayout(new BorderLayout());
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        
	        try {
				background = new Pane(ImageIO.read(new File("images/background.jpg")), 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        background.setLayout(null);
	        add(background);
	        
	        playB = new JButton("Run Simulation!");	
	        playB.setBounds(0, 550, 400, 50);
	        exitB = new JButton("Exit!");
	        exitB.setBounds(400, 550, 400, 50);
	        //exitB.setPreferredSize(new Dimension(60, 30)); 
	       
	        
	        pbHandler = new PlayButtonHandler();
	        ebHandler = new ExitButtonHandler();

	        playB.addActionListener(pbHandler);
	        exitB.addActionListener(ebHandler);  
	        
	        background.add(playB);
	        background.add(exitB);
	        
	        ImageIcon rob = new ImageIcon("images/robot.png");
			robot = new JLabel(rob);
			ImageIcon box = new ImageIcon("images/box.png");
			box2 = new JLabel(box);
			ImageIcon obst = new ImageIcon("images/obst.png");
			obst2 = new JLabel(obst);
			ImageIcon war = new ImageIcon("images/warehouse.png");
			war2 = new JLabel(war);
			
			List<Integer> ArrayX = new ArrayList<Integer>();
			List<Integer> ArrayY = new ArrayList<Integer>();
			
			ArrayX.add(ObjRobot.getX());
			ArrayY.add(ObjRobot.getY());
			ArrayX.add(ObjWare.getX());
			ArrayY.add(ObjWare.getY());
			
			//System.out.println("ROBOT: " + ObjRobot.getX() + ObjRobot.getY() + " ARMAZZEM: " + ObjWare.getX()+ ObjWare.getY());
			
	       for(int i =0; i < ObjBoxes.size(); i++) {
	    	   ArrayX.add(ObjBoxes.get(i).getX());
	    	   ArrayY.add(ObjBoxes.get(i).getY());
	    	   //System.out.println(ObjBoxes.get(i).getX() + ObjBoxes.get(i).getY());
	       }
	       
	       int maiorX = 0, maiorY = 0;
	       int menorX = 9999, menorY = 9999;
	       for(int p=0; p < ArrayX.size(); p++) {
	    	   if(ArrayX.get(p) > maiorX)
	    		   maiorX= ArrayX.get(p);
	    	   
	    	   if(ArrayX.get(p) < menorX)
	    		   menorX=ArrayX.get(p);
	    	  // System.out.println(ArrayX[p]);
	       }
	       
	       for(int l=0; l < ArrayY.size(); l++) {
	    	   if(ArrayY.get(l) > maiorY)
	    		   maiorY= ArrayY.get(l);
	    	   
	    	   if(ArrayX.get(l) < menorY)
	    		   menorY = ArrayX.get(l);
	    	   
	    	   //System.out.println(ArrayY[l]);
	       }
	       
	       for(int k=0; k < ObjObstacles.size(); k++) {
	    	   if(ObjObstacles.get(k).x > maiorX) 
	    		   maiorX = ObjObstacles.get(k).x;
	    	   
	    	   if(ObjObstacles.get(k).x < menorX)
	    		   menorX = ObjObstacles.get(k).x;
	    	   
	    	   if(ObjObstacles.get(k).y > maiorY)
	    		   maiorY = ObjObstacles.get(k).y;
	    	   
	    	   if(ObjObstacles.get(k).y < menorY)
	    		   menorY = ObjObstacles.get(k).y;
	       }
	     
			//System.out.println("MAIOR X" + maiorX + " MAior Y" + maiorY + " MEnor X" + menorX + " MenorY"+menorY);
	        
			maiorX += 2;
			maiorY += 2;
		    menorX -= 2; 
		    menorY -= 2;
			
		    int dimensaoX = maiorX - menorX;
		    int dimensaoY = maiorY - menorY;
		    //System.out.println("Dim X" + dimensaoX + " Dim Y" + dimensaoY);
		    
		    int tamanhoX = 800 / dimensaoX;
		    int tamanhoY = 600 / dimensaoY;
		    //System.out.println("TAM X" + tamanhoX + " TAM Y" + tamanhoY);
		    
	        robot.setLayout(null);
	        robot.setBounds((ObjRobot.getX()+1)*tamanhoX, (ObjRobot.getY()+1)*tamanhoY,tamanhoX, tamanhoY);
	        
	        for(int i=0; i< ObjBoxes.size(); i++){
	        	JLabel newLabel = new JLabel(box);
	        	newLabel.setLayout(null);
	        	newLabel.setBounds((ObjBoxes.get(i).getX()+1)*tamanhoX, (ObjBoxes.get(i).getY()+1)*tamanhoY, tamanhoX, tamanhoY);
	        	background.add(newLabel);
	        }
	        
	        for(int i=0; i< ObjObstacles.size(); i++){
	        	JLabel newLabel = new JLabel(obst);
	        	newLabel.setLayout(null);
	        	newLabel.setBounds((ObjObstacles.get(i).x+1)*tamanhoX, (ObjObstacles.get(i).y+1)*tamanhoY, tamanhoX, tamanhoY);
	        	background.add(newLabel);
	        }
	        
	        war2.setLayout(null);
	        war2.setBounds((ObjWare.getX()+1)*tamanhoX, (ObjWare.getY()+1)*tamanhoY, tamanhoX, tamanhoY);
	        
	        background.add(robot);
	        background.add(war2);
	        
	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);

	    }
	 
	 public class ExitButtonHandler implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {

	            System.exit(0);

	        }
	    }
	 
	 public class PlayButtonHandler implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {

	            System.exit(0);

	        }
	    }
	 
}
