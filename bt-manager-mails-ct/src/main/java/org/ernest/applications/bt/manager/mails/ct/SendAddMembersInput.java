package org.ernest.applications.bt.manager.mails.ct;

public class SendAddMembersInput {
	
	private String userNameInvited;
	private String userMailInvited;
	private String userNameSender;
	private String teamName;
	private String teamId;
	
	public String getUserNameInvited() {
		return userNameInvited;
	}
	public void setUserNameInvited(String userNameInvited) {
		this.userNameInvited = userNameInvited;
	}
	public String getUserMailInvited() {
		return userMailInvited;
	}
	public void setUserMailInvited(String userMailInvited) {
		this.userMailInvited = userMailInvited;
	}
	public String getUserNameSender() {
		return userNameSender;
	}
	public void setUserNameSender(String userNameSender) {
		this.userNameSender = userNameSender;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
}