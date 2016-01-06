/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.CommunicationTable;
import javax.persistence.*;
import java.util.*;
import entityClassesPackage.Communications;
import entityClassesPackage.ProjectDetailsTable;

/**
 *
 * @author erwin
 */

public class CommunicationsService {
    
    private EntityManager manager;
    
    public CommunicationsService(EntityManager manager)
    {
        this.manager = manager;
    }
    
    public CommunicationTable createCommunication(int message_id, String timestamp, String message, String member_name, String contacts_name, ProjectDetailsTable project_id)
    {
        CommunicationTable c = new CommunicationTable();
        c.setMessageId(message_id);
        c.setTimeStamp(timestamp);
        c.setMessage(message);
        c.setTeamUsername(member_name);
        c.setContactName(contacts_name);
        c.setProjectId(project_id);
        manager.persist(c);
        return(c);
    }
    
    
    public List<CommunicationTable> fetchCommunications()
    {
        TypedQuery<CommunicationTable> query = manager.createQuery("Select e from communication_table e", CommunicationTable.class);
        List<CommunicationTable> result = query.getResultList();
        return result;
    }
    
    
}
