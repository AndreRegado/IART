package Gui;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Gui.Pane;
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
	 
	 public Interface()

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
	        playB.setBounds(100, 550, 140, 50);
	        exitB = new JButton("Exit!");
	        exitB.setBounds(300, 550, 140, 50);
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
			
			
	        
	        robot.setLayout(null);
	        robot.setBounds(1, 1, 35, 35);
	        box2.setLayout(null);
	        box2.setBounds(120, 120, 55, 55);
	        obst2.setLayout(null);
	        obst2.setBounds(320, 320, 55, 55);
	        war2.setLayout(null);
	        war2.setBounds(240, 240, 55, 55);
	        background.add(robot);
	        background.add(box2);
	        background.add(obst2);
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
