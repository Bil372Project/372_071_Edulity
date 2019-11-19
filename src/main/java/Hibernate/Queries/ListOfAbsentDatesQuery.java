package Hibernate.Queries;

import Hibernate.Generator.HibarnateSupporter;
import Hibernate.Entities.ListOfAbsentDatesEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ListOfAbsentDatesQuery {
    public List makeQuery(String schoolName, String studentId, Time absentDate) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ListOfAbsentDatesEntity> criteria = criteriaBuilder.createQuery(ListOfAbsentDatesEntity.class);
        Root<ListOfAbsentDatesEntity> root = criteria.from(ListOfAbsentDatesEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(studentId != null){
            predicates.add(criteriaBuilder.like(root.get("studentId"),studentId));
        }
        if(absentDate!= null){
            predicates.add(criteriaBuilder.equal(root.get("absentDate"),absentDate));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ListOfAbsentDatesEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
