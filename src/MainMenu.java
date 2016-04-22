
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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
    int screenWidth =475;
    int screenHeight = 400;
    int buttonWidth = 100;
    int buttonHeight =40;
    JButton Play,Quit,Help;
    JCheckBox fourPlayer;
    JRadioButton easy;
    JRadioButton medium;
    JRadioButton hard;
    ButtonGroup difficulty;
    JLabel helpcontent;
    
    public MainMenu(){
        addButtons();
        addActions();
        
        getContentPane().setLayout(null);
                
        Play.setBounds((screenWidth-buttonWidth)/2 , 5, buttonWidth, buttonHeight);
        Quit.setBounds((screenWidth-buttonWidth)/2 , 50, buttonWidth, buttonHeight);
        //Help.setBounds((screenWidth-buttonWidth)/2 , 95, buttonWidth, buttonHeight);
        fourPlayer.setBounds((screenWidth-buttonWidth)/2 , 95, buttonWidth, buttonHeight);
        //helpcontent.setBounds((screenWidth-buttonWidth)/2 , 95, buttonWidth*4, buttonHeight*4);
        easy.setBounds((screenWidth-buttonWidth)/2 , 135, buttonWidth, buttonHeight);
        medium.setBounds((screenWidth-buttonWidth)/2 , 175, buttonWidth, buttonHeight);
        hard.setBounds((screenWidth-buttonWidth)/2 , 215, buttonWidth, buttonHeight);
       
        getContentPane().add(Play);
        getContentPane().add(Quit);
        getContentPane().add(fourPlayer);
        getContentPane().add(easy);
        getContentPane().add(medium);
        getContentPane().add(hard);
        
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
        easy = new JRadioButton("Easy",true);
        medium = new JRadioButton("Medium");
        hard = new JRadioButton ("Hard");
        Help = new JButton("Help");
        helpcontent =new JLabel();
        difficulty = new ButtonGroup();
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);
        
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
                     if(easy.isSelected()){
                         game.ai.diff_level=1;
                         game.playerup.diff_level=1;
                         game.playerdown.diff_level=1;
                     }
                     if(medium.isSelected()){
                         game.ai.diff_level=2;
                         game.playerup.diff_level=2;
                         game.playerdown.diff_level=2;
                     }
                     if(hard.isSelected()){
                         game.ai.diff_level=3;
                         game.playerup.diff_level=3;
                         game.playerdown.diff_level=3;
                     }
                     game.ai.is4Player = false;
                     game.playerdown.is4Player = false;
                     game.playerup.is4Player = false;
                 }
                 JOptionPane.showMessageDialog(null, "Help message to be shown here");
                 System.out.println(game.ai.diff_level);
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
                File clap = new File("http://www-mmsp.ece.mcgill.ca/documents/audioformats/wave/Samples/AFsp/M1F1-Alaw-AFsp.wav");
                try{
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(clap));
                    clip.start();
                    Thread.sleep(clip.getMicrosecondLength()/1000);
                }
                catch(Exception e2){
                    
                }
        /*try {
            java.applet.AudioClip clip =
            java.applet.Applet.newAudioClip(
            new java.net.URL("http://www-mmsp.ece.mcgill.ca/documents/audioformats/wave/Samples/AFsp/M1F1-Alaw-AFsp.wav"));
            clip.play();
            } catch (java.net.MalformedURLException murle) {
            System.out.println(murle);
        }*/
                System.exit(0);
                
            }
        });
        fourPlayer.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if(fourPlayer.isSelected()){
                    easy.setVisible(false);
                    medium.setVisible(false);
                    hard.setVisible(false);
                }
                
                else{
                    easy.setVisible(true);
                    medium.setVisible(true);
                    hard.setVisible(true);
                }
            }
        });
    }
}
