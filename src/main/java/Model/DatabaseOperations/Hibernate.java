package Model.DatabaseOperations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Hibernate {

    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public static boolean addIfNotExist(Object obj,String key,String value){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Object oldObj = getByKey(obj.getClass(),key,value);
            if(oldObj==null){
                session.save(obj);
                session.flush();
                tx.commit();
                return true;
            } else {
                return false;
            }

        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public static void update(Object obj){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(obj);
            session.flush();
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public static Object getByKey(Class className,String key,String value){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(className);
            criteria.add(Restrictions.eq(key,value));
            List results = criteria.list();
            tx.commit();
            if(results.size()!=0){
                return results.get(0);
            } else {
                return null;
            }
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public static Object getById(Class className,Integer id){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Object result = session.get(className,id);
            tx.commit();
            return result;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }


    public static void add(Object obj){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(obj);
            session.flush();
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public static void delete(Object obj){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            session.flush();
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public static boolean removeIfExist(Object obj,String key,String value){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Object oldObj = getByKey(obj.getClass(),key,value);
            if(oldObj!=null){
                session.delete(obj);
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }



    @SuppressWarnings("Duplicates")
    public static List<Object> getAll(Class className){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(className);
            List<Object> results = criteria.list();
            tx.commit();
            return results;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }


    public static List<Object> getByFilter(Class className,String key, String value){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(className);
            criteria.add(Restrictions.eq(key,value));
            List<Object> results = criteria.list();
            tx.commit();
            return results;
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }
}