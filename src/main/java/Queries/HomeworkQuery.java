package Queries;

import Queries.Supporter.HibarnateSupporter;
import entities.EmployeeEntity;
import entities.HomeworkEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class HomeworkQuery {
    public List makeQuery(Long hwNumber, Time dueDate, String teacherEmployeeId, String schoolName, Long classSection) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<HomeworkEntity> criteria = criteriaBuilder.createQuery(HomeworkEntity.class);
        Root<HomeworkEntity> root = criteria.from(HomeworkEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(hwNumber != null){
            predicates.add(criteriaBuilder.equal(root.get("hwNumber"),hwNumber));
        }
        if(dueDate != null){
            predicates.add(criteriaBuilder.equal(root.get("dueDate"),dueDate));
        }
        if(teacherEmployeeId!= null){
            predicates.add(criteriaBuilder.like(root.get("teacherEmployeeId"),teacherEmployeeId));
        }
        if(schoolName!= null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(classSection!= null){
            predicates.add(criteriaBuilder.equal(root.get("classSection"),classSection));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<HomeworkEntity> query = session.createQuery(criteria);

        session.close();

        return query.list();
    }
}
