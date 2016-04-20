
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
    
    public Ball(double x, double y ){
        this.x = x;
        this.y = y;
        vx = speed;
        vy = speed;
        boundingBox = new Rectangle((int)x,(int)y,size,size);
        boundingBox.setBounds((int)x,(int)y,size,size);
    }
    public void tick (Game game){
        boundingBox.setBounds((int)x,(int)y,size,size);
         if(x<=0){
             game.p1score= game.p1score-1;
             vx = speed;
         }
         else if(x + size >=game.getWidth()){
             game.p2score= game.p2score-1;
             vx = - speed;
         }
         if(y <= 0){
             game.p3score= game.p3score-1;
             vy = speed;
         }
         else if (y + size >=game.getHeight()){
             game.p4score= game.p4score-1;
             vy = - speed;
         }
        
        x = x+vx;
        y = y+vy;
        
        paddleCollide(game);
    }
    
    private void paddleCollide(Game game){
        if(boundingBox.intersects(game.player.boundingBox)){
            vx = speed;
            
        }
        else if(boundingBox.intersects(game.ai.boundingBox)){
            vx = -speed;
        }
        else if(boundingBox.intersects(game.playerup.boundingBox)){
            vy = speed;
        }
        else if(boundingBox.intersects(game.playerdown.boundingBox)){
            vy = -speed;
        }
    }
     public void render (Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)x, (int)y, size, size);
    }
    
}

