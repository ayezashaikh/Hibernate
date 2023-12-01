package com.azeem.dao.impl;

import com.azeem.dao.StudentDao;
import com.azeem.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    SessionFactory factory;

    Session session;

    public StudentDaoImpl() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        factory = metadata.getSessionFactoryBuilder().build();

    }

    @Override
    public void saveStudent(Student student) {
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }


    }


    public Student loadStudent(int id) {
        Session session = factory.openSession();
     //   Student st = session.get(Student.class, id);
        System.out.println("id" + id);
        Student st = session.load(Student.class, id);
        return st;
    }


}
