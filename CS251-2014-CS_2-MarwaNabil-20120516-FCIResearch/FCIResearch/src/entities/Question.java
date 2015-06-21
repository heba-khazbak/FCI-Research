package entities;


public class Question {

	private String title;
	private String body;
	private String tags;
	
	public User owner;
  
  public void setTitle ( String data){
	  title=data;
  }

  public void setBody ( String data){
	  body=data;
  }
  public void setTags ( String data){
	  tags=data;
  }
  
  public String getTitle(){
	  return title;
  }
  
  public String getBody(){
	  return body;
  }
  
  
  public String getTags(){
	  return tags;
  }  
  
    

}