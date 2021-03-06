package nowTwitter;

import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import twitter4j.Status;

public class MainFrame extends JFrame{
  private static final long serialVersionUID = 1L;
  private final static int MINIMUM_WIDTH=420;
  private final static int MINIMUM_HEIGHT=120;
  private final static int LOCATION_WIDTH=50;
  private final static int LOCATION_HEIGHT=50;
  private PostField postField;
  private Tweet tweet;
  
  public MainFrame(Tweet tweet,PostField field){
    this.tweet=tweet;
    this.postField=field;
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(LOCATION_WIDTH,LOCATION_HEIGHT);
    this.setAlwaysOnTop(true);
    
    this.add(this.tweet);
    this.setFocusable(true);
    this.addKeyListener(new ShortcutListener(this.tweet));
    this.pack();
    this.setVisible(true);
  }
  
  public void setValue(Status status){
    this.tweet.setValue(status);
  }
  public void enablePostField(){
    this.add(this.postField);
    this.pack();
  }
  public void disablePostField(){
    this.remove(this.postField);
    this.pack();
  }
}

class ShortcutListener implements KeyListener{
  
  private Tweet tweet;

  public ShortcutListener(Tweet tweet){
    this.tweet=tweet;
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    int mod = e.getModifiersEx();
    System.out.println(e.getKeyChar());
    if ((mod & InputEvent.META_DOWN_MASK) != 0 && key == KeyEvent.VK_Z){
      System.out.println("test");
      this.tweet.getReplyButton().doClick();
    }else if ((mod & InputEvent.META_DOWN_MASK) != 0  && key == KeyEvent.VK_X){
      this.tweet.getRetweetButton().doClick();
    }else if ((mod & InputEvent.META_DOWN_MASK) != 0  && key == KeyEvent.VK_S){
      this.tweet.getFavoriteButton().doClick();
    }
  }

  @Override
  public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
  }
}