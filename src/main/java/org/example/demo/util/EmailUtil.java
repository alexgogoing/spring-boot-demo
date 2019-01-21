package org.example.demo.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {

    private static final String MAIL_HOST = "smtp.sina.com";
    private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
    private static final String USER = "jinxc_gorgeous@sina.com";
    // 这个秘密不是邮箱的密码，是要去163邮箱开通申请得到的
    private static final String PASSWORD = "qq9044123";

    public static boolean sendEmail(String to, String title, String text){
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", MAIL_HOST);
            prop.setProperty("mail.transport.protocol", MAIL_TRANSPORT_PROTOCOL);
            prop.setProperty("mail.smtp.auth", "true");
            Session session = Session.getInstance(prop);
            //开启debug模式，方便看程序发送Email的运行状态
            session.setDebug(false);
            Transport ts = session.getTransport();
            ts.connect(MAIL_HOST, USER, PASSWORD);
            Message message = simpleMail(session, to, title, text);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            return true;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 一封简单的只包含文本的邮件
     */
    public static MimeMessage simpleMail(Session session, String to, String subject, String content) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USER));
        message.addRecipients(Message.RecipientType.CC, new InternetAddress[]{new InternetAddress(USER)});
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setContent(content, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }

}
