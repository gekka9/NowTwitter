package nowTwitter;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JTextArea;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class PostField extends JTextArea{
  private static final long serialVersionUID = 1L;
  protected Twitter twitter;
  private static final int WIDTH=400;
  private static final int HEIGHT=80;
  protected static final int POST_LENGTH=80;
  protected ClientModel model;
  
  public PostField(ClientModel model){
    this.model=model;
    this.twitter=model.getTwitter();
    this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    this.setMaximumSize(new Dimension(Short.MAX_VALUE, 80));
    this.setLineWrap(true);
  }
  public void post(){
  }
}
