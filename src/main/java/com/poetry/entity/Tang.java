package com.poetry.entity;

public class Tang {
    private Integer id;

    private String title;

    private String poem;

    private String strains;

    private Poet poet;

    private Integer point;//点赞数

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

    public String getPoem() {
        return poem;
    }

    public void setPoem(String poem) {
        this.poem = poem == null ? null : poem.trim();
    }

    public String getStrains() {
        return strains;
    }

    public void setStrains(String strains) {
        this.strains = strains == null ? null : strains.trim();
    }

    public Poet getPoet() {
        return poet;
    }

    public void setPoet(Poet poet) {
        this.poet = poet;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}