package entities;

import java.util.Vector;

public class Group {

  public String name,meetingTimes,description;
  public String adminMail;
  public Vector <String>  members;
  
  public Group(String _name,String _meetingTimes,String _description,String _adminMail){
	  name=_name;
	  meetingTimes=_meetingTimes;
	  description=_description;
	  adminMail=_adminMail;
  }
  
  public void setName(String data){
	  name=data;
  }
  public void setMeetingTimes(String data){
	  meetingTimes=data;
  }
  public void setDescription(String data){
	  description=data;
  }
  
  public String getName(){
	  return name;
  }
  
  public String getMeetingTimes(){
	  return meetingTimes;
  }
  
  public String getDescription(){
	  return description;
  }
}