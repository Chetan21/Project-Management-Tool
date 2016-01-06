package modelpackage;

import entityClassesPackage.TaskTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.TaskService;

public class TaskModel {
    private List<TaskTable> taskDetails;
    private EntityManagerFactory factory;
    private EntityManager manager;
    private TaskTable taskTable;
    private TaskService taskService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public TaskModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        taskService = new TaskService(manager);
        taskTable = new TaskTable();
        
    }
    
     public void addTask(Object[] a){
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        TaskTable newRecord = taskService.createTask(a[0],a[1],a[2],a[3],a[4],a[5],a[6], a[7]);
        userTransaction.commit();
    }
    public List<TaskTable> retrieveTasks(){
        taskDetails = taskService.fetchAllTasks();
        return taskDetails;
    }
}
