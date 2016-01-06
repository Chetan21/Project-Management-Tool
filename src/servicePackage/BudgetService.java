/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import javax.persistence.*;
import java.util.*;
import entityClassesPackage.Budget;
import entityClassesPackage.BudgetTable;
import entityClassesPackage.ProjectDetailsTable;

/**
 *
 * @author erwin
 */
public class BudgetService {
    private EntityManager manager;
    
    public BudgetService(EntityManager manager)
    {
        this.manager = manager;
    }
    
    public BudgetTable createBudget(ProjectDetailsTable project_id, String budget_name, String budget_desc, double actual_budget, double estimated_budget, int budget_id)
    {
        BudgetTable b = new BudgetTable();
        b.setProjectId(project_id);
        b.setBudgetName(budget_name);
        b.setBudgetDesc(budget_desc);
        b.setActualBudget(actual_budget);
        b.setEstimatedBudget(estimated_budget);
        b.setBudgetId(budget_id);
        manager.persist(b);
        return(b);
    }
    
    public void deleteBudget(int item)
    {
        
        Budget b = manager.find(Budget.class, item);
        if (b != null)
        {
            manager.remove(b);
        }
    }
    
    // method to update a record
    public Budget updateBudget(String budget_name, String budget_desc, double actual_budget, double estimated_budget, int budget_id) 
    {
        System.out.println("the budget_id in update budget is: " + budget_id);
    	 Budget budget = manager.find(Budget.class, budget_id);
    	 if (budget != null) 
         {
    		 budget.setBudgetname(budget_name);
    		 budget.setBudgetDesc(budget_desc);
    		 budget.setActualBudget(actual_budget);
    		 budget.setEstimatedBudget(estimated_budget);
    	 }
    	 return budget;
     }
    
    public List<BudgetTable> fetchBudget()
    {
        TypedQuery<BudgetTable> query = manager.createQuery("Select e from communication_table e", BudgetTable.class);
        List<BudgetTable> result = query.getResultList();
        return result;
    }
    
    
}
