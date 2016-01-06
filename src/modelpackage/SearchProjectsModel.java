/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.ProjectDetailsTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import servicePackage.SearchProjectsService;

/**
 *
 * @author Chetan
 */
public class SearchProjectsModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    private List<ProjectDetailsTable> projects;
    private ProjectDetailsTable allProjects;
    private SearchProjectsService searchProjects;
            
    public SearchProjectsModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        allProjects = new ProjectDetailsTable();
        searchProjects = new SearchProjectsService(manager);
    }
    public List<ProjectDetailsTable> retrieveProjects(){
        
        projects = searchProjects.fetchAllProjectNames();
        //System.out.println(projects.get(0).getProjectName());
        
        return projects;
    }
}
