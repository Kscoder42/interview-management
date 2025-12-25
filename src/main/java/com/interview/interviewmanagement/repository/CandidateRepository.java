package com.interview.interviewmanagement.repository;

import com.interview.interviewmanagement.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findBySkill(String skill);

    List<Candidate> findByStatus(String status);
}
