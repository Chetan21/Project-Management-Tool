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
@Table(name = "team_members_mapping_table")
@NamedQueries({
    @NamedQuery(name = "TeamMembersMappingTable.findAll", query = "SELECT t FROM TeamMembersMappingTable t"),
    @NamedQuery(name = "TeamMembersMappingTable.findByEmailId", query = "SELECT t FROM TeamMembersMappingTable t WHERE t.emailId = :emailId"),
    @NamedQuery(name = "TeamMembersMappingTable.findByMemberRole", query = "SELECT t FROM TeamMembersMappingTable t WHERE t.memberRole = :memberRole")})
public class TeamMembersMappingTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "member_role")
    private String memberRole;
    @JoinColumn(name = "team_username", referencedColumnName = "team_username")
    @ManyToOne(optional = false)
    private TeamLoginTable teamUsername;
    @JoinColumn(name = "email_id", referencedColumnName = "email_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MemberDetailsTable memberDetailsTable;

    public TeamMembersMappingTable() {
    }

    public TeamMembersMappingTable(String emailId) {
        this.emailId = emailId;
    }

    public TeamMembersMappingTable(String emailId, String memberRole) {
        this.emailId = emailId;
        this.memberRole = memberRole;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public TeamLoginTable getTeamUsername() {
        return teamUsername;
    }

    public void setTeamUsername(TeamLoginTable teamUsername) {
        this.teamUsername = teamUsername;
    }

    public MemberDetailsTable getMemberDetailsTable() {
        return memberDetailsTable;
    }

    public void setMemberDetailsTable(MemberDetailsTable memberDetailsTable) {
        this.memberDetailsTable = memberDetailsTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMembersMappingTable)) {
            return false;
        }
        TeamMembersMappingTable other = (TeamMembersMappingTable) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.TeamMembersMappingTable[ emailId=" + emailId + " ]";
    }
    
}
