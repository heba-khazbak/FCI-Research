package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.*;


public class ResearchDAO {


  public Research[] getResearches(){
		Research[] arr=new Research[1000000];
		int ind=0;
		Connection conn=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			st=conn.createStatement();

			ResultSet researches = st.executeQuery("SELECT * FROM `research` ");
			
			while(researches.next()){
				Research r=new Research(researches.getString("title"),researches.getString("url"),researches.getString("description"),researches.getInt("ownerID"));
				int id=researches.getInt("ID");
				r.interests=getResearchInterests(id);
				arr[ind++]=r;
			}
			return arr;
		}
		catch (Exception e){
			e.printStackTrace();
			return new Research[0];
		}
  }
  public String[] getResearchInterests(int ID){
		String[] arr=new String[1000000];
		int ind=0;
		Connection conn=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			st=conn.createStatement();

			ResultSet interests = st.executeQuery("SELECT * FROM `research_interest` WHERE `researchID`="+ID);
			
			while(interests.next()){
				arr[ind++]=interests.getString("interest");
			}
			return arr;
		}
		catch (Exception e){
			e.printStackTrace();
			return new String[0];
		}
  }
  public int getID(String url){
	  Statement st=null;
	  Connection conn=null;
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
		  st=conn.createStatement();
		  int rID=1;
		  ResultSet researches= st.executeQuery("SELECT * FROM `research` ");
		  while(researches.next()){
			  if(researches.getString("url").equals(url)){
				  rID=researches.getInt("ID");
				  break;
			  }
		  }
		  return rID;
	  }
	  catch(Exception e){
		  return 1;
	  }
  }
  public boolean saveResearch(Research r) {
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  p=conn.prepareStatement("INSERT INTO `research`(`title`, `url`, `description`, `ownerID`) VALUES (?,?,?,?)");
			  
			  p.setString(1, r.getTitle());
			  p.setString(2, r.getUrl());
			  p.setString(3, r.getDescription());
			  p.setInt(4, r.getownerID());
				
			  p.executeUpdate();
			  
			  int rID=getID(r.getUrl());
			  
			  String [] myInterest = r.interests;
			  if (myInterest != null)
			  {
				  for(int i=0;i<r.interests.length;++i){
					  p= conn.prepareStatement("INSERT INTO `research_interest`(`researchID`, `interest`)  VALUES (?,?)");
					  p.setInt(1, rID);
					  p.setString(2, myInterest[i]);
					  p.executeUpdate();
				  }
			  }
			  
			  return true;
		  }
		  catch(Exception e){
			  System.out.println(e.getLocalizedMessage());
			  return false;
		  }
  	}
	public boolean deleteResearch(String url){
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  p=conn.prepareStatement("DELETE FROM `research` WHERE `url`=?");
			  
			  p.setString(1, url);
			  
			  if(!deleteInterests(getID(url)))return false;
				
			  p.executeUpdate();
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}
	public boolean deleteInterests(int ID){
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  p=conn.prepareStatement("DELETE FROM `research_interest` WHERE `researchID`=?");
			  
			  p.setInt(1, ID);
				
			  p.executeUpdate();
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}
	public boolean editResearch(Research r,String url){
		int id=getID(url);
		if(!editInterests(r.interests,id))return false;
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  
			  
			  p=conn.prepareStatement("UPDATE `research` SET `title`=?, `url`=?, `description`=? WHERE `id`=?");
			  
			  p.setString(1, r.getTitle());
			  p.setString(2, r.getUrl());
			  p.setString(3, r.getDescription());
			  p.setInt(4, id);
				
			  p.executeUpdate();
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}
	
	public boolean editInterests(String[] myInterest,int ID){
		if(!deleteInterests(ID))return false;
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  if (myInterest != null)
			  {
				  for(int i=0;i<myInterest.length;++i){
					  p= conn.prepareStatement("INSERT INTO `research_interest`(`researchID`, `interest`)  VALUES (?,?)");
					  p.setInt(1, ID);
					  p.setString(2, myInterest[i]);
					  p.executeUpdate();
				  }
			  }
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}

}