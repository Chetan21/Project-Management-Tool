/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClassesPackage;

import javax.persistence.*;
import java.io.*;


/**
 *
 * @author erwin
 */

@Entity(name="communication_table")
public class Communications implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column
    private int message_id;
    
    @Column
    private String time_stamp;
    
    @Column
    private String message;
    
    @Column
    private String team_username;
    
    @Column
    private String contact_name;
    
    @Column
    private int project_id;
    
    
    //public int getMessageID()
    //{
	//return message_id;
    //}
    
    //public void setMessageID(int i)
    //{
    //    message_id = i;
    //}
    
    public String getTimeStamp()
    {
	return time_stamp;
    }
    
    public void setTimeStamp(String s)
    {
        time_stamp = s;
    }
    
    public String getMessage()
    {
	return message;
    }
    
    public void setMessage(String s)
    {
        message = s;
    }
    
    public String getTeamUserName()
    {
	return team_username;
    }
    
    public void setTeamUserName(String s)
    {
        team_username = s;
    }
    
    public String getContactName()
    {
	return contact_name;
    }
    
    public void setContactName(String s)
    {
        contact_name = s;
    }
    
    //public int getProjectID()
    //{
    //    return project_id;
    //}
    
    //public void setProjectID(int i)
    //{
    //    project_id = i;
    //}
    
    
    public int getNumberOfColumns()
    {
        return 6;
    }
    
    public Object getColumnData(int i) throws Exception
    {
	//if (i==0)
        //    return getProjectID();
	//else if (i==1)
        if (i==1)
            return getTimeStamp();
	else if (i==2)
            return getMessage();
	else if (i==3)
            return getTeamUserName();
	else if (i==4)
            return getContactName();
        //else if (i==5)
        //   return getBudgetID();
	else
            throw new Exception ("Error: invalid column index in budget table");
		
    }
    
    public void setColumnData(int i, Object value) throws Exception 
    {
        //if (i==0)
        //    project_id = Integer.parseInt((String) value);
        //else if (i==1)
        if (i==1)
            time_stamp = (String) value;
        else if (i==2)
            message = (String) value;
        else if (i==3)
            team_username = (String) value;
        else if (i==4)
            contact_name = (String) value;
        //else if (i==5)
        //    budget_id = Integer.parseInt((String)value);
        else
            throw new Exception("Error: invalid column index in budget table");
    }
}
