/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.MemberDetailsTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.SearchMembersService;

/**
 *
 * @author Chetan
 */
public class SearchMembersModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private MemberDetailsTable memberTable;
    private SearchMembersService searchMembersService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    private List<MemberDetailsTable> firstNames, memberInfo;
    
    public SearchMembersModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        memberTable = new MemberDetailsTable();
        searchMembersService = new SearchMembersService(manager);
    }
    public List<MemberDetailsTable> retrieveNames(){
        
        firstNames = searchMembersService.fetchFirstName();
        //lastNames = searchMembersService.findLastName();
        //String[] strArray = firstNames.toArray(new String[firstNames.size()]);
        //System.out.println(strArray[0]);
        return firstNames;
        
    }
    
    public List<MemberDetailsTable> retrieveMemberInformation(String memberEmail){
        
        memberInfo = searchMembersService.fetchMemberInformation(memberEmail);
        
        return memberInfo;
        
    }
}
