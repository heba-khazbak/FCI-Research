package entities;


public class User {
	  private int ID;
	  private String email;
	  private String password;
	  private String name;
	  private String photo;
	  private String jobDescription;
	  private String affiliation;
	  private String overview;
	  public String[] interests;
	  
	  public User ()
	  {
	  }
	  
	  public User (String e , String pass , String n )
	  {
		  email = e;
		  password = pass;
		  name = n;
		  interests = null;
	  }
	  
	 
	  
	  public void setUserInterests( String[] inter){
		  if (inter == null)
			  return;
		  
		  interests = new String [inter.length];
		  for (int i=0 ; i < inter.length ; i++)
		  {
			  interests[i] = inter[i];
		  }
	  }
	  
	  
	  public void setUserEmail(String data){
			email=data;
	  }
	  
	  public void setUserPassword(String data){
			password=data;
	  }
	  
	  public void setUserName(String data){
			name=data;
	  }
	  
	  public void setUserPhoto(String data){
			photo= data;
	  }
	  
	  public void setUserJobDescription(String data){
		  jobDescription= data;
	  }
	  
	  public void setUserAffiliation(String data){
		  affiliation= data;
	  }
	  
	  public void setUserOverview(String data){
		  overview= data;
	  }
	  
	  public void setUserID(int data){
		  ID= data;
	  }
	  
	  public String getUserEmail(){
			return email;
	  }
	  
	  public String getUserPassword(){
			return password;
	  }

	  public String getUserName(){
			return name;
	  }
	  
	  public String getUserPhoto(){
		  return photo;
	  }
	  
	  public String getUserJobDescription(){
		  return jobDescription;
	  }
	  
	  public String getUserAffiliation(){
		  return affiliation;
	  }
	  
	  public String getUserOverview(){
		  return overview;
	  }
	  
	  public int getUserID(){
		  return ID;
	  }
	  
	  public String[] getUserInterests(){
		  return interests ;
		  
	  }
}
