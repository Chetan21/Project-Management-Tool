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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Chetan
 */
@Entity
@Table(name = "project_team_mapping_table")
@NamedQueries({
    @NamedQuery(name = "ProjectTeamMappingTable.findAll", query = "SELECT p FROM ProjectTeamMappingTable p"),
    @NamedQuery(name = "ProjectTeamMappingTable.findByProjectId", query = "SELECT p FROM ProjectTeamMappingTable p WHERE p.projectId = :projectId")})
public class ProjectTeamMappingTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "project_id")
    private Integer projectId;
    @JoinColumn(name = "team_username", referencedColumnName = "team_username")
    @ManyToOne(optional = false)
    private TeamLoginTable teamUsername;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ProjectDetailsTable projectDetailsTable;

    public ProjectTeamMappingTable() {
    }

    public ProjectTeamMappingTable(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public TeamLoginTable getTeamUsername() {
        return teamUsername;
    }

    public void setTeamUsername(TeamLoginTable teamUsername) {
        this.teamUsername = teamUsername;
    }

    public ProjectDetailsTable getProjectDetailsTable() {
        return projectDetailsTable;
    }

    public void setProjectDetailsTable(ProjectDetailsTable projectDetailsTable) {
        this.projectDetailsTable = projectDetailsTable;
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
        if (!(object instanceof ProjectTeamMappingTable)) {
            return false;
        }
        ProjectTeamMappingTable other = (ProjectTeamMappingTable) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.ProjectTeamMappingTable[ projectId=" + projectId + " ]";
    }
    
}
