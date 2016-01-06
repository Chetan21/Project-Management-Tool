package servicePackage;

import entityClassesPackage.ProjectDetailsTable;
import entityClassesPackage.TaskTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class TaskService {
    private List<TaskTable> taskDetails;
    private TaskTable taskEntry;
    private EntityManager manager;
    private TypedQuery<TaskTable> taskQuery;
    public TaskService(EntityManager manager){
        this.manager = manager;
    }
     public TaskTable createTask(Object taskName, Object taskDesc, Object taskStartDate, 
             Object taskEndDate, Object parentTask, Object taskDone, Object taskAssign, Object p){
        taskEntry = new TaskTable();
        taskEntry.setTaskName((String)taskName);
        taskEntry.setTaskDesc((String)taskDesc);
        taskEntry.setTaskStartDate((String)taskStartDate);
        taskEntry.setTaskEndDate((String)taskEndDate);
        taskEntry.setParentTask((String)parentTask);
        taskEntry.setTaskDone((String)taskDone);
        taskEntry.setTaskAssign((String)taskAssign);
        taskEntry.setProjectId((ProjectDetailsTable)p);
        manager.persist(taskEntry);
        return taskEntry;
    }
    public List<TaskTable> fetchAllTasks(){
        taskQuery = manager.createQuery("SELECT p FROM TaskTable p", TaskTable.class);
        taskDetails = taskQuery.getResultList();
        return taskDetails;
    } 
}
