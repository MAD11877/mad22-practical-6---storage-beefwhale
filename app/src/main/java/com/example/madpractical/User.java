package com.example.madpractical;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String description;
    Integer id;
    Boolean followed;

    public User(){
        this.name = "TestName";
        this.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        this.id = 0;
        this.followed= followed;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setDesc(String description){
        this.description = description;
    }
    public String getDesc() {
        return this.description;
    }

    public void setID(Integer id){
        this.id = id;
    }
    public Integer getID() {
        return this.id;
    }

    public void setFollow(Boolean followed){
        this.followed = followed;
    }
    public Boolean getFollow() {
        return this.followed;
    }





}
