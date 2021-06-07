package com.tansun.pojo;

import java.io.Serializable;

public class Item implements Serializable {

    private Integer id;
    private String name;
    private Integer number;

    public Item() {
    }

    public Item(Integer id, String name, Integer number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
