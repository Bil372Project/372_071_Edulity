package Hibernate.Queries;

import Hibernate.Generator.HibernateSupporter;
import Hibernate.Entities.AnnouncementEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementQuery {
    public List makeQuery(Time submitDate, Time dueDate, String info, String teacherEmployeeId, String schoolName, Long classSection) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<AnnouncementEntity> criteria = criteriaBuilder.createQuery(AnnouncementEntity.class);
        Root<AnnouncementEntity> root = criteria.from(AnnouncementEntity.class);
        List <Predicate>  predicates = new ArrayList<>();
        if(submitDate != null){
            predicates.add(criteriaBuilder.equal(root.get("submitDate"),submitDate));
        }
        if(dueDate != null){
            predicates.add(criteriaBuilder.equal(root.get("dueDate"),dueDate));
        }
        if(info!= null){
            predicates.add(criteriaBuilder.like(root.get("info"),info));
        }
        if(teacherEmployeeId!= null){
            predicates.add(criteriaBuilder.like(root.get("teacherEmployeeId"),teacherEmployeeId));
        }
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(classSection != null){
            predicates.add(criteriaBuilder.equal(root.get("classSection"),classSection));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<AnnouncementEntity> query = session.createQuery(criteria);


        return query.list();
    }
}
