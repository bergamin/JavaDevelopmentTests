package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Account;
import util.JPAUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class Tests {
    public static void main(String[] args){
        
//        Account account = new Account();
//        account.setHolder("Holder's Name");
//        account.setBank("Bank's name");
//        account.setNumber("1234567890");
//        account.setOffice("1234");
        
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist(account);
        
        //Populate an object by its ID
        Account account2 = entityManager.find(Account.class, 1);
        
        account2.setHolder("New Holder's Name");
        
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
