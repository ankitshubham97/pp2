
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class MainMenu extends JFrame{
    private static final long serialVersionUID = 1L;
    int screenWidth =275;
    int screenHeight = 200;
    int buttonWidth = 100;
    int buttonHeight =40;
    JButton Play,Quit;
    JCheckBox fourPlayer;
    public MainMenu(){
        addButtons();
        addActions();
        
        getContentPane().setLayout(null);
                
        Play.setBounds((screenWidth-buttonWidth)/2 , 5, buttonWidth, buttonHeight);
        Quit.setBounds((screenWidth-buttonWidth)/2 , 50, buttonWidth, buttonHeight);
        fourPlayer.setBounds((screenWidth-buttonWidth)/2 , 95, buttonWidth, buttonHeight);
       
        getContentPane().add(Play);
        getContentPane().add(Quit);
        getContentPane().add(fourPlayer);
        
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth,screenHeight);
        setTitle("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }
    private void addButtons(){
        Play = new JButton("Play");
        Quit = new JButton("Quit");
        fourPlayer = new JCheckBox("4 players?");
    }
    private void addActions(){
        Play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                Game game = new Game();
                 if(fourPlayer.isSelected()){
                     game.ai.is4Player = true;
                     game.playerdown.is4Player = true;
                     game.playerup.is4Player = true;
                 }
                 else{
                     game.ai.is4Player = false;
                     game.playerdown.is4Player = false;
                     game.playerup.is4Player = false;
                 }
                 JOptionPane.showMessageDialog(null, "Game starting!");
                 /*game.tick();
                 game.render();
                try{
                    Thread.sleep(2000);
                    }
                    catch(Exception e1){
                    e1.printStackTrace();
                    }*/
                game.start();
                //game.gameRunning=false;
                
            }
        });
        Quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
}
