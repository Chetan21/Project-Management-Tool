/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.MemberDetailsTable;
import entityClassesPackage.ProjectDetailsTable;
import javax.persistence.EntityManager;

/**
 *
 * @author Chetan
 */
public class ProjectDeletionService {
    private EntityManager manager;
    private ProjectDetailsTable project;
    private int projectId;
    
    public ProjectDeletionService(EntityManager manager){
        this.manager = manager;
        project = new ProjectDetailsTable();
    }
    
    public void deleteProject(ProjectDetailsTable project){
        projectId = project.getProjectId();
        project = manager.find(ProjectDetailsTable.class, projectId);
        manager.remove(project);
    }
}
