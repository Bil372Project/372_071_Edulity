package Hibernate.Queries;

import Hibernate.Generator.HibernateSupporter;
import Hibernate.Entities.ListOfHwQuestionsEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ListOfHwQuestionsQuery {
    public List makeQuery(String question, Long hwNumber) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ListOfHwQuestionsEntity> criteria = criteriaBuilder.createQuery(ListOfHwQuestionsEntity.class);
        Root<ListOfHwQuestionsEntity> root = criteria.from(ListOfHwQuestionsEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(question != null){
            predicates.add(criteriaBuilder.like(root.get("question"),question));
        }
        if(hwNumber != null){
            predicates.add(criteriaBuilder.equal(root.get("hwNumber"),hwNumber));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<ListOfHwQuestionsEntity> query = session.createQuery(criteria);


        return query.list();
    }
}
