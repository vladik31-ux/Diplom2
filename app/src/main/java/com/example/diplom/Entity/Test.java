package com.example.diplom.Entity;

public class Test {

    int id;
    String Name;
    String Description;
    String Time;
    String Code;
    int picture;
    boolean isPass;

    public Test(int id, String Name, String Description, String Time, int picture, boolean isPass){
        this.id = id;
        this.Name = Name;
        this.Description = Description;
        this.Time = Time;
        this.picture = picture;
        this.isPass = isPass;
    }

    public Test(String Name, String Description, boolean isPass){
        this.Name = Name;
        this.Description = Description;
        this.isPass = isPass;
    }

    public Test(String Name, String Description, boolean isPass, String Code){
        this.Name = Name;
        this.Description = Description;
        this.isPass = isPass;
    }

    public Test(String Name, String Description, boolean isPass, int picture){
        this.Name = Name;
        this.Description = Description;
        this.isPass = isPass;
        this.picture = picture;
    }

    public Test(String Name, String Description, boolean isPass, int picture, String Code){
        this.Name = Name;
        this.Description = Description;
        this.isPass = isPass;
        this.picture = picture;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
