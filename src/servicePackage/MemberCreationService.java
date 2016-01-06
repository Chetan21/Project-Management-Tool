/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.MemberDetailsTable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Chetan
 */
public class MemberCreationService {
    private EntityManager manager;
    private MemberDetailsTable memberEntry;
    private Query searchEmail;
    
    
    public MemberCreationService(EntityManager manager){
        this.manager = manager;
        memberEntry = new MemberDetailsTable();
    }
    
    public MemberDetailsTable createMember(String email, String memberFirstName, String memberLastName, String phoneNumber, String role){
        
        boolean checkDuplicateEmailID = findEmailID(email);
        if(checkDuplicateEmailID==false){
            memberEntry.setEmailId(email);
            memberEntry.setFirstName(memberFirstName);
            memberEntry.setLastName(memberLastName);
            memberEntry.setPhoneNumber(phoneNumber);
            memberEntry.setMemberRole(role);
            manager.persist(memberEntry);
            memberEntry = memberEntry;
        }
        else
            memberEntry = null;
        return memberEntry;
    }
    public boolean findEmailID(String email){
        boolean match;
        searchEmail = manager.createQuery("SELECT m.emailId FROM entityClassesPackage.MemberDetailsTable m WHERE m.emailId = :email");
        searchEmail.setParameter("email",email);
        try{
        String pass = searchEmail.getSingleResult().toString();
        match = true;
        }
        catch(NoResultException e){
            match = false;
        }
        
        return match;
    }
}
