package assignment4;


import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANKIT
 */
public class HumanPaddleUp implements Paddle{
    double x,xVel;
    final double GRAVITY =0.94;
    boolean rightAccel,leftAccel;
    int player,y;
    
    public HumanPaddleUp(int player){
        rightAccel=false;
        leftAccel=false;
        x=310;
        xVel = 0;
        if(player ==1){
            y=20;
        }
        if(player ==2){
            y=460;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, y , 80, 20);
    }

    
    public void move() {
        if(rightAccel){
            xVel +=2;
        }
        else if(leftAccel){
            xVel -=2;
        }
        else if(!rightAccel && !leftAccel){
            xVel*= GRAVITY;
        }
        if(xVel>=5){
            xVel =5;
        }
        else if(xVel<=-5){
            xVel =-5;
        }
        x+= xVel;
        if(x<0){
            x=0;
        }
        if(x>620){
            x=620;
        }
    }

    public void setLeftAccel(boolean input){
        leftAccel = input;
    }
    
    public void setRightAccel(boolean input){
        rightAccel = input;
    }
    
    public int getX() {
        return (int)x;
    }
    public int getY(){
        return 0;
    }
    
}
