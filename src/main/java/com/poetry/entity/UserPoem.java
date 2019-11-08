package com.poetry.entity;

public class UserPoem {
    private Integer id;

    private String title;

    private String userPoem;

    private String author;

    private String openId;

    private String issueTime;

    private Integer status;//诗的状态：0，删除，1审核中，2审核通过，3审批拒绝，

    private Integer point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUserPoem() {
        return userPoem;
    }

    public void setUserPoem(String userPoem) {
        this.userPoem = userPoem == null ? null : userPoem.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime == null ? null : issueTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}