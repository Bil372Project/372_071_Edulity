package Queries;

import entities.SchoolEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class StudentQuery {

    public List makeQuery(String schoolName, String studentId, String name, Long numberOfAbsent, Long year, Time birthDate, String birthPlace, Long classSection, String parentSsn, Long schoolBusId) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SchoolEntity> criteria = criteriaBuilder.createQuery(SchoolEntity.class);
        Root<SchoolEntity> root = criteria.from(SchoolEntity.class);
        List <Predicate>  predicates = new ArrayList<>();
        if(schoolName != null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        if(studentId != null){
            predicates.add(criteriaBuilder.like(root.get("studentId"),studentId));
        }
        if(name!= null){
            predicates.add(criteriaBuilder.like(root.get("name"),name));
        }
        if(numberOfAbsent!= null){
            predicates.add(criteriaBuilder.equal(root.get("numberOfAbsent"),numberOfAbsent));
        }
        if(year != null){
            predicates.add(criteriaBuilder.equal(root.get("year"),year));
        }
        if(birthDate != null){
            predicates.add(criteriaBuilder.equal(root.get("birthDate"),birthDate));
        }
        if(birthPlace!= null){
            predicates.add(criteriaBuilder.like(root.get("birthPlace"),birthPlace));
        }
        if(classSection != null){
            predicates.add(criteriaBuilder.equal(root.get("classSection"),classSection));
        }
        if(parentSsn!= null){
            predicates.add(criteriaBuilder.like(root.get("parentSsn"),parentSsn));
        }
        if(schoolBusId != null){
            predicates.add(criteriaBuilder.equal(root.get("schoolBusId"),schoolBusId));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolEntity> query = session.createQuery(criteria);

        return query.list();
    }
}
