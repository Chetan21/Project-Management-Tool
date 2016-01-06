/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;
import entityClassesPackage.Budget;
import entityClassesPackage.BudgetTable;
import entityClassesPackage.ProjectDetailsTable;
import servicePackage.BudgetService;


/**
 *
 * @author erwin
 */
public class BudgetTableModel{
    List<BudgetTable> budgetResultList;
    private static final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private Budget budget;
    private BudgetService budgetService;
	
    int numRows, numCols, selectedRow;
    
    public BudgetTableModel()
    {
	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	budget = new Budget();
	budgetService = new BudgetService(manager);
	
    }
    
    public BudgetTableModel(int projID)
    {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	budget = new Budget();
	budgetService = new BudgetService(manager);
    
    }
	
    
    
    public List<BudgetTable> retrieveBudget(){
        budgetResultList = budgetService.fetchBudget();
        return budgetResultList;
    }
    
    
    public void addBudgetRow(Object[] array)
    {
	EntityTransaction userTransaction = manager.getTransaction();
	userTransaction.begin();
	
	BudgetTable newRecord = budgetService.createBudget((ProjectDetailsTable) array[0], (String) array[1], 
                (String) array[2], Double.parseDouble((String) array[3]), 
                Double.parseDouble((String) array[4]), 0);
        
        userTransaction.commit();

    }
    
    public void updateRow(Object[] array)
    {
	EntityTransaction userTransaction = manager.getTransaction();
	userTransaction.begin();
        budgetService.updateBudget((String) array[1], (String) array[2], Double.parseDouble((String) array[3]), Double.parseDouble((String) array[4]), Integer.parseInt((String) array[5]));
        userTransaction.commit();
        
    }
    
    public void deleteRow(int delItem)
    {
	EntityTransaction userTransaction = manager.getTransaction();
	userTransaction.begin();
	budgetService.deleteBudget(delItem);
	userTransaction.commit();
	
    }
}
