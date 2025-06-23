package com.example.Criteria_Query_PMO_Demo.controller;

import com.example.Criteria_Query_PMO_Demo.entity.Project;
import com.example.Criteria_Query_PMO_Demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/project")
    public String addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @GetMapping("/filter")
    public List<Project> filterProject(
            @RequestParam (required = false) String projectStatus,
            @RequestParam (required = false) String projectDomain,
            @RequestParam (required = false) String projectType,
            @RequestParam (required = false) String projectCategory
    ){
        List<Project> temp = projectService.filterAndSearch(projectStatus,projectDomain,projectType,projectCategory);
        return temp;
    }
}
