package Hibernate.Queries;
import Hibernate.Entities.EmployeeEntity;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EmployeeQuery {
    public List makeQuery(String employeeId, String schoolName, String ssn, String name) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteria = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = criteria.from(EmployeeEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(employeeId != null){
            predicates.add(criteriaBuilder.equal(root.get("employeeId"),employeeId));
        }
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(ssn!= null){
            predicates.add(criteriaBuilder.like(root.get("ssn"),ssn));
        }
        if(name!= null){
            predicates.add(criteriaBuilder.like(root.get("name"),name));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<EmployeeEntity> query = session.createQuery(criteria);
        System.out.println(query.list());

        return query.list();
    }
}
