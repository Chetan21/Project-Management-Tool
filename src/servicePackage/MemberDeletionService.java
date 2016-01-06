/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.MemberDetailsTable;
import javax.persistence.EntityManager;

/**
 *
 * @author Chetan
 */
public class MemberDeletionService {
    private EntityManager manager;
    private MemberDetailsTable member;
    
    public MemberDeletionService(EntityManager manager){
        this.manager = manager;
        member = new MemberDetailsTable();
    }
    
    public void deleteMember(String memberEmail){
        member = manager.find(MemberDetailsTable.class, memberEmail);
        manager.remove(member);
    }
}
