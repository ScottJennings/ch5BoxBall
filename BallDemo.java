import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Rectangle bounds;
    private int numBalls;
    ArrayList<BoxBall> ballsInPlay;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo(int balls)
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bounds = new Rectangle(50, 50, 500, 400);
        myCanvas.draw(bounds);
        numBalls = balls;
        ballsInPlay = new ArrayList<BoxBall>();
    }

    public void boxBounce(){
        
        // create the balls and put them in a list
        for (int i=0; i<numBalls; i++) {
            BoxBall ball = new BoxBall(24, Color.BLUE, myCanvas, bounds);
            ball.draw();
            ballsInPlay.add(ball);
        }
        
        // move the balls
        while(true) {
            myCanvas.wait(50);           // small delay
            for (BoxBall currBall : ballsInPlay) {
                currBall.move();
            }
        }
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
