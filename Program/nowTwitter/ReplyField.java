package nowTwitter;


import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;

public class ReplyField extends PostField{
  private long destTweet;
  private String destUser;


  public ReplyField(ClientModel model) {
    super(model);
    this.addKeyListener(new Poster(this));
  }

  private static final long serialVersionUID = 1L;

  
  public void setValue(Status status){
    this.destTweet=status.getId();
    this.destUser=status.getUser().getScreenName();
  }

  public void post(){
    if(this.getText().length() <POST_LENGTH && 0<this.getText().length() ){
      String postText ="@"+this.destUser+" "+this.getText();
      try {
        this.twitter.updateStatus(new StatusUpdate(postText).inReplyToStatusId(this.destTweet));
      } catch (TwitterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.destTweet=0;
      this.destUser=null;
      this.setText("");
      //this.getParent().setVisible(false);
    }
  }

}
