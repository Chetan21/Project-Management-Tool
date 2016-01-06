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
import servicePackage.MemberCreationService;

/**
 *
 * @author Chetan
 */
public class MemberCreationModel {
    
    private EntityManagerFactory factory;
    private EntityManager manager;
    private MemberDetailsTable memberTable;
    private MemberCreationService memberService;
   
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public MemberCreationModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        memberService = new MemberCreationService(manager);
        memberTable = new MemberDetailsTable();
        
    }
    
    public boolean addMember(String[] memberInput){
        boolean success;
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        MemberDetailsTable newRecord = memberService.createMember(memberInput[0], memberInput[1], memberInput[2], memberInput[3], memberInput[4]);
        if(newRecord==null){
            success = false;
        }
        else{
            
            userTransaction.commit();
            success = true;
        }
        return success;
    }
    
}
