import com.fasterxml.classmate.AnnotationConfiguration;
import entities.CourseEntity;
import entities.TeacherEntity;
import entities.TeacherEntityPK;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.Entity;


public class OracleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName("Matematik");
        courseEntity.setGrade(8);
        courseEntity.setType("Mandatory");
        TeacherEntity teacherEntity = new TeacherEntity();


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(courseEntity);
        session.getTransaction().commit();
        session.close();

//        Session sessionTwo =   sessionFactory.openSession();
//        sessionTwo.beginTransaction();
//
//        School school = (School) sessionTwo.get(School.class,"TOBB");
//        System.out.println(school.getName() + " - " +school.getType());
//        sessionTwo.delete(school);

    }

}