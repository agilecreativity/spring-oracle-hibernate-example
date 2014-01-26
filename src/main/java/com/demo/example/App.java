package com.demo.example;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

public class App {

  public void queryFor(Session session) {
    final Query q = session.createQuery("from User where userName = :userName");
    q.setParameter("userName", "superman");
    final User user = (User) q.list().get(0);
    System.out.println("Your user id:" + user.getUserId());
  }

  public void create(Session session) {

    final User user = new User();
    user.setUserId(100L); // No SEQ use for this table so need to set one
                          // up.

    user.setUserName("superman");
    user.setCreatedBy("system");
    user.setCreatedDate(new Date());

    session.save(user);
  }

  public static void main(String[] args) {

    final App app = new App();

    System.out.println("Maven + Hibernate + Oracle");
    final Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    app.create(session);
    session.getTransaction().commit();

    app.queryFor(session);

    final Department department = new Department();
    department.setDepartmentName("Sales");
    session.save(department);
    System.out.println("deparementId:" + department.getDepartmentId());

    session.getTransaction().commit();

    session.beginTransaction();

    final Employee emp1 = new Employee("Nina", "Mayers", "1212");
    final Employee emp2 = new Employee("Tony", "Almeida", "4343");

    emp1.setDepartment(department);
    emp2.setDepartment(department);

    session.save(emp1);
    session.save(emp2);
    session.getTransaction().commit();

  }

}
