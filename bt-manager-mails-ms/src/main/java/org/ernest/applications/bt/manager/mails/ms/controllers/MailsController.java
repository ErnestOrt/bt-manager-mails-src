package org.ernest.applications.bt.manager.mails.ms.controllers;

import org.ernest.applications.bt.manager.mails.ct.SendActivateInput;
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
		mailSender.send("Bike Team Account Activation", body, sendActivateInput.getUsermail());
	}
	
	@RequestMapping("/sendrecover")
	public void sendRecover(@RequestBody SendRecoverInput sendRecoverInput) throws SendMailException {
		String body = mailService.buildRecover(sendRecoverInput.getPass());
		mailSender.send("Bike Team Account Recovery", body, sendRecoverInput.getEmail());
		
	}
}