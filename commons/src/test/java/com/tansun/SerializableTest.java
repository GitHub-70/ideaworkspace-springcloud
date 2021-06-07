package com.tansun;

import com.tansun.utils.JsonResult;

import java.io.Serializable;

public class SerializableTest {
    public static void main(String[] args) {
        JsonResult<Object> jsonResult = new JsonResult<>();
        if (jsonResult instanceof Serializable)
            System.out.println("jsonResult已被序列化");
    }
}
