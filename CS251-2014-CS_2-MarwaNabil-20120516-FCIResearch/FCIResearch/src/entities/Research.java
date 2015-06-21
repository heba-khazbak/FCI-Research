package entities;


public class Research {
	
	private int ID;
	private String title;

	private String description;

	private String url;

	private String tags;
	
	private int ownerID;
	
	public User owner;
	public String[] interests;
  
	public Research(String _title, String _url, String _description,int _ownerID){
		title=_title;
		url=_url;
		description=_description;
		ownerID=_ownerID;
	}
	
  public void setTitle ( String data){
	  title=data;
  }
  public void setDescription ( String data){
	  description=data;
  }
  public void setUrl ( String data){
	  url=data;
  }
  public void setTags ( String data){
	  tags=data;
  }
  public void setTags ( int data){
	  ownerID=data;
  }
  
  public String getTitle(){
	  return title;
  }
  
  public String getDescription(){
	  return description;
  }
  
  public String getUrl(){
	  return url;
  }
  
  public String getTags(){
	  return tags;
  }
    
  public int getownerID(){
	  return ownerID;
  }

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

}