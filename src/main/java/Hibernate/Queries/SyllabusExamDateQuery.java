package Hibernate.Queries;

import Hibernate.Entities.SyllabusExamDateEntity;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class SyllabusExamDateQuery {
    public List makeQuery(String semester, Time subject, String courseName) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SyllabusExamDateEntity> criteria = criteriaBuilder.createQuery(SyllabusExamDateEntity.class);
        Root<SyllabusExamDateEntity> root = criteria.from(SyllabusExamDateEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(semester != null){
            predicates.add(criteriaBuilder.like(root.get("semester"),semester));
        }
        if(subject != null){
            predicates.add(criteriaBuilder.equal(root.get("subject"),subject));
        }
        if(courseName!= null){
            predicates.add(criteriaBuilder.like(root.get("courseName"),courseName));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SyllabusExamDateEntity> query = session.createQuery(criteria);


        return query.list();
    }
}
