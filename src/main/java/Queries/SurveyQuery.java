package Queries;

import Queries.Supporter.HibarnateSupporter;
import entities.SchoolBusEntity;
import entities.SurveyEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SurveyQuery {
    public List makeQuery(String surveyId, String schoolName, String hodEmployeeId, String parentSsn) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SurveyEntity> criteria = criteriaBuilder.createQuery(SurveyEntity.class);
        Root<SurveyEntity> root = criteria.from(SurveyEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(surveyId != null){
            predicates.add(criteriaBuilder.like(root.get("surveyId"),surveyId));
        }
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(hodEmployeeId!= null){
            predicates.add(criteriaBuilder.like(root.get("hodEmployeeId"),hodEmployeeId));
        }
        if(parentSsn!= null){
            predicates.add(criteriaBuilder.like(root.get("parentSsn"),parentSsn));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SurveyEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
