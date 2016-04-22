
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANKIT
 */
public class InputHandler implements KeyListener{
    Game game;
    public InputHandler(Game game1){
        
        game1.addKeyListener(this);
        game = game1;
    }
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
   
    }

    
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(keyCode == KeyEvent.VK_SPACE && game.gameRunning){
            game.gameRunning = false;
        }
        else if(keyCode == KeyEvent.VK_SPACE && !game.gameRunning ){
            game.start();
            
        }
        if(keyCode == KeyEvent.VK_W){
            Game.player.goingUp = true;
        }
        if(keyCode == KeyEvent.VK_S){
            Game.player.goingDown = true;
        }
        
        if(keyCode == KeyEvent.VK_UP){
            Game.ai.goingUp = true;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            Game.ai.goingDown = true;
        }
        
        if(keyCode == KeyEvent.VK_A){
            Game.playerup.goingLeft = true;
        }
        if(keyCode == KeyEvent.VK_D){
            Game.playerup.goingRight = true;
        }
        
        if(keyCode == KeyEvent.VK_A){
            Game.playerdown.goingLeft = true;
        }
        if(keyCode == KeyEvent.VK_D){
            Game.playerdown.goingRight = true;
        }
    }

    
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
            Game.player.goingUp = false;
        }
        if(keyCode == KeyEvent.VK_S){
            Game.player.goingDown = false;
        }
        
        if(keyCode == KeyEvent.VK_UP){
            Game.ai.goingUp = false;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            Game.ai.goingDown = false;
        }
        
        if(keyCode == KeyEvent.VK_A){
            Game.playerup.goingLeft = false;
        }
        if(keyCode == KeyEvent.VK_D){
            Game.playerup.goingRight = false;
        }
        
        if(keyCode == KeyEvent.VK_A){
            Game.playerdown.goingLeft = false;
        }
        if(keyCode == KeyEvent.VK_D){
            Game.playerdown.goingRight = false;
        }

    }
    
}
