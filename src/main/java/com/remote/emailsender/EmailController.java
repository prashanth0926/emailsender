package com.remote.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remote.emailsender.dto.EmailRequest;
import com.remote.emailsender.dto.EmailTemplateRequest;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService; 

    @Autowired
    private EmailTemplate emailTemplate; 

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        return emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
    }

    @PostMapping("/send-template")
    public String sendEmailTemplate(@RequestBody EmailTemplateRequest templateRequest) {
        return emailTemplate.sendHtmlEmail(templateRequest.getTo(), templateRequest.getSubject(), templateRequest.getTitle(), templateRequest.getContent());
    }
}
