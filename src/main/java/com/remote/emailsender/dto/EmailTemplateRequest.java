package com.remote.emailsender.dto;

public class EmailTemplateRequest {
  private String to;
  private String subject;
  private String title;
  private String content;

  public String getTo() {
    return to;
  }

  public String getSubject() {
    return subject;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }
}