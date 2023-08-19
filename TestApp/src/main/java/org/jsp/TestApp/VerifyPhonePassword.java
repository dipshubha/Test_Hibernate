package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyPhonePassword {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Phone no");
		long phone=sc.nextLong();
		System.out.println("Enter your Password");
        String password=sc.next();
        String qry="select p from Person p where p.phone=?1 and p.password=?2 ";

        Query q=manager.createQuery(qry);
        q.setParameter(1, phone);
        q.setParameter(2, password);
        try {
        	Person p1=(Person)q.getSingleResult();
        	System.out.println("Name="+p1.getName());
			System.out.println("Phone="+p1.getPhone());
			System.out.println("Email="+p1.getPassword());
			
		} catch (NoResultException e)
        {
			System.err.println("Enter Phonr no= "+phone+" and "+password+" are not present in database");
	
		}
	}

}
