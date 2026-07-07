package com.example.BlogWebsite.Repository;

import com.example.BlogWebsite.Model.PageViewCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PageViewCounterRepository extends JpaRepository<PageViewCounter, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE PageViewCounter c SET c.count = c.count + 1 WHERE c.id = :id")
    void incrementCount(Long id);
}