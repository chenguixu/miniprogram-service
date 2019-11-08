package com.poetry.entity;

public class PoemComment {
    private Integer id;

    private Integer poemId;

    private String openId;

    private String comment;

    private String commentTime;

    private PoemUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoemId() {
        return poemId;
    }

    public void setPoemId(Integer poemId) {
        this.poemId = poemId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }

    public PoemUser getUser() {
        return user;
    }

    public void setUser(PoemUser user) {
        this.user = user;
    }
}