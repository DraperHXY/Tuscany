package com.sendcloud.sdk.builder;

import com.sendcloud.sdk.config.Config;
import com.sendcloud.sdk.core.SendCloud;
import org.springframework.beans.factory.annotation.Autowired;

public class SendCloudBuilder {

	@Autowired
	private SendCloud sendCloud;

	public void setSendCloud(SendCloud sendCloud) {
		this.sendCloud = sendCloud;
	}

	public SendCloud getSendCloud() {
		return sendCloud;
	}

	public SendCloud build() {
		sendCloud.setServer(Config.server);
		sendCloud.setMailAPI(Config.send_api);
		sendCloud.setTemplateAPI(Config.send_template_api);
		sendCloud.setSmsAPI(Config.send_sms_api);
		sendCloud.setVoiceAPI(Config.send_voice_api);
		return sendCloud;
	}
}