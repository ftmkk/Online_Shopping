package Model;

import Model.UserModel.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

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
}