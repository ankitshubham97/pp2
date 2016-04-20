
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANKIT
 */
public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    public static PlayerPaddle player;
    public static PlayerPaddleUp playerup;
    public static PlayerPaddleUp playerdown;
    public static AIPaddle ai;
    public static Ball ball;
    InputHandler IH;
    JFrame frame;
    public final int WIDTH = 400;
    public final int HEIGHT = WIDTH ;
    public final Dimension gameSize = new Dimension(WIDTH,HEIGHT);
    public final String TITLE = "Ping Pong";
    public int ScreenWidth;
    public int ScreenHeight;
    int p1score,p2score,p3score,p4score;
    BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    public boolean gameRunning ;
    
    public void run(){
        if(gameRunning){
            System.out.println("something");
            while(gameRunning){
                tick();
                render();
            }
            try{
                    Thread.sleep(10);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
        }
        
    }
    public synchronized void start(){
        
        gameRunning = true;
        new Thread(this).start();
    }
    public synchronized void stop(){
        gameRunning = false;
        System.exit(0);
    }
    public Game(){
        frame = new JFrame();  
        
        this.setMinimumSize(gameSize);
        this.setPreferredSize(gameSize);
        this.setMaximumSize(gameSize);
        
        frame.add(this,BorderLayout.CENTER);
        frame.pack();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null);
        ScreenHeight = getHeight();
        ScreenWidth = getWidth();
        IH = new InputHandler(this);
        gameRunning = false;
        
        player = new PlayerPaddle(10,60);
        ai = new AIPaddle(getWidth()+8-25,60);
        playerup = new PlayerPaddleUp(getWidth()/2-20,40);
        playerdown = new PlayerPaddleUp(getWidth()/2-20,getHeight()+8-25);
        ball =new Ball(getWidth()/2,getHeight()/2);
        p1score=03;
        p2score=03;
        p3score=03;
        p4score=03;
        this.requestFocus();
        System.out.println(getHeight()+" ,"+getWidth());
    }
    public void tick(){
        player.tick(this);
        playerup.tick(this);
        playerdown.tick(this);
        ai.tick(this);
        ball.tick(this);
    }
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.drawImage( image,  0, 0, getWidth(),getHeight(),null);
        g.setColor(Color.red);
        g.drawString(p1score+"", ((int)player.x)+6, ((int)player.y));
        g.drawString(""+p2score, ((int)ai.x)+6, ((int)ai.y));
        g.drawString(p3score+"", ((int)playerup.x)+19, ((int)playerup.y));
        g.drawString(""+p4score, ((int)playerdown.x)+19, ((int)playerdown.y));
        
        if(p1score<0){
            gameRunning = false;
            JOptionPane.showMessageDialog(null, "Left player loses.");
            System.exit(0);
        }
        if(p2score<0){
            gameRunning = false;
            JOptionPane.showMessageDialog(null, "Right player loses.");
            System.exit(0);
        }
        if(p3score<0){
            gameRunning = false;
            JOptionPane.showMessageDialog(null, "Up player loses.");
            System.exit(0);
        }
        if(p4score<0){
            gameRunning = false;
            JOptionPane.showMessageDialog(null, "Down player loses.");
            System.exit(0);
        }
        player.render(g);
        playerup.render(g);
        playerdown.render(g);
        ai.render(g);
        ball.render(g);
        g.dispose();
        bs.show();
        
    }

    
    
}
 