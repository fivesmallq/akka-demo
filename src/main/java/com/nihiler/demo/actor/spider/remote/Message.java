package com.nihiler.demo.actor.spider.remote;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
        return ToStringBuilder.reflectionToString(this);
    }

}