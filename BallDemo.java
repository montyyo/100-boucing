import java.awt.Color;
import java.util.Random;
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
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        //metodo aleatorio 
        Random rnd = new Random();
        
        
        //array de nombres
        ArrayList<BouncingBall> ballsList = new ArrayList<>();
        
        //array de colores
        
        
        // crate and show the balls, con bucle for
        for(int i =0; i < numberOfBalls;i++)
        {
            int ejex = rnd.nextInt(50);
            int ejey = rnd.nextInt(50);
            int radio = rnd.nextInt(80);
            int r = rnd.nextInt(255);
            int g = rnd.nextInt(255);
            int b = rnd.nextInt(255);
            
            ballsList.add( new BouncingBall(ejex, ejey, radio, new Color(r,g,b), ground, myCanvas)); 
            ballsList.get(i).draw();
        }
        
        //BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        //ball.draw();
        // BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        // ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            
            for(int i = 0; i < numberOfBalls;i++)
            {
              myCanvas.wait(50);           // small delay
            
            
               ballsList.get(i).move();
              
            }
            //myCanvas.wait(50);           // small delay
            
            
            //ball.move();
            //ball2.move();
            // stop once ball has travelled a certain distance on x axis
            //|| ball2.getXPosition() >= 550
            if( ballsList.get(numberOfBalls-1).getXPosition() >= 550 ) {
                finished = true;
            }
        }
    }
}
