package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyByEmailPassword {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email");
		String email=sc.next();
		System.out.println("Enter your Password");
        String password=sc.next();
        String qry="select p from Person p where p.email=?1 and p.password=?2 ";

        Query q=manager.createQuery(qry);
        q.setParameter(1, email);
        q.setParameter(2, password);
        try {
        	Person p=(Person)q.getSingleResult();
        	System.out.println("Name="+p.getName());
			System.out.println("Email="+p.getPassword());
			System.out.println("Password="+p.getPassword());

			
		} catch (NoResultException e)
        {
			System.err.println("Enter mail id "+email+" and "+password+" are not present in database");
	
		}
	}

}
