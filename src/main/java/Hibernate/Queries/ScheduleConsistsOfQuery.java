package Hibernate.Queries;

import Hibernate.Generator.HibarnateSupporter;
import Hibernate.Entities.ScheduleConsistsOfEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScheduleConsistsOfQuery {
    public List makeQuery(String scheduleId, String courseName, Time startDate, Time endDate, Long grade) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ScheduleConsistsOfEntity> criteria = criteriaBuilder.createQuery(ScheduleConsistsOfEntity.class);
        Root<ScheduleConsistsOfEntity> root = criteria.from(ScheduleConsistsOfEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(scheduleId != null){
            predicates.add(criteriaBuilder.like(root.get("scheduleId"),scheduleId));
        }
        if(courseName != null){
            predicates.add(criteriaBuilder.like(root.get("courseName"),courseName));
        }
        if(startDate != null){
            predicates.add(criteriaBuilder.equal(root.get("startDate"),startDate));
        }
        if(endDate != null){
            predicates.add(criteriaBuilder.equal(root.get("endDate"),endDate));
        }
        if(grade != null){
            predicates.add(criteriaBuilder.equal(root.get("grade"),grade));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ScheduleConsistsOfEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
