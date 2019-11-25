package Hibernate.Queries;

import Hibernate.Generator.HibernateSupporter;
import Hibernate.Entities.LunchMenuEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class LunchMenuQuery {

    public List makeQuery(Time lunchDay, String food) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<LunchMenuEntity> criteria = criteriaBuilder.createQuery(LunchMenuEntity.class);
        Root<LunchMenuEntity> root = criteria.from(LunchMenuEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(lunchDay != null){
            predicates.add(criteriaBuilder.equal(root.get("lunchDay"),lunchDay));
        }
        if(food != null){
            predicates.add(criteriaBuilder.like(root.get("food"),food));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<LunchMenuEntity> query = session.createQuery(criteria);



        return query.list();
    }
}

