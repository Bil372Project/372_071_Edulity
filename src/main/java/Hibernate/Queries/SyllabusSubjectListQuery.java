package Hibernate.Queries;

import Hibernate.Entities.SyllabusExamDateEntity;
import Hibernate.Entities.SyllabusSubjectListEntity;
import Hibernate.Generator.HibarnateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SyllabusSubjectListQuery {
    public List makeQuery(String semester, String subject, String courseName) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SyllabusSubjectListEntity> criteria = criteriaBuilder.createQuery(SyllabusSubjectListEntity.class);
        Root<SyllabusSubjectListEntity> root = criteria.from(SyllabusSubjectListEntity.class);
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
        Query<SyllabusSubjectListEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
