package com.tansun.pojo;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private Integer id;
    private User user;
    private List<Item> items;

    public Order() {
    }

    public Order(Integer id, User user, List<Item> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
