/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.CommunicationTable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;
import entityClassesPackage.ProjectDetailsTable;
import servicePackage.CommunicationsService;

/**
 *
 * @author erwin
 */
public class CommunicationsTableModel{
    
    private List<CommunicationTable> communicationsResultList;
    private static final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    private  EntityManagerFactory factory;
    private  EntityManager manager;
    private CommunicationsService communicationService;
    
    int numRows, numCols, selectedRow;
    
    public CommunicationsTableModel()
    {
	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	manager = factory.createEntityManager();
	
	communicationService = new CommunicationsService(manager);	
    }
    
    public void addCommunicationRow(Object[] array)
    {
	EntityTransaction userTransaction = manager.getTransaction();
	userTransaction.begin();
	CommunicationTable newRecord = communicationService.createCommunication(0, (String) array[1], (String) array[2], (String) array[3], (String) array[4], (ProjectDetailsTable) array[5]);
        userTransaction.commit();
	communicationsResultList.add(newRecord);
    }
    
    public List<CommunicationTable> retrieveCommunications(){
        communicationsResultList = communicationService.fetchCommunications();
        return communicationsResultList;
    }
    
}
