import com.fasterxml.classmate.AnnotationConfiguration;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;


public class OracleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Course usr2 = new Course("bil",86,true,"s24636");
        School usr = new School("TECHNOLOGY","BB","CANKAYA");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(usr);
        session.getTransaction().commit();

        Session sessionTwo =   sessionFactory.openSession();
        sessionTwo.beginTransaction();

        School school = (School) sessionTwo.get(School.class,"TOBB");
        System.out.println(school.getName() + " - " +school.getType());
        sessionTwo.delete(school);

    }

}