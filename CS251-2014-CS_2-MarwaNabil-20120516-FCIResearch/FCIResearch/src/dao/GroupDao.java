package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.*;


public class GroupDao {
	public Group[] getGroups(){
		Group[] arr=new Group[1000000];
		int ind=0;
		Connection conn=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			st=conn.createStatement();

			ResultSet groups = st.executeQuery("SELECT * FROM `group` ");
			
			while(groups.next()){
				Group g=new Group(groups.getString("name"),groups.getString("meetingTimes"),groups.getString("description"),groups.getString("adminMail"));
				arr[ind++]=g;
			}
			return arr;
		}
		catch (Exception e){
			e.printStackTrace();
			return new Group[0];
		}
	}
	
	
	public boolean saveGroup(Group g){
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  p=conn.prepareStatement("INSERT INTO `group`(`name`, `meetingTimes`, `description`, `adminMail`) VALUES (?,?,?,?)");
			  
			  p.setString(1, g.name);
			  p.setString(2, g.meetingTimes);
			  p.setString(3, g.description);
			  p.setString(4, g.adminMail);
				
			  p.executeUpdate();
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}
	
	public boolean deleteGroup(String gName){
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  p=conn.prepareStatement("DELETE FROM `group` WHERE `name`=?");
			  
			  p.setString(1, gName);
				
			  p.executeUpdate();
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}
	
	public boolean editGroup(Group g,String oldName){
		Connection conn=null;
		  PreparedStatement p=null;
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			  p=conn.prepareStatement("UPDATE `group` SET `name`=?, `meetingTimes`=?, `description`=? WHERE `name`=?");
			  
			  p.setString(1, g.name);
			  p.setString(2, g.meetingTimes);
			  p.setString(3, g.description);
			  p.setString(4, oldName);
				
			  p.executeUpdate();
			  return true;
		  }
		  catch(Exception e){
			  return false;
		  }
	}
	
	public int checkAdmin(String admin,String gName){

		Connection conn=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			st=conn.createStatement();

			ResultSet groups = st.executeQuery("SELECT * FROM `group` ");
			
			int check=0;
			while(groups.next()){
				Group g=new Group(groups.getString("name"),groups.getString("meetingTimes"),groups.getString("description"),groups.getString("adminMail"));
				if(g.name.equals(gName) && g.adminMail.equals(admin)){
					check=1;break;
				}
			}
			return check;
		}
		catch (Exception e){
			return 2;
		}
	}
	
	public boolean groupExists(String gName){
		Connection conn=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			st=conn.createStatement();

			ResultSet groups = st.executeQuery("SELECT * FROM `group` ");
			
			boolean check=false;
			while(groups.next()){
				Group g=new Group(groups.getString("name"),groups.getString("meetingTimes"),groups.getString("description"),groups.getString("adminMail"));
				if(g.name.equals(gName)){
					check=true;break;
				}
			}
			return check;
		}
		catch (Exception e){
			return false;
		}
	}
}
