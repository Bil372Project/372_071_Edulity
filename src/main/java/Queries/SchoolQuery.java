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

public class SchoolQuery {
    public List makeQuery(String name, String schoolType, String schoolAddress ) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SchoolEntity> criteria = criteriaBuilder.createQuery(SchoolEntity.class);
        Root<SchoolEntity> root = criteria.from(SchoolEntity.class);
        List <Predicate>  predicates = new ArrayList<>();
        if(name != null){
            predicates.add(criteriaBuilder.like(root.get("name"),name));
        }
        if(schoolType != null){
            predicates.add(criteriaBuilder.like(root.get("schoolType"),schoolType));
        }
        if(schoolAddress!= null){
            predicates.add(criteriaBuilder.like(root.get("schoolAddress"),schoolAddress));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolEntity> query = session.createQuery(criteria);

        return query.list();
    }

}
