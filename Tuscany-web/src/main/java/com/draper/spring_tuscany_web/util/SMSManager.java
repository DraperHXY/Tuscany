package com.draper.spring_tuscany_web.util;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class SMSManager extends CCPRestSmsSDK {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private String serverIP;
    private String serverPort;
    private String accountSid;
    private String accountToken;
    private String appId;


    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public HashMap<String, Object> sendTemplateSMS(String to, String templateId, String[] datas) {

        LOGGER.warn("serverIp = {}", serverIP);
        LOGGER.warn("serverPort = {}", serverPort);
        LOGGER.warn("accountSid = {}", accountSid);
        LOGGER.warn("accountToken = {}", accountToken);
        LOGGER.warn("appId = {}", appId);

        super.init(serverIP, serverPort);
        super.setAccount(accountSid, accountToken);
        super.setAppId(appId);
        return super.sendTemplateSMS(to, templateId, datas);
    }
}
