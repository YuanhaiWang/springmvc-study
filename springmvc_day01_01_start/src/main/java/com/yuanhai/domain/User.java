package com.yuanhai.domain;

import java.io.Serializable;

/**
 * @author yuanhai
 * @date 2020/12/6
 */
public class User implements Serializable {

    private String uName;
    private Integer age;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", age=" + age +
                '}';
    }
}
