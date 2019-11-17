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

public class CourseQuery {
    public List makeQuery(String courseName, Long grade, String type, String teacherEmployeeId, String schoolName) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SchoolEntity> criteria = criteriaBuilder.createQuery(SchoolEntity.class);
        Root<SchoolEntity> root = criteria.from(SchoolEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(courseName != null){
            predicates.add(criteriaBuilder.like(root.get("courseName"),courseName));
        }
        if(grade != null){
            predicates.add(criteriaBuilder.equal(root.get("grade"),grade));
        }
        if(type!= null){
            predicates.add(criteriaBuilder.like(root.get("type"),type));
        }
        if(teacherEmployeeId!= null){
            predicates.add(criteriaBuilder.equal(root.get("teacherEmployeeId"),teacherEmployeeId));
        }
        if(schoolName != null){
            predicates.add(criteriaBuilder.equal(root.get("schoolName"),schoolName));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
