package com.example.tom.finalexam;

/**
 * Created by Tom on 12/8/2015.
 */
public class Meeting {

    public int _id;
    public String name;
    public String description;
    public String location;
    public String date;
    public String time;
    public int _hostid;

    public Meeting(){

    }

    public Meeting(String name, String description, String location, String date, String time, int _hostid) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this._hostid = _hostid;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int get_hostid() {
        return _hostid;
    }

    public void set_hostid(int _hostid) {
        this._hostid = _hostid;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", _hostid=" + _hostid +
                '}';
    }
}
