package Queries.Supporter;

import entities.CourseEntity;
import entities.CourseEntityPK;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class HibarnateSupporter {

        private static SessionFactory sessionFactory;
        private Session session;

        static {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        public HibarnateSupporter(){
            session = sessionFactory.openSession();
        }
        public Object getObject(Class realClass,Object referenced_object){
            System.out.println(referenced_object);
            Object object = (Object)session.get(realClass ,(Serializable) referenced_object);
            return object;
        }
        public void createObject(Object created_object){
            session.beginTransaction();
            session.save(created_object);
            session.getTransaction().commit();
        }
        public void delete(Object deleted_object){
            session.beginTransaction();
            session.delete(deleted_object);
            session.getTransaction().commit();
        }

        public List<Object> selectQueryBased(String hql){

            Query query = session.createQuery(hql);
            List results = query.list();
            return results;
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
}
