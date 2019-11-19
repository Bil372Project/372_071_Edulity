package Queries;

import Queries.Supporter.HibarnateSupporter;
import entities.HaveScheduleEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HaveScheduleQuery {
    public List makeQuery(Long classSection, String schoolName, String scheduleId) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<HaveScheduleEntity> criteria = criteriaBuilder.createQuery(HaveScheduleEntity.class);
        Root<HaveScheduleEntity> root = criteria.from(HaveScheduleEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(classSection != null){
            predicates.add(criteriaBuilder.equal(root.get("classSection"),classSection));
        }
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(scheduleId!= null){
            predicates.add(criteriaBuilder.like(root.get("scheduleId"),scheduleId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<HaveScheduleEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
