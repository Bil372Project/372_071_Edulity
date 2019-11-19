package Hibernate.Queries;

import Hibernate.Generator.HibarnateSupporter;
import Hibernate.Entities.StopEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StopQuery {
    public List makeQuery(String stopId, String stopName) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<StopEntity> criteria = criteriaBuilder.createQuery(StopEntity.class);
        Root<StopEntity> root = criteria.from(StopEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(stopId != null){
            predicates.add(criteriaBuilder.equal(root.get("stopId"),stopId));
        }
        if(stopName != null){
            predicates.add(criteriaBuilder.like(root.get("stopName"),stopName));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<StopEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
