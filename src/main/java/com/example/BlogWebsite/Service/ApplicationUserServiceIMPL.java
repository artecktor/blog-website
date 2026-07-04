package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.ApplicationUser;
import com.example.BlogWebsite.Model.Comment;
import com.example.BlogWebsite.Model.Role;
import com.example.BlogWebsite.Repository.ApplicationUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceIMPL implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceIMPL(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void save(ApplicationUser user) {
        applicationUserRepository.save(user);
    }

    @Override
    public void delete(ApplicationUser user) {
        applicationUserRepository.delete(user);
    }

    @Override
    public void update(ApplicationUser user) {
        applicationUserRepository.save(user);
    }

    @Transactional
    @Override
    public void promote(int id) {
        ApplicationUser user = applicationUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        user.setRole(Role.ADMIN);
    }
    @Transactional
    @Override
    public void demote(int id) {
        ApplicationUser user = applicationUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        user.setRole(Role.USER);
    }

    @Override
    public ApplicationUser findByEmailAndPassword(String email, String password) {
        return applicationUserRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public ApplicationUser findById(int id) {
        return applicationUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }
}
