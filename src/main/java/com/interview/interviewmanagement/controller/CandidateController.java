package com.interview.interviewmanagement.controller;

import com.interview.interviewmanagement.entity.Candidate;
import com.interview.interviewmanagement.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateRepository repo;

    public CandidateController(CandidateRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Candidate> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Candidate save(@Valid @RequestBody Candidate c) {
        return repo.save(c);
    }

    @GetMapping("/skill/{skill}")
    public List<Candidate> bySkill(@PathVariable String skill) {
        return repo.findBySkill(skill);
    }

    @GetMapping("/status/{status}")
    public List<Candidate> byStatus(@PathVariable String status) {
        return repo.findByStatus(status);
    }
}
