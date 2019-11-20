package Hibernate.Queries;




import Hibernate.Entities.StudentEntity;
import Hibernate.Generator.HibarnateSupporter;

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
        CriteriaQuery<StudentEntity> criteria = criteriaBuilder.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteria.from(StudentEntity.class);
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
        Query<StudentEntity> query = session.createQuery(criteria);

        return query.list();
    }
    public void insertstu(String schoolName, String studentId, String name, Long numberOfAbsent, Long year, Time birthDate, String birthPlace, Long classSection, String parentSsn, Long schoolBusId)
    {
        HibarnateSupporter supporter = new HibarnateSupporter();
        StudentEntity student = new StudentEntity();
        student.setSchoolName(schoolName);
        student.setStudentId(studentId);
        student.setName(name);
        student.setNumberOfAbsent(numberOfAbsent);
        student.setYear(year);
        student.setBirthDate(birthDate);
        student.setBirthPlace(birthPlace);
        student.setClassSection(classSection);
        student.setParentSsn(parentSsn);
        student.setSchoolBusId(schoolBusId);
        supporter.createObject(student);
    }
}
