
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
public class PlayerPaddle {
    double x;
    double y;
    int width = 15;
    int height = 40;
    double speed =0.15;
    Rectangle boundingBox;
    boolean goingUp = false;
    boolean goingDown = false; 
    
    public PlayerPaddle(double x, double y){
        this.x = x;
        this.y = y;
        boundingBox = new Rectangle((int)x,(int)y,width,height);
        boundingBox.setBounds((int)x,(int)y,width,height);
    }
    public void tick (Game game){
        boundingBox.setBounds((int)x,(int)y,width,height);
        if(goingUp && y >0){
            y= y- speed;
        }
        if(goingDown && y + height < game.getHeight()){
            y = y+ speed;
        }
        if(y <25){
                y = 25;
            }
            if(y + height > game.getHeight()-25){
                y = - height + game.getHeight()-25;
            }
    }
    public void render ( Graphics g){
        g.setColor(Color.blue);
        g.fillRect( (int)x, (int)y, width, height);
    }
}
