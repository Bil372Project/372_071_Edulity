package Queries;

import entities.HeadOfDepartmentEntity;
import entities.TeachingStaffEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HeadOfEmployeeQuery {

        public List makeQuery(String schoolName, String employeeId) {
            Session session = HibarnateSupporter.getSessionFactory().openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<HeadOfDepartmentEntity> criteria = criteriaBuilder.createQuery(HeadOfDepartmentEntity.class);
            Root<HeadOfDepartmentEntity> root = criteria.from(HeadOfDepartmentEntity.class);
            List<Predicate> predicates = new ArrayList<>();
            if(schoolName != null){
                predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
            }
            if(employeeId != null){
                predicates.add(criteriaBuilder.equal(root.get("employeeId"),employeeId));
            }

            criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
            Query<HeadOfDepartmentEntity> query = session.createQuery(criteria);

            return query.list();
        }
}
