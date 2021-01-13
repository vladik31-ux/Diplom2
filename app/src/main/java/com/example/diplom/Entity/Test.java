package com.example.diplom.Entity;

public class Test {

    int id;
    String Name;
    String Description;
    String Duration;
    String Questions_count;
    boolean isPass;

    public Test()
    {

    }

    public Test(int id, String Name, String Description, String Duration, boolean isPass){
        this.id = id;
        this.Name = Name;
        this.Description = Description;
        this.Duration = Duration;
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

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }


    public String getQuestions_count() {
        return Questions_count;
    }

    public void setQuestions_count(String questions_count) {
        Questions_count = questions_count;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }
}
