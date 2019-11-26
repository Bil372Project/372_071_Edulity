package Hibernate.Queries;

import Hibernate.Entities.TeachingStaffEntity;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeachingStaffQuery {
    Session session = HibernateSupporter.getSessionFactory().openSession();
    public List makeQuery(String schoolName, String employeeId, String specialization, String officeNo) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TeachingStaffEntity> criteria = criteriaBuilder.createQuery(TeachingStaffEntity.class);
        Root<TeachingStaffEntity> root = criteria.from(TeachingStaffEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(employeeId != null){
            predicates.add(criteriaBuilder.like(root.get("employeeId"),employeeId));
        }
        if(specialization!= null){
            predicates.add(criteriaBuilder.like(root.get("specialization"),specialization));
        }
        if(officeNo!= null){
            predicates.add(criteriaBuilder.like(root.get("officeNo"),officeNo));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<TeachingStaffEntity> query = session.createQuery(criteria);

        return query.list();
    }

    public List getWithNames(String schoolName){
        //return to
        org.hibernate.Query query = session.createQuery("select e.name,t.specialization,t.officeNo,t.employeeId from " +
                "TeachingStaffEntity t left join EmployeeEntity e on (e.employeeId=t.employeeId) where " +
                "e.schoolName=:schoolName");
        query.setParameter("schoolName", schoolName);
        List results = query.list();
        return results;
    }

    public List getAllInfo(String schoolName) {
        org.hibernate.Query query = session.createQuery("select e.id, e.schoolName, e.name, e.ssn, t.specialization" +
                ", t.officeNo " +
                "from TeachingStaffEntity t left join EmployeeEntity e on (e.employeeId=t.employeeId) where " +
                "e.schoolName=:schoolName");
        query.setParameter("schoolName", schoolName);
        List results = query.list();
        return results;
    }
}
