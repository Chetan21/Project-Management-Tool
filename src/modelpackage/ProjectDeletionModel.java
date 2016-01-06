/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.ProjectDetailsTable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.ProjectDeletionService;

/**
 *
 * @author Chetan
 */
public class ProjectDeletionModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private ProjectDetailsTable projectTable;
    private ProjectDeletionService projectDeleteService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public ProjectDeletionModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        projectTable = new ProjectDetailsTable();
        projectDeleteService = new ProjectDeletionService(manager);
    }
    
    public void deleteProject(ProjectDetailsTable project){
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        
        projectDeleteService.deleteProject(project);
        userTransaction.commit();        
        
        //fireTableRowsDeleted(getRowCount(), getColumnCount());
    }
}
