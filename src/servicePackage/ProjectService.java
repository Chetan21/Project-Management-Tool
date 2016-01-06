package servicePackage;

import entityClassesPackage.ProjectDetailsTable;
import javax.persistence.EntityManager;


public class ProjectService {
    private ProjectDetailsTable projectEntry;
    private EntityManager manager;
    public ProjectService(EntityManager manager){
        this.manager = manager;
    }
    public ProjectDetailsTable createProject(String projectName, String projectDescription, String projectStartDate, String projectEndDate, String projectStatus, String projectTag, String projectOutcome){
        projectEntry = new ProjectDetailsTable();
        
         //projectEntry.setProjectId(projectId);
        projectEntry.setProjectName(projectName);
        projectEntry.setProjectDescription(projectDescription);
        projectEntry.setProjectStartDate(projectStartDate);
        projectEntry.setProjectEndDate(projectEndDate);
        projectEntry.setProjectStatus(projectStatus);
        projectEntry.setProjectTag(projectTag);
        projectEntry.setProjectOutcome(projectOutcome);
        manager.persist(projectEntry);
        return projectEntry;
    }
}
