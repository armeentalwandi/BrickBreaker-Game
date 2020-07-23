package brickBreaker;
import javax.swing.JFrame;

public class Main {


    public static void main(String[]args) {
        //make the window
        JFrame obj = new JFrame();

        //create gameplay object using the Gameplay class
        //then we have to add that gameplay panel to the JFrame

        Gameplay gamePlay = new Gameplay();

        //set properties of JFrame
        obj.setBounds(10,10,700, 600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding the gameplay panel to the Frame
        obj.add(gamePlay);
        //window made
    }
}

