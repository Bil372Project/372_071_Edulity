package Queries;

import entities.SchoolEntity;
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
        CriteriaQuery<SchoolEntity> criteria = criteriaBuilder.createQuery(SchoolEntity.class);
        Root<SchoolEntity> root = criteria.from(SchoolEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(employeeId != null){
            predicates.add(criteriaBuilder.equal(root.get("employeeId"),employeeId));
        }
        if(surveyId!= null){
            predicates.add(criteriaBuilder.like(root.get("surveyId"),surveyId));
        }
        if(hodEmployeeId!= null){
            predicates.add(criteriaBuilder.equal(root.get("hodEmployeeId"),hodEmployeeId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
