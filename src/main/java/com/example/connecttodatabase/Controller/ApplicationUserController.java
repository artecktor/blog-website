package com.example.connecttodatabase.Controller;

import com.example.connecttodatabase.DTO.UserSaveDTO;
import com.example.connecttodatabase.Model.ApplicationUser;
import com.example.connecttodatabase.Model.Role;
import com.example.connecttodatabase.Service.ApplicationUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        ApplicationUser applicationUser = applicationUserService.findById(id);
        applicationUserService.delete(applicationUser);
    }

    @GetMapping("/{id}")
    public ApplicationUser findById(@PathVariable int id) {
        return applicationUserService.findById(id);
    }
    @GetMapping
    public List<ApplicationUser> findAll() {
        return applicationUserService.findAll();
    }
}
