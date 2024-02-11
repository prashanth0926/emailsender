package com.remote.emailsender.dto;

public class EmailRequest {
  private String to;
  private String subject;
  private String body;

  public String getTo() {
    return to;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }
}
