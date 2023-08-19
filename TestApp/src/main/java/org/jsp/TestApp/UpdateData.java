package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateData {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Id");
		int id = sc.nextInt();
		System.out.println("Enter name, phone, age,email and password");
		String name = sc.next();
		long phone = sc.nextLong();
		int age = sc.nextInt();
		String email = sc.next();
		String password = sc.next();

		Person p = new Person();
		p.setId(id);
		p.setName(name);
		p.setPassword(password);
		p.setPhone(phone);
		p.setEmail(email);
		p.setAge(age);

        manager.merge(p);
		transaction.begin();
		transaction.commit();

	}

}
