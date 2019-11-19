package Queries;

import Queries.Supporter.HibarnateSupporter;
import entities.ParentEntity;
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
        CriteriaQuery<ParentEntity> criteria = criteriaBuilder.createQuery(ParentEntity.class);
        Root<ParentEntity> root = criteria.from(ParentEntity.class);
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
            predicates.add(criteriaBuilder.like(root.get("address"),address));
        }
        if(email != null){
            predicates.add(criteriaBuilder.like(root.get("email"),email));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ParentEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
