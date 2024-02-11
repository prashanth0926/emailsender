package com.remote.emailsender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailTemplate {

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private TemplateEngine templateEngine;

    public String sendHtmlEmail(String to, String subject, String title, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true indicates multipart message

            // Create the Thymeleaf context
            Context thymeleafContext = new Context();
            thymeleafContext.setVariable("title", title);
            thymeleafContext.setVariable("content", content);

            // Process the HTML template
            String emailBody = templateEngine.process("email-template", thymeleafContext);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(emailBody, true); // true indicates html content

            javaMailSender.send(message);

            return "Email template sent successfully";
        } catch (MessagingException e) {
            // Handle or log the exception
            e.printStackTrace();
            return "Failed to send email template";
        }
    }
}
