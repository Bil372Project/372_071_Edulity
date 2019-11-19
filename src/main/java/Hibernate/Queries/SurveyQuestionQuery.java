package Hibernate.Queries;

import Hibernate.Entities.SurveyQuestionEntity;
import Hibernate.Generator.HibarnateSupporter;
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
        Session session = HibarnateSupporter.getSessionFactory().openSession();
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

        session.close();

        return query.list();
    }
}
