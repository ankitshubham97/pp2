
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
 // This is the computer controlled paddle. 
public class AIPaddle {
    double x;
    double y;// coordinates 
    int width = 15;
    int height = 40;
    
    
    boolean goingUp = false;
    boolean goingDown = false; 
    Rectangle boundingBox;
    double speed=0.10;
    boolean is4Player = false;
    int diff_level;
    
    public AIPaddle(double x, double y){
        this.x = x;
        this.y = y;
        boundingBox = new Rectangle((int)x,(int)y,width,height);
        boundingBox.setBounds((int)x,(int)y,width,height); // bounding with rectangle, helpful while detecting colloision
        
    }
    public void tick (Game game){
        
        boundingBox.setBounds((int)x,(int)y,width,height);
        if(!is4Player){
            //setting speed for difficulty level
            if(diff_level ==1){
                speed = 0.09;
            }
            else if(diff_level ==2){
                speed = 0.10;
            }
            else if(diff_level ==3){
                speed = 0.11;
            }
            System.out.println("ai speed = "+ speed+"diff_level = "+diff_level);
            if(game.ball.y < y && y >0){
                y = y- speed;
            }
            if(game.ball.y > y && y + height < game.getHeight()){
                y = y+ speed;
            }
            //setting that paddle does not go out of game window
            if(y <25){
                y = 25;
            }
            if(y + height > game.getHeight()-25){
                y = - height + game.getHeight()-25;
            }
        }
        else{
            //moving the paddle
            if(goingUp && y >0){
                y -=speed;
            }
            else if(goingDown && y + height < game.getHeight()){
                y+=speed; 
            }
        }
        
    }
    //rendering the paddle
    public void render ( Graphics g){
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, width, height);
    }
}
