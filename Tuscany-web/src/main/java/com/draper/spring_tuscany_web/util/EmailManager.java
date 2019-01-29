package com.draper.spring_tuscany_web.util;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.MailAddressReceiver;
import com.sendcloud.sdk.model.MailBody;
import com.sendcloud.sdk.model.SendCloudMail;
import com.sendcloud.sdk.model.TextContent;
import com.sendcloud.sdk.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailManager {

    @Autowired
    private SendCloudBuilder sendCloudBuilder;

    public void sendVerifyCode(String emailAddress, String code) {
        MailAddressReceiver receiver = new MailAddressReceiver();
        // 添加收件人
        receiver.addTo(emailAddress);
        // 添加抄送
//		receiver.addCc("c@ifaxin.com");
        // 添加密送
//		receiver.addBcc("d@ifaxin.com");

        MailBody body = new MailBody();
        // 设置 From
        body.setFrom("sendcloud@sendcloud.org");
        // 设置 FromName
        body.setFromName("SendCloud");
        // 设置 ReplyTo
        body.setReplyTo("reply@sendcloud.org");
        // 设置标题
        body.setSubject("来自 SendCloud SDK 的邮件");
        // 创建文件附件
//		body.addAttachments(new File("D:/1.png"));
//		body.addAttachments(new File("D:/2.png"));
        //// 创建流附件
        // body.addAttachments(new FileInputStream(new File("D:/ff.png")));

        TextContent content = new TextContent();
        content.setContent_type(TextContent.ScContentType.html);
        content.setText("验证码为 " + code);

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);

        SendCloud sc = sendCloudBuilder.build();
        ResponseData res = null;
        try {
            res = sc.sendMail(mail);
            System.out.println(res.getResult());
            System.out.println(res.getStatusCode());
            System.out.println(res.getMessage());
            System.out.println(res.getInfo());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
