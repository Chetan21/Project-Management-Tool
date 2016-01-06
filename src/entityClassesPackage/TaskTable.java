/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vishnu
 */
@Entity
@Table(name = "task_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskTable.findAll", query = "SELECT t FROM TaskTable t"),
    @NamedQuery(name = "TaskTable.findByTaskId", query = "SELECT t FROM TaskTable t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "TaskTable.findByTaskName", query = "SELECT t FROM TaskTable t WHERE t.taskName = :taskName"),
    @NamedQuery(name = "TaskTable.findByTaskDesc", query = "SELECT t FROM TaskTable t WHERE t.taskDesc = :taskDesc"),
    @NamedQuery(name = "TaskTable.findByTaskStartDate", query = "SELECT t FROM TaskTable t WHERE t.taskStartDate = :taskStartDate"),
    @NamedQuery(name = "TaskTable.findByTaskEndDate", query = "SELECT t FROM TaskTable t WHERE t.taskEndDate = :taskEndDate"),
    @NamedQuery(name = "TaskTable.findByParentTask", query = "SELECT t FROM TaskTable t WHERE t.parentTask = :parentTask"),
    @NamedQuery(name = "TaskTable.findByTaskDone", query = "SELECT t FROM TaskTable t WHERE t.taskDone = :taskDone"),
    @NamedQuery(name = "TaskTable.findByTaskAssign", query = "SELECT t FROM TaskTable t WHERE t.taskAssign = :taskAssign")})
public class TaskTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_desc")
    private String taskDesc;
    @Column(name = "task_start_date")
    private String taskStartDate;
    @Column(name = "task_end_date")
    private String taskEndDate;
    @Column(name = "parent_task")
    private String parentTask;
    @Column(name = "task_done")
    private String taskDone;
    @Column(name = "task_assign")
    private String taskAssign;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private ProjectDetailsTable projectId;

    public TaskTable() {
    }

    public TaskTable(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(String taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public String getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(String taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public String getTaskDone() {
        return taskDone;
    }

    public void setTaskDone(String taskDone) {
        this.taskDone = taskDone;
    }

    public String getTaskAssign() {
        return taskAssign;
    }

    public void setTaskAssign(String taskAssign) {
        this.taskAssign = taskAssign;
    }

    public ProjectDetailsTable getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectDetailsTable projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskTable)) {
            return false;
        }
        TaskTable other = (TaskTable) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.TaskTable[ taskId=" + taskId + " ]";
    }

    public void setProjectId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
