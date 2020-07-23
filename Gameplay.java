package brickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    //add properties
    private boolean play = false;
    // once the game starts it shouldnt play byitself
    private int score = 0;
    // starting score should be 0

    private int totalBricks = 21;
    private Timer timer;
    // setting the speed of the ball

    private int delay = 8;

    // properties of the slider
    private int playerX = 310;
    // starting position of slider

    // starting position of ball
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    // direction of ball
    // constructor
    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

    }

    // using this graphics object we can draw different shapes
    public void paint(Graphics g) {
        // background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        // borders
        g.setColor(Color.yellow);
        // create 3 rectangles for the border
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // the paddle
        g.setColor(Color.orange);
        g.fillRect(playerX, 550, 100, 8);

        // the ball
        g.setColor(Color.orange);
        g.fillOval(ballposX, ballposY, 20, 20);


        g.dispose();

    }

    // keylisteners detect what key is pressed

    @Override
    public void actionPerformed(ActionEvent e) {
        //starts the timer and calls everything all over again
        //so when you move left or right, it needs to redraw the shapes

        timer.start();
        
        if(play){
        	ballposX += ballXdir;
        	ballposY += ballYdir;
        	
        	if (ballposX<0) {
        		ballXdir = -ballXdir;
        	}
         	if (ballposY<0) {
        		ballYdir = -ballYdir;
        	
        	}
         	if (ballposX > 670) {
        		ballXdir = -ballXdir;
        
        }
        }
        repaint();//calling the paint method again
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX >= 600) {
                playerX=600;
                //we dont want it going out of the panel
            }else {
                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX > 100) {
                playerX=10;
                //we dont want it going out of the panel
            }else {
                moveLeft();
            }
        }

    }
    public void moveRight() {
        play = true;
        playerX+= 15;
        //if right button pressed, it should move 20 pixels to the right side


        
    }
    public void moveLeft() {
        play = true;
        playerX-= 15;
        //if left button pressed, it should move 20 pixels to the left side


    }


//keylistener for moving the arrow keys
    // action listener for moving the ball
    // this class will be the panel which where we run our game
    // we need to add this gameplay panel to the Jframe in our main class

}
