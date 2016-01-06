/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelpackage;

import entityClassesPackage.TeamLoginTable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import servicePackage.LoginService;

/**
 *
 * @author Chetan
 */
public class LoginModel {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private LoginService loginCheck;
    
    final String PERSISTENCE_UNIT_NAME = "FrugalProjectPU2";
    
    public LoginModel(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        loginCheck = new LoginService(manager);
    }
    public String checkLogin(String[] a){
        
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        String role = loginCheck.findLogin(a[0], a[1]);
        userTransaction.commit();
        return role;
    }
}
