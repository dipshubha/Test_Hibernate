package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FetchByName {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person Name");
		String name=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		
		String qry = "select p from Person p where p.name=?1";
		Query q = manager.createQuery(qry);
        q.setParameter(1, name);
        try
		{
			Person p=(Person)q.getSingleResult();
			System.out.println("Id="+p.getId());
			System.out.println("Name="+p.getName());
			System.out.println("Phone="+p.getPhone());
			System.out.println("Email="+p.getEmail());
		}
		catch(NoResultException e)
		{
			System.err.println("Enter name= "+name+"not present in database");
		}
        
	}

}
