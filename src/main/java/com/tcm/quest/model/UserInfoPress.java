package com.tcm.quest.model;

public class UserInfoPress {
    private Integer userId;

    private String name;

    private Integer age;

    private String sex;

    private Integer pressHigh;

    private Integer pressLow;

    private String hospital;

    private Integer visits;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

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

    @Override
    public String toString() {
        return "UserInfoPress{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", pressHigh=" + pressHigh +
                ", pressLow=" + pressLow +
                ", hospital='" + hospital + '\'' +
                ", visits=" + visits +
                '}';
    }
}