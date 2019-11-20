package Queries;

import entities.TeacherEntity;
import entities.TeachingStaffEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeachingStaffQuery {
    public List makeQuery(String schoolName, String employeeId, String specialization, String officeNo) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TeachingStaffEntity> criteria = criteriaBuilder.createQuery(TeachingStaffEntity.class);
        Root<TeachingStaffEntity> root = criteria.from(TeachingStaffEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(employeeId != null){
            predicates.add(criteriaBuilder.equal(root.get("employeeId"),employeeId));
        }
        if(specialization!= null){
            predicates.add(criteriaBuilder.like(root.get("specialization"),specialization));
        }
        if(officeNo!= null){
            predicates.add(criteriaBuilder.equal(root.get("officeNo"),officeNo));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<TeachingStaffEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
