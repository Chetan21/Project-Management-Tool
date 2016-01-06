/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.MemberDetailsTable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.MemberDeletionService;
import servicePackage.SearchMembersService;

/**
 *
 * @author Chetan
 */
public class MemberDeletionModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private MemberDetailsTable memberTable;
    private MemberDeletionService memberDeleteService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public MemberDeletionModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        memberTable = new MemberDetailsTable();
        memberDeleteService = new MemberDeletionService(manager);
    }
    
    public void deleteMember(String memberEmail){
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        
        memberDeleteService.deleteMember(memberEmail);
        userTransaction.commit();        
        
        //fireTableRowsDeleted(getRowCount(), getColumnCount());
    }
}
