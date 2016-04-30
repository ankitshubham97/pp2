
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANKIT
 */
public class Ball {
    double x,y;
    int size =16;
    double vx,vy;
    double speed = 0.10;
    Rectangle boundingBox;
    //int range = (max - min) + 1;     
    //return (int)(Math.random() * range) + min;
    int max=7;
    int min=0;
    int range = (max - min) + 1;     
    
    
    public Ball(double x, double y ){
        this.x = x;
        this.y = y;
        vx = speed;
        vy = speed;
        boundingBox = new Rectangle((int)x,(int)y,size,size);
        boundingBox.setBounds((int)x,(int)y,size,size);
    }
    
    //this facilitates general motion of the ball
    public void tick (Game game){
        boundingBox.setBounds((int)x,(int)y,size,size);
         if(x<=0){
             game.p1score= game.p1score-1;
             //score down
             vx = speed ;
         }
         else if(x + size >=game.getWidth()){
             game.p2score= game.p2score-1;
             //score down
             vx = - speed ;
         }
         if(y <= 0){
             game.p3score= game.p3score-1;
             //score down
             vy = speed;
         }
         else if (y + size >=game.getHeight()){
             game.p4score= game.p4score-1;
             vy = - speed;
         }
        
        x = x+vx;
        y = y+vy;
        
        //call to check its collision with paddle
        paddleCollide(game);
    }
    
    private void paddleCollide(Game game){
        int rand1 = (int)(Math.random() * range) + min-2;
         double rand = (double)rand1/100;
         
        //below code detect the collision in the 4 possible cases
        if(boundingBox.intersects(game.player.boundingBox)){
            vx = speed+rand;
            
        }
        else if(boundingBox.intersects(game.ai.boundingBox)){
            vx = -speed+rand;
        }
        else if(boundingBox.intersects(game.playerup.boundingBox)){
            vy = speed+rand;
        }
        else if(boundingBox.intersects(game.playerdown.boundingBox)){
            vy = -speed+rand;
        }
    }
    
    //painting the modified stuff
     public void render (Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)x, (int)y, size, size);
    }
    
}

