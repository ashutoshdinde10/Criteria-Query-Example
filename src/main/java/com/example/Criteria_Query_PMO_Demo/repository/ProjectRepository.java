package com.example.Criteria_Query_PMO_Demo.repository;

import com.example.Criteria_Query_PMO_Demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
