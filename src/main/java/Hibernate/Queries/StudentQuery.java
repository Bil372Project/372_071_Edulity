package Hibernate.Queries;




import Hibernate.Entities.StudentEntity;
import Hibernate.Generator.HibernateSupporter;

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
        Session session = HibernateSupporter.getSessionFactory().openSession();
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
    public void insertstu(String schoolName, String studentId, String name, Long numberOfAbsent, Long year, Time birthDate, String birthPlace, Long classSection, String parentSsn, Long schoolBusId) {
        HibernateSupporter supporter = new HibernateSupporter();
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
    public void deletestu(StudentEntity student) {
        HibernateSupporter supporter = new HibernateSupporter();
        supporter.delete(student);
    }

    public List getSchedule(StudentEntity student) {
        return getSchedule(student.getClassSection(), student.getSchoolName());
    }

    public List getSchedule(Long section, String schoolName) {
        Session session = HibernateSupporter.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("select DISTINCT s.courseName, s.startDate, s.endDate from " +
                "ScheduleConsistsOfEntity s, " +
                "ClazzEntity c where s.scheduleId=:schedule");
        Query query2 = session.createQuery("select DISTINCT c.schedule from ClazzEntity c, " +
                "StudentEntity s where c.section=:section and c.schoolName=:schoolName");
        query2.setParameter("section",section);
        query2.setParameter("schoolName", schoolName);
        String schedule = (String) query2.list().get(0);
        query.setParameter("schedule",schedule);
        return query.list();
    }

}
