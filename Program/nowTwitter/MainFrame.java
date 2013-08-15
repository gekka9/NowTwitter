package nowTwitter;

import java.awt.Dimension;

import javax.swing.JFrame;
import twitter4j.Status;

public class MainFrame extends JFrame{
  private static final long serialVersionUID = 1L;
  private final static int MINIMUM_WIDTH=420;
  private final static int MINIMUM_HEIGHT=120;
  private final static int LOCATION_WIDTH=50;
  private final static int LOCATION_HEIGHT=50;
  private Tweet tweet;
  
  public MainFrame(Tweet tweet){
    this.tweet=tweet;
    this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
    this.setPreferredSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT+30));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(LOCATION_WIDTH,LOCATION_HEIGHT);
    this.setAlwaysOnTop(true);
    
    this.add(this.tweet);
    
    this.setVisible(true);
  }
  
  public void setValue(Status status){
    this.tweet.setValue(status);
  }
}