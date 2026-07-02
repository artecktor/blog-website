package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser findByEmailAndPassword(String username, String password);
    @Query("SELECT u FROM ApplicationUser u WHERE u.username = :name")
    List<ApplicationUser> getUsersByName(@Param("name") String name);

}
