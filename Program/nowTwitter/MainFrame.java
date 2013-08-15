package nowTwitter;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import twitter4j.Status;

public class MainFrame extends JFrame{
  private static final long serialVersionUID = 1L;
  private final static int MINIMUM_WIDTH=420;
  private final static int MINIMUM_HEIGHT=100;
  private final static int LOCATION_WIDTH=50;
  private final static int LOCATION_HEIGHT=50;
  private Tweet tweet;
  private ClientModel model;
  
  public MainFrame(ClientModel model){
    this.model=model;
    this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(LOCATION_WIDTH,LOCATION_HEIGHT);
    this.setAlwaysOnTop(true);
    
    this.tweet = new Tweet();
    this.add(this.tweet);
    
    this.setVisible(true);
  }
  
  public void setValue(){}
}