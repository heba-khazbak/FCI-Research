package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import entities.*;

public class UserDao {
	  public User getUser(String mail , String pass) 
	  {
			Connection conn = null;
			Statement stmt = null;
			User U = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
				stmt = conn.createStatement();
				String  s ="";
				s = "SELECT * FROM `user` ";
				ResultSet myUsers = stmt.executeQuery(s);

				while (myUsers.next())
				{
					String email= myUsers.getString("email");
					String password= myUsers.getString("Password");
				    if (email.equals(mail) && password.equals(pass))
				    {
				    	String name= myUsers.getString("name");
				    	int ID = myUsers.getInt("ID");
				    	
						String photo= myUsers.getString("photo") ;
				    	String jobDescription= myUsers.getString("jobDescription");
						String affiliation= myUsers.getString("affiliation");
						String overview= myUsers.getString("overview");
						
				    	 U = new User (email , password , name);
				    	 U.setUserID(ID);
				    	 U.setUserAffiliation(affiliation);
				    	 U.setUserJobDescription(jobDescription);
				    	 U.setUserOverview(overview);
				    	 U.setUserPhoto(photo);
				    	 break;
				    }		
					
				}
				myUsers.close();

				return U;
				
				
		
			}catch (Exception e)
			{
				System.out.println("Error");
				System.out.println(e.getMessage());
				return null;
				
			}
	  }
	  public boolean saveUser(User U ) 
	  {
		  Connection conn = null;
		  PreparedStatement p = null;
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
				String  s ="";
				s = "INSERT INTO `user`(`email`, `password`, `name`, `photo`, `jobDescription`, `affiliation`, `overview`) VALUES (?,?,?,?,?,?,?)";
				
				p= conn.prepareStatement(s);
				p.setString(1, U.getUserEmail());
				p.setString(2, U.getUserPassword());
				p.setString(3, U.getUserName());
				p.setString(4, "");
				p.setString(5, U.getUserJobDescription());
				p.setString(6, U.getUserAffiliation());
				p.setString(7, U.getUserOverview());
				
				p.executeUpdate();
				String [] myInterest = U.getUserInterests();
				if (myInterest != null)
				{
					for (int i=0 ; i < U.interests.length ; i++)
					  {
						s = "INSERT INTO `user_interest`(`email`, `interest`)  VALUES (?,?)";
						
						p= conn.prepareStatement(s);
						p.setString(1, U.getUserEmail());
						p.setString(2, myInterest[i]);
						p.executeUpdate();
					  }
				}
				
				
		  return true;
			}catch (Exception e)
			{
				System.out.println("Error");
				System.out.println(e.getMessage());
				return false;
			}
		  
	  }
	  
	  public Map<String,String> getUserInterests(){
		  Map<String,String> m=new HashMap<String,String>();
			Connection conn=null;
			Statement st=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
				st=conn.createStatement();

				ResultSet interests = st.executeQuery("SELECT * FROM `user_interest`");
				
				while(interests.next()){
					String email=interests.getString("email");
					String interest=interests.getString("interest");
					if(!m.containsKey(email)){
						m.put(email, interest);
					}
					else m.put(email, m.get(email)+","+interest);
				}
				return m;
			}
			catch (Exception e){
				e.printStackTrace();
				return new HashMap<String,String>();
			}
	  }
	  
	  public int getID(String email){
		  Statement st=null;
		  Connection conn=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  st=conn.createStatement();
			  int rID=1;
			  ResultSet users= st.executeQuery("SELECT * FROM `user` ");
			  while(users.next()){
				  if(users.getString("email").equals(email)){
					  rID=users.getInt("ID");
					  break;
				  }
			  }
			  return rID;
		  }
		  catch(Exception e){
			  return 1;
		  }
	  }
	  
	  public String getMail(int ID){
		  Statement st=null;
		  Connection conn=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  st=conn.createStatement();
			  String retMail="";
			  ResultSet users= st.executeQuery("SELECT * FROM `user` ");
			  while(users.next()){
				  if(users.getInt("ID")==ID){
					  retMail=users.getString("email");
					  break;
				  }
			  }
			  return retMail;
		  }
		  catch(Exception e){
			  return "";
		  }
	  }

	  public void CheckNewUser(User U )
	  {
		  
	  }
	  
	  public void updateUser(User user) {
	  }

	  public void NotifyWillsendMail() {
	  }

	  public void NotifyOwner(User user) {
	  }
}
