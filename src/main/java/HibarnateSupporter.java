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

import static sun.misc.Version.print;


public class HibarnateSupporter {

        private SessionFactory sessionFactory;
        private Session session;

        public HibarnateSupporter(){
            sessionFactory = new Configuration().configure().buildSessionFactory();
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
}
