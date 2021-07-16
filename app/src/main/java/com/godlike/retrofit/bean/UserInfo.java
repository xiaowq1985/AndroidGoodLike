package com.godlike.retrofit.bean;

public class UserInfo {
    private String userId;
    private String userName;
    private String describe;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
