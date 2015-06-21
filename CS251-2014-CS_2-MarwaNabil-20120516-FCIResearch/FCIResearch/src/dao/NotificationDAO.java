package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.Notification;

public class NotificationDAO {
	
	public Notification [] getNotification(int ReceiverID) 
	{
		Notification[] arr=new Notification [1000000];
		int ind=0;
		Connection conn=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
			st=conn.createStatement();
			

			
			String  s ="";
			s = "SELECT * FROM `notification` where `ReceiverID` = " + ReceiverID;
			
	
			ResultSet notifications = st.executeQuery(s);
			
			
			while(notifications.next()){
				int SID = notifications.getInt("SenderID");
				int RID = notifications.getInt("ReceiverID");
				String M = notifications.getString("msg");
				int t = notifications.getInt("type");
				Notification N = new Notification(SID,RID, M ,t);
				arr[ind++]= N ;
			}
			return arr;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	 public boolean saveNotification(Notification N )
	 {
		 Connection conn = null;
		  PreparedStatement p = null;
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/fciresearch","root","");
				String  s ="";
				s = "INSERT INTO `notification`(`SenderID`, `ReceiverID`, `msg`, `type`) VALUES (?,?,?,?)";
				
				p= conn.prepareStatement(s);
				p.setInt(1, N.getNotificationSenderID());
				p.setInt(2, N.getNotificationReceiverID());
				p.setString(3, N.getMsg());
				p.setInt(4, N.getType());
				
				p.executeUpdate();
							
				
		  return true;
			}catch (Exception e)
			{
				System.out.println("Error");
				System.out.println(e.getMessage());
				return false;
			}
	 }

}
