package com.auditDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditDemo.entities.tables.PullRequest;

@Repository
public interface PullRequestRepo extends JpaRepository<PullRequest, Long>{

}
