package org.ernest.applications.bt.manager.mails.ct;

public class SendNewStageInput {

	private String userMail;
	private String userName;
	private String teamName;
	private String stageName;
	private String stageDate;
	private String stageId;
	
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getStageDate() {
		return stageDate;
	}
	public void setStageDate(String stageddate) {
		this.stageDate = stageddate;
	}
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
}