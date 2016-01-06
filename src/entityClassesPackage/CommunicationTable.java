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

/**
 *
 * @author Chetan
 */
@Entity
@Table(name = "communication_table")
@NamedQueries({
    @NamedQuery(name = "CommunicationTable.findAll", query = "SELECT c FROM CommunicationTable c"),
    @NamedQuery(name = "CommunicationTable.findByMessageId", query = "SELECT c FROM CommunicationTable c WHERE c.messageId = :messageId"),
    @NamedQuery(name = "CommunicationTable.findByTimeStamp", query = "SELECT c FROM CommunicationTable c WHERE c.timeStamp = :timeStamp"),
    @NamedQuery(name = "CommunicationTable.findByMessage", query = "SELECT c FROM CommunicationTable c WHERE c.message = :message"),
    @NamedQuery(name = "CommunicationTable.findByTeamUsername", query = "SELECT c FROM CommunicationTable c WHERE c.teamUsername = :teamUsername"),
    @NamedQuery(name = "CommunicationTable.findByContactName", query = "SELECT c FROM CommunicationTable c WHERE c.contactName = :contactName")})
public class CommunicationTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_id")
    private Integer messageId;
    @Column(name = "time_stamp")
    private String timeStamp;
    @Column(name = "message")
    private String message;
    @Column(name = "team_username")
    private String teamUsername;
    @Column(name = "contact_name")
    private String contactName;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private ProjectDetailsTable projectId;

    public CommunicationTable() {
    }

    public CommunicationTable(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTeamUsername() {
        return teamUsername;
    }

    public void setTeamUsername(String teamUsername) {
        this.teamUsername = teamUsername;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommunicationTable)) {
            return false;
        }
        CommunicationTable other = (CommunicationTable) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClassesPackage.CommunicationTable[ messageId=" + messageId + " ]";
    }
    
}
