package org.ernest.applications.bt.manager.mails.ms.controllers;

import org.ernest.applications.bt.manager.mails.ct.SendActivateInput;
import org.ernest.applications.bt.manager.mails.ct.SendAddMembersInput;
import org.ernest.applications.bt.manager.mails.ct.SendAddNoticeInput;
import org.ernest.applications.bt.manager.mails.ct.SendNewStageInput;
import org.ernest.applications.bt.manager.mails.ct.SendRecoverInput;
import org.ernest.applications.bt.manager.mails.ct.exceptions.SendMailException;
import org.ernest.applications.bt.manager.mails.ms.services.MailSender;
import org.ernest.applications.bt.manager.mails.ms.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailsController {

	@Autowired
	MailService mailService;
	
	@Autowired
	MailSender mailSender;
	
	@RequestMapping("/sendactivate")
	public void sendActivate(@RequestBody SendActivateInput sendActivateInput) throws SendMailException {
		String body = mailService.buildActivate(sendActivateInput.getUserName(), sendActivateInput.getToken());
		mailSender.send("Sabati Account Activation", body, sendActivateInput.getUsermail());
	}
	
	@RequestMapping("/sendrecover")
	public void sendRecover(@RequestBody SendRecoverInput sendRecoverInput) throws SendMailException {
		String body = mailService.buildRecover(sendRecoverInput.getPass());
		mailSender.send("Sabati Account Recovery", body, sendRecoverInput.getEmail());
	}
	
	@RequestMapping("/sendnewstage")
	public void sendNewStage(@RequestBody SendNewStageInput sendNewStageInput) throws SendMailException {
		String body = mailService.buildNewStage(sendNewStageInput.getUserName(), sendNewStageInput.getTeamName(), sendNewStageInput.getStageName(), sendNewStageInput.getStageDate(), sendNewStageInput.getStageId());
		mailSender.send("Sabati New Stage", body, sendNewStageInput.getUserMail());
	}
	
	@RequestMapping("/sendaddmembers")
	public void sendAddMembers(@RequestBody SendAddMembersInput sendNewStageInput) throws SendMailException {
		String body = mailService.buildAddMember(sendNewStageInput);
		mailSender.send("Sabati Added to a Team", body, sendNewStageInput.getUserMailInvited());
	}
	
	@RequestMapping("/sendaddnotice")
	public void sendAddNotice(@RequestBody SendAddNoticeInput sendAddNoticeInput) throws SendMailException {
		String body = mailService.buildAddNotice(sendAddNoticeInput);
		mailSender.send("Sabati New Notice", body, sendAddNoticeInput.getUserMail());
	}
}