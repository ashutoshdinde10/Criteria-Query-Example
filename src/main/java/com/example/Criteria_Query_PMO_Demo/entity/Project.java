package com.example.Criteria_Query_PMO_Demo.entity;
import com.example.Criteria_Query_PMO_Demo.enums.ProjectCategory;
import com.example.Criteria_Query_PMO_Demo.enums.ProjectDomain;
import com.example.Criteria_Query_PMO_Demo.enums.ProjectStatus;
import com.example.Criteria_Query_PMO_Demo.enums.ProjectType;
import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "projectManager")
    private String projectManager;


    @Column(name = "projectStatus")
    @Enumerated(value = EnumType.STRING)
    private ProjectStatus projectStatus;

    @Column(name = "projectDomain")
    @Enumerated(value = EnumType.STRING)
    private ProjectDomain projectDomain;

    @Column(name = "projectType")
    @Enumerated(value = EnumType.STRING)
    private ProjectType projectType;

    @Column(name = "projectCategory")
    @Enumerated(value = EnumType.STRING)
    private ProjectCategory projectCategory;

    @Column(name = "billableResources")
    private Integer billableResources;

    @Column(name = "nonBillableResources")
    private Integer nonBillableResources;

    public Project() {
    }

    public Project(String projectName, String projectManager, ProjectStatus projectStatus, ProjectDomain projectDomain, ProjectType projectType, ProjectCategory projectCategory, Integer billableResources, Integer nonBillableResources) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.projectStatus = projectStatus;
        this.projectDomain = projectDomain;
        this.projectType = projectType;
        this.projectCategory = projectCategory;
        this.billableResources = billableResources;
        this.nonBillableResources = nonBillableResources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public ProjectDomain getProjectDomain() {
        return projectDomain;
    }

    public void setProjectDomain(ProjectDomain projectDomain) {
        this.projectDomain = projectDomain;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public ProjectCategory getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

    public Integer getBillableResources() {
        return billableResources;
    }

    public void setBillableResources(Integer billableResources) {
        this.billableResources = billableResources;
    }

    public Integer getNonBillableResources() {
        return nonBillableResources;
    }

    public void setNonBillableResources(Integer nonBillableResources) {
        this.nonBillableResources = nonBillableResources;
    }
}
