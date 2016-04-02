package org.ernest.applications.bt.manager.mails.ms.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.ernest.applications.bt.manager.mails.ct.SendAddMembersInput;
import org.ernest.applications.bt.manager.mails.ct.exceptions.SendMailException;
import org.ernest.applications.bt.manager.mails.ms.services.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {
	
	
	@Value("${url.bt.gui.activate.account}")
	private String urlGuiActivateAccount;
	
	@Value("${url.bt.gui.stage}")
	private String urlGuiStage;
	
	@Value("${url.bt.gui.team}")
	private String urlGuiTeam;
	
	@Override
	public String buildNewStage(String username, String teamname, String stagename, String stagedate, String stageId) throws SendMailException {
		try{

			String body = streamToString(this.getClass().getResourceAsStream("/templates/newstage.html"));
			body = body.replaceAll("#username", username);
			body = body.replaceAll("#teamname", teamname);
			body = body.replaceAll("#stagename", stagename);
			body = body.replaceAll("#stagedate", stagedate);
			
			body = body.replaceAll("#stageurl", urlGuiStage.replaceAll("#stageid", stageId));
			return body;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SendMailException(e.getMessage());
		}
	}

	@Override
	public String buildActivate(String username, String token) throws SendMailException {
		try{

			String body = streamToString(this.getClass().getResourceAsStream("/templates/activation.html"));
			body = body.replaceAll("#username", username);
			body = body.replaceAll("#activationUrl", urlGuiActivateAccount.replaceAll("#token", token));
			return body;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SendMailException(e.getMessage());
		}
	}
	
	@Override
	public String buildRecover(String pass) throws SendMailException {
		try{
			
			String body = streamToString(this.getClass().getResourceAsStream("/templates/recover.html"));
			body = body.replaceAll("#pass", pass);
			return body;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SendMailException(e.getMessage());
		}
	}

	@Override
	public String buildAddMember(SendAddMembersInput input) throws SendMailException {
		try{
			String body = streamToString(this.getClass().getResourceAsStream("/templates/addmember.html"));
			body = body.replaceAll("#username", input.getUserNameInvited());
			body = body.replaceAll("#teamname", input.getTeamName());
			body = body.replaceAll("#userinvitation", input.getUserNameSender());
			body = body.replaceAll("#teamurl", urlGuiTeam.replaceAll("#teamid", input.getTeamId()));
			return body;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SendMailException(e.getMessage());
		}
	}
	
	private String streamToString(InputStream inputStream) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        	throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
	}
}