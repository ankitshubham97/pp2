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
public class AIPaddle implements Paddle{
    double y,yVel;
    final double GRAVITY =0.94;
    boolean upAccel,downAccel;
    int player,x;
    Ball b1;
    
    public AIPaddle(int player, Ball b){
        upAccel=false;
        downAccel=false;
        b1=b;
        y=210;
        yVel = 0;
        if(player ==1){
            x=20;
        }
        if(player ==2){
            x=660;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y , 20, 80);
    }

    
    public void move() {
        y=b1.getY()-40;
        if(y<0){
            y=0;
        }
        if(y>420){
            y=420;
        }
    }
    
    public int getY() {
        return (int)y;
    }
    public int getX(){
        return 0;
    }
    
}
