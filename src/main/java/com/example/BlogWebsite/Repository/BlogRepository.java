package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
