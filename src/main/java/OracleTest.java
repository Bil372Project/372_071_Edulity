import Hibernate.Entities.LunchMenuEntity;
import Hibernate.Generator.DatabaseGeneretor;
import Hibernate.Queries.SchoolQuery;

import org.hibernate.Hibernate;

import java.sql.Time;
import java.util.List;


public class OracleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*Queries.HibarnateSupporter class has present us to use some basic functions or would be advanced function depending on requirement
        but now it does not have.
            --- create command
            --- delete object
            --- get pointed object literally same
            --- query form to retrieve information from database

         */
        //Created hibarnate supported
        Hibernate.Generator.DatabaseGeneretor databaseGeneretor = new Hibernate.Generator.DatabaseGeneretor();
        databaseGeneretor.generator();
//        HibarnateSupporter supporter = new HibarnateSupporter();
//        Session session = HibarnateSupporter.getSessionFactory().openSession();
//session.close();
        //LunchMenuEntity lunchMenuEntity = new LunchMenuEntity();
        //lunchMenuEntity.setFood("nuddle");
        //lunchMenuEntity.setLunchDay(new Time(23425));

        //List q = sq.makeQuery("TOBB",null,null);
        //CourseQuery cq = new CourseQuery();
        //cq.makeQuery(null,null,null,null);
        //Hibernate.Generator.DatabaseGeneretor databaseGeneretor = new Hibernate.Generator.DatabaseGeneretor(git );
       // databaseGeneretor.generator();

        LunchMenuEntity lunchMenuEntity = new LunchMenuEntity();
        lunchMenuEntity.setFood("nuddle");
        lunchMenuEntity.setLunchDay(new Time(23425));

        SchoolQuery sq = new SchoolQuery();
        List q = sq.makeQuery("TOBB",null,null);

        //supporter.createObject(lunchMenuEntity);
        //This code block only for trial and query example
        String hql = "FROM EmployeeEntity WHERE SCHOOL_NAME = 'TOBB' ";
        //List courses =  supporter.selectQueryBased(hql);
        //for(Object object:courses){
          //  System.out.println(((EmployeeEntity)object).getEmployeeId());
        //}
    }
}