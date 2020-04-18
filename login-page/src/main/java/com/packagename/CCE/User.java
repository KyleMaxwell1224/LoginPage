package com.packagename.CCE;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String hashedPassword;
    private String phoneNumber;

    public User(){}
    void setPassword(String password)
    {
        String hexForm = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        this.hashedPassword = hexForm;
    }
    String getPassword() //BETA TESTING METHOD... DELETE, DO NOT HAVE THIS
    {
        return hashedPassword;
    }
    void setFirstName(String registeredFirstName)
    {
        this.firstName = registeredFirstName;
    }
    String getFirstName()
    {
        return firstName;
    }
    void setLastName(String registeredLastName)
    {
        this.lastName = registeredLastName;
    }
    String getLastName()
    {
        return lastName;
    }
    void setUserName(String registeredUsername){
        this.userName = registeredUsername;
    }
    String getUserName()
    {
        return userName;
    }
    void setPhoneNumber(String CountryCode, String PhoneNumber)
    {
        this.phoneNumber = CountryCode+PhoneNumber;
    }
    String getPhoneNumber()
    {
        return phoneNumber;
    }
}
