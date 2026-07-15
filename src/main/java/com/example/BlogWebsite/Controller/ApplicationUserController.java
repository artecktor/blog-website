package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Service.ApplicationUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {
    private final ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @DeleteMapping("/{id}")
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
    @GetMapping("/promote/{id}")
    public void promote(@PathVariable int id) {
        applicationUserService.promote(id);
    }
    @GetMapping("/demote/{id}")
    public void demote(@PathVariable int id) {
        applicationUserService.demote(id);
    }
}
