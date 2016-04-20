
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
    double speed =0.15;
    Rectangle boundingBox;
    boolean goingLeft = false;
    boolean goingRight = false; 
    boolean is4Player;
    
    public PlayerPaddleUp(double x, double y){
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
            x=game.ball.x-(width/2)+8;
            if(x <0){
                x = 0;
            }
            if(x + width > game.getWidth()){
                x = - width + game.getWidth();
            }
        }
        else{
            if(goingLeft && x >0){
                x -=speed;
            }
            else if(goingRight && x + width < game.getWidth()){
                x+=speed; 
            }
        }
    }
    public void render ( Graphics g){
        g.setColor(Color.blue);
        g.fillRect( (int)x, (int)y, width, height);
    }
}
