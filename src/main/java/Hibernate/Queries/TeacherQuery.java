package Hibernate.Queries;
import Hibernate.Entities.TeacherEntity;
import Hibernate.Generator.HibarnateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeacherQuery {
    public List makeQuery(String schoolName, String employeeId, String surveyId, String hodEmployeeId) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TeacherEntity> criteria = criteriaBuilder.createQuery(TeacherEntity.class);
        Root<TeacherEntity> root = criteria.from(TeacherEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(employeeId != null){
            predicates.add(criteriaBuilder.like(root.get("employeeId"),employeeId));
        }
        if(surveyId!= null){
            predicates.add(criteriaBuilder.like(root.get("surveyId"),surveyId));
        }
        if(hodEmployeeId!= null){
            predicates.add(criteriaBuilder.like(root.get("hodEmployeeId"),hodEmployeeId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<TeacherEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
