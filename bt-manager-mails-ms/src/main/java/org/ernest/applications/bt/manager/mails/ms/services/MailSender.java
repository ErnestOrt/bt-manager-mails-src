package org.ernest.applications.bt.manager.mails.ms.services;

import org.ernest.applications.bt.manager.mails.ct.exceptions.SendMailException;

public interface MailSender {

	void send(String title, String body, String to) throws SendMailException;
}
