/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Chetan
 */
@Entity
@Table(name = "member_details_table")
@NamedQueries({
    @NamedQuery(name = "MemberDetailsTable.findAll", query = "SELECT m FROM MemberDetailsTable m"),
    @NamedQuery(name = "MemberDetailsTable.findByEmailId", query = "SELECT m FROM MemberDetailsTable m WHERE m.emailId = :emailId"),
    @NamedQuery(name = "MemberDetailsTable.findByFirstName", query = "SELECT m FROM MemberDetailsTable m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "MemberDetailsTable.findByLastName", query = "SELECT m FROM MemberDetailsTable m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "MemberDetailsTable.findByPhoneNumber", query = "SELECT m FROM MemberDetailsTable m WHERE m.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "MemberDetailsTable.findByMemberRole", query = "SELECT m FROM MemberDetailsTable m WHERE m.memberRole = :memberRole")})
public class MemberDetailsTable implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "memberDetailsTable")
    private TeamMembersMappingTable teamMembersMappingTable;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "member_role")
    private String memberRole;

    public MemberDetailsTable() {
    }

    public MemberDetailsTable(String emailId) {
        this.emailId = emailId;
    }

    public MemberDetailsTable(String emailId, String firstName, String lastName, String phoneNumber, String memberRole) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.memberRole = memberRole;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
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
        if (!(object instanceof MemberDetailsTable)) {
            return false;
        }
        MemberDetailsTable other = (MemberDetailsTable) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.MemberDetailsTable[ emailId=" + emailId + " ]";
    }

    public TeamMembersMappingTable getTeamMembersMappingTable() {
        return teamMembersMappingTable;
    }

    public void setTeamMembersMappingTable(TeamMembersMappingTable teamMembersMappingTable) {
        this.teamMembersMappingTable = teamMembersMappingTable;
    }
    
}
