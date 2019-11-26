package Hibernate.Generator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;


public class HibernateSupporter {

        private static SessionFactory sessionFactory;
        private Session session;

        static {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        public HibernateSupporter(){
            session = sessionFactory.openSession();
        }
        public Object getObject(Class realClass,Object referenced_object){
            System.out.println(referenced_object);
            Object object = (Object)session.get(realClass ,(Serializable) referenced_object);
            return object;
        }
        public void createObject(Object created_object){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(created_object);
            session.getTransaction().commit();
            session.close();
        }
        public void delete(Object deleted_object){
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(deleted_object);
            session.getTransaction().commit();
            session.close();

        }

        public void update(Object updated_object) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(updated_object);
            session.getTransaction().commit();
            session.close();
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
