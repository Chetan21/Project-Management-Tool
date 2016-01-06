/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chetan
 */
@Entity
@Table(name = "team_login_table")
@NamedQueries({
    @NamedQuery(name = "TeamLoginTable.findAll", query = "SELECT t FROM TeamLoginTable t"),
    @NamedQuery(name = "TeamLoginTable.findByTeamUsername", query = "SELECT t FROM TeamLoginTable t WHERE t.teamUsername = :teamUsername"),
    @NamedQuery(name = "TeamLoginTable.findByTeamPassword", query = "SELECT t FROM TeamLoginTable t WHERE t.teamPassword = :teamPassword"),
    @NamedQuery(name = "TeamLoginTable.findByTeamName", query = "SELECT t FROM TeamLoginTable t WHERE t.teamName = :teamName"),
    @NamedQuery(name = "TeamLoginTable.findByRole", query = "SELECT t FROM TeamLoginTable t WHERE t.role = :role")})
public class TeamLoginTable implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamUsername")
    private List<ProjectTeamMappingTable> projectTeamMappingTableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamUsername")
    private List<TeamMembersMappingTable> teamMembersMappingTableList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "team_username")
    private String teamUsername;
    @Basic(optional = false)
    @Column(name = "team_password")
    private String teamPassword;
    @Basic(optional = false)
    @Column(name = "team_name")
    private String teamName;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;

    public TeamLoginTable() {
    }

    public TeamLoginTable(String teamUsername) {
        this.teamUsername = teamUsername;
    }

    public TeamLoginTable(String teamUsername, String teamPassword, String teamName, String role) {
        this.teamUsername = teamUsername;
        this.teamPassword = teamPassword;
        this.teamName = teamName;
        this.role = role;
    }

    public String getTeamUsername() {
        return teamUsername;
    }

    public void setTeamUsername(String teamUsername) {
        this.teamUsername = teamUsername;
    }

    public String getTeamPassword() {
        return teamPassword;
    }

    public void setTeamPassword(String teamPassword) {
        this.teamPassword = teamPassword;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamUsername != null ? teamUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamLoginTable)) {
            return false;
        }
        TeamLoginTable other = (TeamLoginTable) object;
        if ((this.teamUsername == null && other.teamUsername != null) || (this.teamUsername != null && !this.teamUsername.equals(other.teamUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.TeamLoginTable[ teamUsername=" + teamUsername + " ]";
    }

    public List<TeamMembersMappingTable> getTeamMembersMappingTableList() {
        return teamMembersMappingTableList;
    }

    public void setTeamMembersMappingTableList(List<TeamMembersMappingTable> teamMembersMappingTableList) {
        this.teamMembersMappingTableList = teamMembersMappingTableList;
    }

    public List<ProjectTeamMappingTable> getProjectTeamMappingTableList() {
        return projectTeamMappingTableList;
    }

    public void setProjectTeamMappingTableList(List<ProjectTeamMappingTable> projectTeamMappingTableList) {
        this.projectTeamMappingTableList = projectTeamMappingTableList;
    }
    
}
