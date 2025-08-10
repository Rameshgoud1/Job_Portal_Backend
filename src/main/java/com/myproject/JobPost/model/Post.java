package com.myproject.JobPost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "JobPost")
public class Post {
    @Id
    private String _id;
    private  String desc;

    public Post(String _id, String desc, int exp, String profile, String[] techs) {
        this._id = _id;
        this.desc = desc;
        this.exp = exp;
        this.profile = profile;
        this.techs = techs;
    }

    private int exp;
    private String profile;
    private String[] techs;

    public Post() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }
}