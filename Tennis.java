package assignment4;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ANKIT
 */
public class Tennis extends Applet implements Runnable, KeyListener {

    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    HumanPaddleUp p3, p4;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted;
    Graphics gfx;
    Image img;
    private GameClient socketClient;
    private GameServer socketServer;

    public void init() {
        this.resize(WIDTH, HEIGHT);
        gameStarted = false;
        this.addKeyListener(this);
        b1 = new Ball();
        p1 = new HumanPaddle(1);
        p3 = new HumanPaddleUp(1);
        p4 = new HumanPaddleUp(2);
        p2 = new AIPaddle(2, b1);
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
        if (JOptionPane.showConfirmDialog(this, "Do u wanna run the server") == 0) {
            socketServer = new GameServer(this);
            socketServer.start();
        } 
        else {
            socketClient = new GameClient(this, "localhost");
            socketClient.start();
        }
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);
        if (b1.getX() < -10 || b1.getX() > 710 || b1.getY() < -10 || b1.getY() > 510) {
            gfx.setColor(Color.red);
            gfx.drawString("Game Over", 350, 250);
        } else {
            p1.draw(gfx);
            b1.draw(gfx);
            p2.draw(gfx);
            p3.draw(gfx);
            p4.draw(gfx);
        }
        if (!gameStarted) {
            gfx.setColor(Color.white);
            gfx.drawString("Tennis", 340, 100);
            gfx.drawString("Press Enter to Start...", 310, 130);
        }
        g.drawImage(img, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        for (;;) {
            if (gameStarted) {
                p1.move();
                p2.move();
                p3.move();
                p4.move();
                b1.move();
                b1.checkPaddleCollisionHorizontal(p3, p4);
                b1.checkPaddleCollisionVertical(p1, p2);
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p3.setLeftAccel(true);
            p4.setLeftAccel(true); /////////////////////////////
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p3.setRightAccel(true);
            p4.setRightAccel(true);
        } /*else if(e.getKeyCode()==KeyEvent.VK_Z){
        p4.setLeftAccel(true); 
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
        p4.setRightAccel(true); 
        }*/ else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameStarted = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p1.setDownAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p3.setLeftAccel(false);
            p4.setLeftAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p3.setRightAccel(false);
            p4.setRightAccel(false);
        }

        /*else if(e.getKeyCode()==KeyEvent.VK_LEFT){
        p4.setLeftAccel(false);
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
        p4.setRightAccel(false);
        }*/
    }
}
