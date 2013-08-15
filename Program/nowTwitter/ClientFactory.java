package nowTwitter;

import twitter4j.Twitter;

public class ClientFactory {

  private ClientModel model;
  private MainFrame frame;
  
  public ClientFactory(Twitter twitter){
    this.model=new ClientModel(twitter);
    this.frame = new MainFrame(this.model);
    this.model.setFrame(this.frame);
  }
  
  public ClientModel getClientModel(){
    return this.model;
  }

}
