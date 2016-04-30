package assignment4;


import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANKIT
 */
public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
    public int getX();
}
