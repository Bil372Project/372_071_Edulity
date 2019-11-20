package Hibernate.Queries;

import Hibernate.Generator.HibarnateSupporter;
import Hibernate.Entities.DriverEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DriverQuery {
    public List makeQuery(String id, String ssn, String phoneNumber) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<DriverEntity> criteria = criteriaBuilder.createQuery(DriverEntity.class);
        Root<DriverEntity> root = criteria.from(DriverEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(id != null){
            predicates.add(criteriaBuilder.like(root.get("id"),id));
        }
        if(ssn != null){
            predicates.add(criteriaBuilder.like(root.get("ssn"),ssn));
        }
        if(phoneNumber!= null){
            predicates.add(criteriaBuilder.like(root.get("phoneNumber"),phoneNumber));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<DriverEntity> query = session.createQuery(criteria);


        return query.list();
    }
}
