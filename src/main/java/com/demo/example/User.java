package com.demo.example;

import java.util.Date;

public class User implements java.io.Serializable {

  private static final long serialVersionUID = -3960396761249882840L;

  private Long userId;

  private String userName;

  private String createdBy;

  private Date createdDate;

  public User() {}

  public User(Long userId, String userName, String createdBy, Date createdDate) {
    this.userId = userId;
    this.userName = userName;
    this.createdBy = createdBy;
    this.createdDate = createdDate;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

}
