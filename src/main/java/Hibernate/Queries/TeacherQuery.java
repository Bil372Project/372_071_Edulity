package Hibernate.Queries;
import Hibernate.Entities.*;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeacherQuery {
    Session session = HibernateSupporter.getSessionFactory().openSession();
    public List makeQuery(String schoolName, String employeeId, String surveyId, String hodEmployeeId) {

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TeacherEntity> criteria = criteriaBuilder.createQuery(TeacherEntity.class);
        Root<TeacherEntity> root = criteria.from(TeacherEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(employeeId != null){
            predicates.add(criteriaBuilder.like(root.get("employeeId"),employeeId));
        }
        if(surveyId!= null){
            predicates.add(criteriaBuilder.like(root.get("surveyId"),surveyId));
        }
        if(hodEmployeeId!= null){
            predicates.add(criteriaBuilder.like(root.get("hodEmployeeId"),hodEmployeeId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<TeacherEntity> query = session.createQuery(criteria);

        return query.list();
    }
    public List retrieveSchedule(){
            CourseQuery courseQuery = new CourseQuery();git
            ClazzQuery clazzQuery = new ClazzQuery();
            ScheduleConsistsOfQuery scheduleConsistsOfQuery = new ScheduleConsistsOfQuery();
            ArrayList<CourseEntity> courseEntities = (ArrayList)courseQuery.makeQuery(null,null,null,"s1",null);

            List<String> scheduleList = new ArrayList<String>();
            for(int i=0;i<courseEntities.size();i++) {
                  ArrayList<ScheduleConsistsOfEntity> scheduleConsistsOfEntities = (ArrayList) scheduleConsistsOfQuery.makeQuery(null, courseEntities.get(i).getCourseName(), null, null, null);
                  for(int j=0;j<scheduleConsistsOfEntities.size();j++) {
                      ArrayList<ClazzEntity> clazzEntities = (ArrayList)clazzQuery.makeQuery(null,null,scheduleConsistsOfEntities.get(j).getScheduleId(),null);
                      scheduleList.add(courseEntities.get(i).getCourseName()+"*"+clazzEntities.get(0).getSection()+"*"+scheduleConsistsOfEntities.get(j).getStartDate()+"*"+scheduleConsistsOfEntities.get(j).getEndDate());
                  }
            }
            return scheduleList;
    }
}
