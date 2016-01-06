/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vishnu
 */
@Entity
@Table(name = "project_details_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectDetailsTable.findAll", query = "SELECT p FROM ProjectDetailsTable p"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectId", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectName", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectDescription", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectDescription = :projectDescription"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectStartDate", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectStartDate = :projectStartDate"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectEndDate", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectEndDate = :projectEndDate"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectStatus", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectStatus = :projectStatus"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectTag", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectTag = :projectTag"),
    @NamedQuery(name = "ProjectDetailsTable.findByProjectOutcome", query = "SELECT p FROM ProjectDetailsTable p WHERE p.projectOutcome = :projectOutcome")})
public class ProjectDetailsTable implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "projectDetailsTable")
    private ProjectTeamMappingTable projectTeamMappingTable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<CommunicationTable> communicationTableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<BudgetTable> budgetTableList;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_id")
    private Integer projectId;
    @Basic(optional = false)
    @Column(name = "project_name")
    private String projectName;
    @Basic(optional = false)
    @Column(name = "project_description")
    private String projectDescription;
    @Basic(optional = false)
    @Column(name = "project_start_date")
    private String projectStartDate;
    @Column(name = "project_end_date")
    private String projectEndDate;
    @Column(name = "project_status")
    private String projectStatus;
    @Column(name = "project_tag")
    private String projectTag;
    @Column(name = "project_outcome")
    private String projectOutcome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private Collection<TaskTable> taskTableCollection;

    public ProjectDetailsTable() {
    }

    public ProjectDetailsTable(Integer projectId) {
        this.projectId = projectId;
    }

    public ProjectDetailsTable(Integer projectId, String projectName, String projectDescription, String projectStartDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStartDate = projectStartDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        Integer oldProjectId = this.projectId;
        this.projectId = projectId;
        changeSupport.firePropertyChange("projectId", oldProjectId, projectId);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        String oldProjectName = this.projectName;
        this.projectName = projectName;
        changeSupport.firePropertyChange("projectName", oldProjectName, projectName);
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        String oldProjectDescription = this.projectDescription;
        this.projectDescription = projectDescription;
        changeSupport.firePropertyChange("projectDescription", oldProjectDescription, projectDescription);
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        String oldProjectStartDate = this.projectStartDate;
        this.projectStartDate = projectStartDate;
        changeSupport.firePropertyChange("projectStartDate", oldProjectStartDate, projectStartDate);
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        String oldProjectEndDate = this.projectEndDate;
        this.projectEndDate = projectEndDate;
        changeSupport.firePropertyChange("projectEndDate", oldProjectEndDate, projectEndDate);
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        String oldProjectStatus = this.projectStatus;
        this.projectStatus = projectStatus;
        changeSupport.firePropertyChange("projectStatus", oldProjectStatus, projectStatus);
    }

    public String getProjectTag() {
        return projectTag;
    }

    public void setProjectTag(String projectTag) {
        String oldProjectTag = this.projectTag;
        this.projectTag = projectTag;
        changeSupport.firePropertyChange("projectTag", oldProjectTag, projectTag);
    }

    public String getProjectOutcome() {
        return projectOutcome;
    }

    public void setProjectOutcome(String projectOutcome) {
        String oldProjectOutcome = this.projectOutcome;
        this.projectOutcome = projectOutcome;
        changeSupport.firePropertyChange("projectOutcome", oldProjectOutcome, projectOutcome);
    }

    @XmlTransient
    public Collection<TaskTable> getTaskTableCollection() {
        return taskTableCollection;
    }

    public void setTaskTableCollection(Collection<TaskTable> taskTableCollection) {
        this.taskTableCollection = taskTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetailsTable)) {
            return false;
        }
        ProjectDetailsTable other = (ProjectDetailsTable) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.ProjectDetailsTable[ project_name=" + projectName + "," + "project_description" +
              "projectDescription" +  "," + "project_start_date" + projectStartDate + "," + "project_end_date" 
                + projectEndDate + "," + "project_status" + projectStatus + "," + "project_tag" +projectTag + "," 
                + "project_outcome" + projectOutcome + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public ProjectTeamMappingTable getProjectTeamMappingTable() {
        return projectTeamMappingTable;
    }

    public void setProjectTeamMappingTable(ProjectTeamMappingTable projectTeamMappingTable) {
        this.projectTeamMappingTable = projectTeamMappingTable;
    }

    public List<CommunicationTable> getCommunicationTableList() {
        return communicationTableList;
    }

    public void setCommunicationTableList(List<CommunicationTable> communicationTableList) {
        this.communicationTableList = communicationTableList;
    }

    public List<BudgetTable> getBudgetTableList() {
        return budgetTableList;
    }

    public void setBudgetTableList(List<BudgetTable> budgetTableList) {
        this.budgetTableList = budgetTableList;
    }
    
}
