package com.example.Criteria_Query_PMO_Demo.service;

import com.example.Criteria_Query_PMO_Demo.repository.ProjectRepository;
import com.example.Criteria_Query_PMO_Demo.entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final EntityManager entityManager;
    @Autowired
    public ProjectService(ProjectRepository projectRepository, EntityManager entityManager) {
        this.projectRepository = projectRepository;
        this.entityManager = entityManager;
    }
/// test
    public String addProject(Project project){

        projectRepository.save(project);

        return "Project Added Successfully";
    }


    public List<Project> filterAndSearch(String projectStatus, String projectDomain, String projectType, String projectCategory){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Project> cq = cb.createQuery(Project.class);

        Root<Project> root =cq.from(Project.class);

        List<Predicate> predicates = new ArrayList<>();

        if(projectStatus != null && !projectStatus.isEmpty()){
            predicates.add(cb.equal(root.get("projectStatus"),projectStatus));
        }

        if(projectDomain != null && !projectDomain.isEmpty()){
            predicates.add(cb.equal(root.get("projectDomain"),projectDomain));
        }

        if(projectType != null && !projectType.isEmpty()){
            predicates.add(cb.equal(root.get("projectType"),projectType));
        }

        if(projectCategory != null && !projectCategory.isEmpty()){
            predicates.add(cb.equal(root.get("projectCategory"),projectCategory));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}
