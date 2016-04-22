
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
public class PlayerPaddleUp {
    double x;
    double y;
    int width = 40;
    int height = 15;
    double speed=0.10;
    Rectangle boundingBox;
    boolean goingLeft = false;
    boolean goingRight = false; 
    boolean is4Player;
    int diff_level;
    
    public PlayerPaddleUp(double x, double y){
        this.x = x;
        this.y = y;
        boundingBox = new Rectangle((int)x,(int)y,width,height);
        boundingBox.setBounds((int)x,(int)y,width,height);
  
    }
    public void tick (Game game){
        System.out.println("speed = "+ speed);
        boundingBox.setBounds((int)x,(int)y,width,height);
        if(!is4Player){
            if(diff_level ==1){
                speed = 0.09;
            }
            else if(diff_level ==2){
                speed = 0.10;
            }
            else if(diff_level ==3){
                speed = 0.11;
            }
            
            if(game.ball.x < x && x >0){
                x = x- speed;
            }
            if(game.ball.x > x && x + width < game.getWidth()){
                x = x+ speed;
            }
            /*x=game.ball.x-(width/2)+8;*/
            if(x <25){
                x = 25;
            }
            if(x + width > game.getWidth()-25){
                x = - width + game.getWidth()-25;
            }
        }
        else{
            if(goingLeft && x >10){
                x -=speed;
            }
            else if(goingRight && x + width < game.getWidth()-10){
                x+=speed; 
            }
        }
    }
    public void render ( Graphics g){
        g.setColor(Color.blue);
        g.fillRect( (int)x, (int)y, width, height);
    }
}
