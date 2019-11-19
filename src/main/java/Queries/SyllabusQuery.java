package Queries;

import Queries.Supporter.HibarnateSupporter;
import entities.SyllabusEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SyllabusQuery {

    public List makeQuery(String semester, String courseName, Long gradingInfo, String hodEmployeeId,String schoolName) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SyllabusEntity> criteria = criteriaBuilder.createQuery(SyllabusEntity.class);
        Root<SyllabusEntity> root = criteria.from(SyllabusEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(semester != null){
            predicates.add(criteriaBuilder.like(root.get("semester"),semester));
        }
        if(courseName != null){
            predicates.add(criteriaBuilder.like(root.get("courseName"),courseName));
        }
        if(gradingInfo!= null){
            predicates.add(criteriaBuilder.equal(root.get("gradingInfo"),gradingInfo));
        }
        if(hodEmployeeId!= null){
            predicates.add(criteriaBuilder.like(root.get("hodEmployeeId"),hodEmployeeId));
        }
        if(schoolName!= null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SyllabusEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
