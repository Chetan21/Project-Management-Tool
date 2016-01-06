/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.ProjectDetailsTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chetan
 */
public class SearchProjectsService {
    private ProjectDetailsTable projectDetails;
    private TypedQuery<ProjectDetailsTable> projectNameQuery;
    private EntityManager manager;
    private List<ProjectDetailsTable> projectNames;
    
    public SearchProjectsService(EntityManager manager){
        this.manager = manager;
    }
    public List<ProjectDetailsTable> fetchAllProjectNames(){
        projectNameQuery = manager.createQuery("SELECT p FROM ProjectDetailsTable p ", ProjectDetailsTable.class);
        projectNames = projectNameQuery.getResultList();
        return projectNames;
    }
}
