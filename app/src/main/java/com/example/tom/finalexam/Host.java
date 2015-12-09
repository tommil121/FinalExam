package com.example.tom.finalexam;

/**
 * Created by Tom on 12/8/2015.
 */
public class Host {

    public int _id;
    public String email;

    public Host(){

    }

    public Host(String email) {
        this.email = email;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Host{" +
                "_id=" + _id +
                ", email='" + email + '\'' +
                '}';
    }
}
