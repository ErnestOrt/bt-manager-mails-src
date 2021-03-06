package org.ernest.applications.bt.manager.mails.ms.services;

import org.ernest.applications.bt.manager.mails.ct.SendAddMembersInput;
import org.ernest.applications.bt.manager.mails.ct.SendAddNoticeInput;
import org.ernest.applications.bt.manager.mails.ct.exceptions.SendMailException;


public interface MailService {
	
	public String buildActivate(String username, String token) throws SendMailException;

	public String buildRecover(String pass) throws SendMailException;

	public String buildNewStage(String username, String teamname, String stagename, String stagedate, String stageId) throws SendMailException;

	public String buildAddMember(SendAddMembersInput sendNewStageInput) throws SendMailException;

	public String buildAddNotice(SendAddNoticeInput sendAddNoticeInput) throws SendMailException;
}
