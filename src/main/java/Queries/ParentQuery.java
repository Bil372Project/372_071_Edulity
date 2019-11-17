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

public class ParentQuery {
    public List makeQuery(String ssn, String name, String phoneNumber, String address, String email) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SchoolEntity> criteria = criteriaBuilder.createQuery(SchoolEntity.class);
        Root<SchoolEntity> root = criteria.from(SchoolEntity.class);
        List <Predicate>  predicates = new ArrayList<>();
        if(ssn != null){
            predicates.add(criteriaBuilder.like(root.get("ssn"),ssn));
        }
        if(phoneNumber != null){
            predicates.add(criteriaBuilder.like(root.get("phoneNumber"),phoneNumber));
        }
        if(name!= null){
            predicates.add(criteriaBuilder.like(root.get("name"),name));
        }
        if(address!= null){
            predicates.add(criteriaBuilder.equal(root.get("address"),address));
        }
        if(email != null){
            predicates.add(criteriaBuilder.equal(root.get("email"),email));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
