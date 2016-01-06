/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.MemberDetailsTable;
import entityClassesPackage.TeamLoginTable;
import entityClassesPackage.TeamMembersMappingTable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import servicePackage.MemberToTeamAdditionService;

/**
 *
 * @author Chetan
 */
public class AddingMemberToTeamModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private TeamLoginTable teamUsername;
    
    private TeamMembersMappingTable mappedData;
    private MemberToTeamAdditionService memberToTeamService;
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public AddingMemberToTeamModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        memberToTeamService = new MemberToTeamAdditionService(manager);
        teamUsername = new TeamLoginTable();
       
    }
    
    public boolean addMemberToTeam(String team, String memberEmailID){
        String memberRole;
        boolean valid = memberToTeamService.checkMultipleMembers(memberEmailID);
        if(valid == true){
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        teamUsername.setTeamUsername(team);
        memberRole = memberToTeamService.fetchMemberRole(memberEmailID);
        mappedData = memberToTeamService.addMemberToTeam(teamUsername, memberEmailID, memberRole);
        userTransaction.commit();
        }
        return valid;
        
    }
}
