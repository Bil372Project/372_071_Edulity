package Hibernate.Queries;

import Hibernate.Entities.SurveyQuestionEntity;
import Hibernate.Generator.HibernateSupporter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SurveyQuestionQuery {
    public List makeQuery(Long score, String question, String surveyId) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SurveyQuestionEntity> criteria = criteriaBuilder.createQuery(SurveyQuestionEntity.class);
        Root<SurveyQuestionEntity> root = criteria.from(SurveyQuestionEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(score != null){
            predicates.add(criteriaBuilder.equal(root.get("score"),score));
        }
        if(question != null){
            predicates.add(criteriaBuilder.like(root.get("question"),question));
        }
        if(surveyId != null){
            predicates.add(criteriaBuilder.like(root.get("surveyId"),surveyId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SurveyQuestionEntity> query = session.createQuery(criteria);

        return query.list();
    }

    public List getQuestions(String schoolName, String parentSSN) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("select q.question from " +
                "SurveyEntity s left join SurveyQuestionEntity q on (s.id = q.id) where " +
                "s.schoolName=:schoolName and " +
                "s.parentSsn =: parentSSN");
        query.setParameter("schoolName", schoolName);
        query.setParameter("parentSSN", parentSSN);
        return query.list();
    }
}
