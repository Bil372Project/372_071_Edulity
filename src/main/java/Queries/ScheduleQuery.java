package Queries;

import entities.HaveScheduleEntity;
import entities.ScheduleEntity;
import entities.SchoolEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ScheduleQuery {
    public List makeQuery(String scheduleId) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ScheduleEntity> criteria = criteriaBuilder.createQuery(ScheduleEntity.class);
        Root<ScheduleEntity> root = criteria.from(ScheduleEntity.class);
        List <Predicate>  predicates = new ArrayList<>();
        if(scheduleId != null){
            predicates.add(criteriaBuilder.like(root.get("scheduleId"),scheduleId));
        }

        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ScheduleEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
