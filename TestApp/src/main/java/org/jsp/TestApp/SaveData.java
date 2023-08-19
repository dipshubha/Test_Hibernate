package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveData {

	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name, Phone,Age,Email and Password");
		String name=sc.next();
		long phone=sc.nextLong();
		int age=sc.nextInt();
		String email=sc.next();
		String password=sc.next();
		
		Person p=new Person();
		p.setName(name);
		p.setPhone(phone);
		p.setAge(age);
        p.setEmail(email);	
        p.setPassword(password);
        
        manager.persist(p);
        transaction.begin();
        transaction.commit();
        

	}

}
