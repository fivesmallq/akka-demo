package com.nihiler.demo.actor.spider.remote;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class Message implements Serializable {
    private String data;
    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("data", getData()).toString();
    }

}