/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicePackage;

import entityClassesPackage.TeamLoginTable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Chetan
 */
public class LoginService {
    private TeamLoginTable usernameValid;
    private EntityManager manager;
    public LoginService(EntityManager manager){
        
        this.manager = manager;
    }
    public String findLogin(String username, String password){
        
        String user, pass, role = null;
        Query passwordQuery, roleQuery;
        TeamLoginTable usernameValid = manager.find(TeamLoginTable.class, username);
        if(usernameValid!=null){
            user = usernameValid.getTeamUsername();
            passwordQuery = manager.createQuery("SELECT u.teamPassword FROM TeamLoginTable u WHERE u.teamUsername = :uname");
            passwordQuery.setParameter("uname",user);
            roleQuery = manager.createQuery("SELECT u.role FROM TeamLoginTable u WHERE u.teamUsername = :uname");
            roleQuery.setParameter("uname",user);
            pass = passwordQuery.getSingleResult().toString();
            System.out.println("pass");
            if(pass.equalsIgnoreCase(password)){
                role = roleQuery.getSingleResult().toString();
                System.out.println("role");
            }
        }
        
        return role;
    }
}
