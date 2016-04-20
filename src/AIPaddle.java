
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
public class AIPaddle {
    double x;
    double y;
    int width = 15;
    int height = 40;
    double speed = 0.15;
    
    boolean goingUp = false;
    boolean goingDown = false; 
    Rectangle boundingBox;
    
    boolean is4Player = false;
    
    public AIPaddle(double x, double y){
        this.x = x;
        this.y = y;
        boundingBox = new Rectangle((int)x,(int)y,width,height);
        boundingBox.setBounds((int)x,(int)y,width,height);
    }
    public void tick (Game game){
        boundingBox.setBounds((int)x,(int)y,width,height);
        if(!is4Player){
            /*if(game.ball.y < y && y >0){
                y = y- speed;
            }
            if(game.ball.y > y && y + height < game.getHeight()){
                y = y+ speed;
            }*/
            y=game.ball.y-(height/2)+8;
            if(y <0){
                y = 0;
            }
            if(y + height > game.getHeight()){
                y = - height + game.getHeight();
            }
        }
        else{
            if(goingUp && y >0){
                y -=speed;
            }
            else if(goingDown && y + height < game.getHeight()){
                y+=speed; 
            }
        }
        
    }
    public void render ( Graphics g){
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, width, height);
    }
}
