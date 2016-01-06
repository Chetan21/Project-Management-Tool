/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.TeamLoginTable;
import entityClassesPackage.TeamMembersMappingTable;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chetan
 */
public class MemberToTeamAdditionService {
    private EntityManager manager;
    private TeamMembersMappingTable teamToMemberMap;
    private Query memberRoleQuery;
    private TeamMembersMappingTable memberEmailValid;
    private TypedQuery<TeamMembersMappingTable> findMemberInTeamQuery;
    
    public MemberToTeamAdditionService(EntityManager manager){
        this.manager = manager;
        teamToMemberMap = new TeamMembersMappingTable();
        memberEmailValid = new TeamMembersMappingTable();
                
    }
    public String fetchMemberRole(String memberEmail){
        memberRoleQuery = manager.createQuery("SELECT m.memberRole FROM MemberDetailsTable m WHERE m.emailId =:memberEmail");
        memberRoleQuery.setParameter("memberEmail", memberEmail);
        String memberRole = memberRoleQuery.getSingleResult().toString();
        return memberRole;
    }
    
    public TeamMembersMappingTable addMemberToTeam(TeamLoginTable teamUsername, String memberEmail, String role){
        teamToMemberMap.setTeamUsername(teamUsername);
        teamToMemberMap.setEmailId(memberEmail);
        teamToMemberMap.setMemberRole(role);
        manager.persist(teamToMemberMap);
        return teamToMemberMap;
    }
    
    public boolean checkMultipleMembers(String memberEmail){
        boolean valid= true;
        memberEmailValid = manager.find(TeamMembersMappingTable.class, memberEmail);
        if(memberEmailValid == null)
            valid = false;
        return valid;
    }
}
