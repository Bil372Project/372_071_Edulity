package Hibernate.Queries;

import Hibernate.Entities.ClazzEntity;
import Hibernate.Generator.HibarnateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClazzQuery {

    public List makeQuery(String schoolName, Long section, String schedule, Long classSize) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ClazzEntity> criteria = criteriaBuilder.createQuery(ClazzEntity.class);
        Root<ClazzEntity> root = criteria.from(ClazzEntity.class);
        List <Predicate>  predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(section != null){
            predicates.add(criteriaBuilder.equal(root.get("section"),section));
        }
        if(schedule!= null){
            predicates.add(criteriaBuilder.like(root.get("schedule"),schedule));
        }
        if(classSize!= null){
            predicates.add(criteriaBuilder.equal(root.get("classSize"),classSize));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ClazzEntity> query = session.createQuery(criteria);


        return query.list();
    }
}
