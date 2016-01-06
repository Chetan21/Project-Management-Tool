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

@Entity(name="budget_table")
public class Budget implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column
    private int budget_id;
    
    @Column
    private int project_id;
    
    @Column
    private String budget_name;
    
    @Column 
    private String budget_desc;
    
    @Column
    private double actual_budget;
    
    @Column
    private double estimated_budget;
    
    //public int getBudgetID()
    //{
	//return budget_id;
    //}
    
    //public void setBudgetID(int i)
    //{
    //    budget_id = i;
    //}
    
    //public int getProjectID()
    //{
    //    return project_id;
    //}
    
    //public void setProjectID(int i)
    //{
    //    project_id = i;
    //}
	
    public String getBudgetName()
    {
	return budget_name;
    }
    
    public void setBudgetname(String s)
    {
        budget_name = s;
    }
    
    public String getBudgetDesc()
    {
        return budget_desc;
    }
    
    public void setBudgetDesc(String s)
    {
        budget_desc = s;
    }
    
    public double getActualBudget()
    {
        return actual_budget;
    }
    
    public void setActualBudget(double d)
    {
        actual_budget = d;
    }
    
    public double getEstimatedBudget()
    {
        return estimated_budget;
    }
    
    public void setEstimatedBudget(double d)
    {
        estimated_budget = d;
    }
    
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
            return getBudgetName();
	else if (i==2)
            return getBudgetDesc();
	else if (i==3)
            return getActualBudget();
	else if (i==4)
            return getEstimatedBudget();
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
            budget_name = (String) value;
        else if (i==2)
            budget_desc = (String) value;
        else if (i==3)
            actual_budget = Double.parseDouble((String)value);
        else if (i==4)
            estimated_budget = Double.parseDouble((String)value);
        //else if (i==5)
        //    budget_id = Integer.parseInt((String)value);
        else
            throw new Exception("Error: invalid column index in budget table");
    }
}
