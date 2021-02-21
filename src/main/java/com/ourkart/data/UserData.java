package com.ourkart.data;


import java.util.List;

public class UserData {

    private String uid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    List<AddressData> addresses;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<AddressData> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressData> addresses) {
        this.addresses = addresses;
    }
}
