/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.MemberDetailsTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chetan
 */
public class SearchMembersService {
    
    private TypedQuery<MemberDetailsTable> memberQuery;
    private EntityManager manager;
    private List<MemberDetailsTable> memberDetails;
    
    public SearchMembersService(){}
    
    public SearchMembersService(EntityManager manager){
        this.manager = manager;
        
    }
    public List<MemberDetailsTable> fetchFirstName(){
        memberQuery = manager.createQuery("SELECT m FROM MemberDetailsTable m ", MemberDetailsTable.class);
        //firstNameQuery.setParameter("uname",user);
        memberDetails = memberQuery.getResultList();
        return memberDetails;
    }
   // public List<String> findLastName(){
     //   lastNameQuery = manager.createQuery("SELECT m.lastName FROM MemberDetailsTable m ");
       // lastNames = lastNameQuery.getResultList();
        //return lastNames;
    //}
    public List<MemberDetailsTable> fetchMemberInformation(String memberEmail){
        memberQuery = manager.createQuery("SELECT m.memberRole, m.phoneNumber FROM MemberDetailsTable m WHERE m.emailId=:memberEmail", MemberDetailsTable.class);
        memberQuery.setParameter("memberEmail",memberEmail);
        memberDetails = memberQuery.getResultList();
        return memberDetails;
    }
}
