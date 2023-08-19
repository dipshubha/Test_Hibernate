package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FetchById {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person Id");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		
		Person p=manager.find(Person.class,id);
		if(p!=null)
		{
			System.out.println("Person Name is="+p.getName());
			System.out.println("Person Email is="+p.getEmail());
			System.out.println("Person Age is="+p.getAge());

		}


	}

}
