package Hibernate.Queries;

import Hibernate.Entities.SchoolBusStopsEntity;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SchoolBusStopsQuery {
    public List makeQuery(Long schoolBusId, String stopId) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SchoolBusStopsEntity> criteria = criteriaBuilder.createQuery(SchoolBusStopsEntity.class);
        Root<SchoolBusStopsEntity> root = criteria.from(SchoolBusStopsEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolBusId != null){
            predicates.add(criteriaBuilder.equal(root.get("schoolBusId"),schoolBusId));
        }
        if(stopId != null){
            predicates.add(criteriaBuilder.like(root.get("stopId"),stopId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolBusStopsEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
