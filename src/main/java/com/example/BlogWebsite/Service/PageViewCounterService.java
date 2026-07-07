package com.example.BlogWebsite.Service;

import com.example.BlogWebsite.Model.PageViewCounter;
import com.example.BlogWebsite.Repository.PageViewCounterRepository;
import org.springframework.stereotype.Service;

@Service
public class PageViewCounterService {

    private final PageViewCounterRepository repository;

    public PageViewCounterService(PageViewCounterRepository repository) {
        this.repository = repository;
    }

    public long incrementAndGet() {
        PageViewCounter counter = repository.findById(1L).orElseGet(() -> {
            PageViewCounter newCounter = new PageViewCounter();
            newCounter.setCount(0);
            return repository.save(newCounter);
        });

        repository.incrementCount(counter.getId());

        return repository.findById(counter.getId()).get().getCount();
    }
}