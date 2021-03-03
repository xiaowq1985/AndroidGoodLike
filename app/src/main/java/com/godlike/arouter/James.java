package com.godlike.arouter;

import android.os.Parcel;
import android.os.Parcelable;

public class James implements Parcelable {
    private int age;
    private String name;

    public James(int age, String name) {
        this.age = age;
        this.name = name;
    }

    protected James(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    public static final Creator<James> CREATOR = new Creator<James>() {
        @Override
        public James createFromParcel(Parcel in) {
            return new James(in);
        }

        @Override
        public James[] newArray(int size) {
            return new James[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return "James{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
