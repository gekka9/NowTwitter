package nowTwitter;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ClientModel {
  private Twitter twitter;
  private HashMap<User,ImageIcon> iconMap;
  private MainFrame frame;
  private static int SIZE=48;

  public ClientModel(Twitter twitter){
    this.twitter=twitter;
    this.iconMap=new HashMap<User, ImageIcon>();
  }

  public Twitter getTwitter() {
    return twitter;
  }

  public void setTwitter(Twitter twitter) {
    this.twitter = twitter;
  }
  
  public void setFrame(MainFrame frame) {
    this.frame=frame;
  }
  
  public void viewPost(Status status){

  }

  
  private ImageIcon createIcon(String urlString){
    Image image;
    try {
      image = ImageIO.read(new URL(urlString));
      if(image.getWidth(null)!=SIZE && image.getHeight(null) !=SIZE){
        image = image.getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
      }
      ImageIcon icon = new ImageIcon(image);
      return icon;
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
