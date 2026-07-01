package com.example.connecttodatabase.Service;

import com.example.connecttodatabase.Model.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {
    void save(ApplicationUser user);

    void delete(ApplicationUser user);

    void update(ApplicationUser user);

    ApplicationUser findByUsernameAndPassword(String username, String password);

    ApplicationUser findById(int id);

    List<ApplicationUser> findAll();
}
