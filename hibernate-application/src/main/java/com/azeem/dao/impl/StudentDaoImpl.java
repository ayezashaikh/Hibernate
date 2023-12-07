package com.azeem.dao.impl;

import com.azeem.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
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


    @Override
    public Student loadStudent(int id) {
        Session session = factory.openSession();
        //   Student st = session.get(Student.class, id);
        System.out.println("id" + id);
        Student st = session.load(Student.class, id);
        return st;
    }

    @Override
    public Student updateStudent(int side, int marks) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, side);
        Transaction transaction = session.beginTransaction();
        try {
            student.setMarks(780);
            session.update(student);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return student;
    }


    @Override
    public void deleteStudent(int sid) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, sid);
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }


    public void level1CahceTest() {
        Session session1 = factory.openSession();
        Session session2 = factory.openSession();

        Student student = session.get(Student.class, 11011);
        session.get(Student.class, 22022);


        session.clear();  //remove the all the object
        session.evict(student); //remove specific object


        session.get(Student.class, 11011);
        session2.get(Student.class, 11011);

        session1.close();
        session2.close();


    }


}
