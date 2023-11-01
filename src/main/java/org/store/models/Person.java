package org.store.models;

import org.store.enums.Gender;

public abstract class Person {
private final String name;
private final String phoneNumber;
private final Gender gender;
private final String emailAddress;

    public Person(String name, String phoneNumber, Gender gender, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }



    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Gender getGender() {
        return gender;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
