package com.tcm.quest.model;

public class UserInfoPress {
    private Integer userId;

    private String name;

    private String sex;

    private Integer pressHigh;

    private Integer pressLow;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getPressHigh() {
        return pressHigh;
    }

    public void setPressHigh(Integer pressHigh) {
        this.pressHigh = pressHigh;
    }

    public Integer getPressLow() {
        return pressLow;
    }

    public void setPressLow(Integer pressLow) {
        this.pressLow = pressLow;
    }
}