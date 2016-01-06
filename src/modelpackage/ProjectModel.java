package modelpackage;

import entityClassesPackage.ProjectDetailsTable;
import entityClassesPackage.TeamLoginTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.ProjectService;

public class ProjectModel {
     List<ProjectDetailsTable> projectdetailsList;
    private EntityManagerFactory factory;
    private EntityManager manager;
    private ProjectDetailsTable projectTable;
    private ProjectService projectService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
     public ProjectModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        projectService = new ProjectService(manager);
        projectTable = new ProjectDetailsTable();
        //teamLoginList = new TeamLoginTable();
    }
     
     public void addProject(String[] a){
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        
        ProjectDetailsTable newRecord;
         newRecord = projectService.createProject(a[0],a[1],a[2],a[3],a[4],a[5],a[6]);
        
        userTransaction.commit();
}
}
