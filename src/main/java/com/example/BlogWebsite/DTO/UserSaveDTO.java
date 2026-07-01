package com.example.BlogWebsite.DTO;

import com.example.BlogWebsite.Model.ApplicationUser;

public class UserSaveDTO {
    private String username;
    private String password;
    private String email;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ApplicationUser convertToApplicationUser() {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(this.username);
        applicationUser.setPassword(this.password);
        applicationUser.setEmail(this.email);
        applicationUser.setAddress(this.address);
        return applicationUser;
    }
}
