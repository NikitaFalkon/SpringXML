package ru.nik;

import java.text.DateFormat;
import java.util.zip.DataFormatException;

public class Event {
    private  int id = (int) ( Math.random() * 15 );
    private String msg;
    private String date;
    private DateFormat df;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
