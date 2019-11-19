package Hibernate.Queries;

import Hibernate.Generator.HibarnateSupporter;
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
        CriteriaQuery<ScheduleQuery> criteria = criteriaBuilder.createQuery(ScheduleQuery.class);
        Root<ScheduleQuery> root = criteria.from(ScheduleQuery.class);
        List<Predicate> predicates = new ArrayList<>();
        if(scheduleId != null){
            predicates.add(criteriaBuilder.equal(root.get("scheduleId"),scheduleId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ScheduleQuery> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}

