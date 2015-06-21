package entities;

public class Notification {
	public static final String newResearchNotification = "";
	public static final String reqAcess = " wants to access your research '";
	public static final String sendMailReply = " has accepted your request & will send mail for Research: '";
	public static final String rejectReply = " has rejected your request for Research: '";
	public static final String newResearch= " has posted a new research under the name '";
	private int notificationSenderID;
	private int notificationReceiverID;
	private String msg;
	private int type;
	
	public Notification(int sender, int receiver)
	{
		setNotificationSenderID(sender);
		setNotificationReceiverID(receiver);
		msg = "";
		
	}
	
	
	public Notification(int sender, int receiver , String m , int t)
	{
		setNotificationSenderID(sender);
		setNotificationReceiverID(receiver);
		msg = m;
		type = t;
		
	}
	
	public String composeNewResAdded (String senderName ,String researchName)
	{
		msg = senderName + newResearch + researchName+"'";
		type = 1;
		return msg;
	}
	
	public String composeNewResReq (String senderName ,String researchName)
	{
		msg = senderName + reqAcess + researchName+"'";
		type = 2;
		return msg;
	}
	
	public String composeSendMailReply(String senderName, String researchName)
	{
		msg = senderName + sendMailReply+ researchName+"'";
		type = 3;
		return msg;
	}
	
	public String composeRejectReply(String senderName, String researchName)
	{
		msg = senderName + rejectReply+ researchName+"'";
		type = 4;
		return msg;
	}
	
	public String getMsg()
	{
		return msg;
	}

	public int getNotificationSenderID() {
		return notificationSenderID;
	}

	public void setNotificationSenderID(int notificationSenderID) {
		this.notificationSenderID = notificationSenderID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNotificationReceiverID() {
		return notificationReceiverID;
	}

	public void setNotificationReceiverID(int notificationReceiverID) {
		this.notificationReceiverID = notificationReceiverID;
	}
	

}
