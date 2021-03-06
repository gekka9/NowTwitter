package nowTwitter;

import twitter4j.Twitter;

public class ClientFactory {

  private ClientModel model;
  private MainFrame frame;
  
  public ClientFactory(Twitter twitter){
    this.model=new ClientModel(twitter);
    this.frame = new MainFrame(new Tweet(this.model),new PostField(this.model));
    this.model.setFrame(this.frame);
    MyMenu menu = new MyMenu(this.model);
    this.frame.setMenuBar(menu);
    if(this.model.isEnablePostField()){
      this.model.enablePostField();
      menu.setPostField(true);
    }else{
      this.model.disablePostField();
      menu.setPostField(false);
    }
  }
  
  public ClientModel getClientModel(){
    return this.model;
  }

}
