package Hibernate.Queries;

import Hibernate.Generator.HibernateSupporter;
import Hibernate.Entities.LunchEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class LunchQuery {
    public List makeQuery(Time day, String studentId, String schoolName) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<LunchEntity> criteria = criteriaBuilder.createQuery(LunchEntity.class);
        Root<LunchEntity> root = criteria.from(LunchEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(day != null){
            predicates.add(criteriaBuilder.equal(root.get("day"),day));
        }
        if(studentId != null){
            predicates.add(criteriaBuilder.like(root.get("studentId"),studentId));
        }
        if(schoolName!= null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<LunchEntity> query = session.createQuery(criteria);


        return query.list();
    }
}
