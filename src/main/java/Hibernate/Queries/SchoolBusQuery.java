package Hibernate.Queries;

import Hibernate.Generator.HibarnateSupporter;
import Hibernate.Entities.SchoolBusEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SchoolBusQuery {
    public List makeQuery(Long id, String licensePlate, String destination, Long capacity, String driverId, String schoolName) {
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SchoolBusEntity> criteria = criteriaBuilder.createQuery(SchoolBusEntity.class);
        Root<SchoolBusEntity> root = criteria.from(SchoolBusEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if(id != null){
            predicates.add(criteriaBuilder.equal(root.get("id"),id));
        }
        if(licensePlate != null){
            predicates.add(criteriaBuilder.like(root.get("licensePlate"),licensePlate));
        }
        if(destination!= null){
            predicates.add(criteriaBuilder.like(root.get("destination"),destination));
        }
        if(capacity!= null){
            predicates.add(criteriaBuilder.equal(root.get("capacity"),capacity));
        }
        if(driverId!= null){
            predicates.add(criteriaBuilder.like(root.get("driverId"),driverId));
        }
        if(schoolName!= null){
            predicates.add(criteriaBuilder.like(root.get("schoolName"),schoolName));
        }
        criteria.select(root).where((Predicate[]) predicates.toArray(new Predicate[0]));
        Query<SchoolBusEntity> query = session.createQuery(criteria);

        return query.list();
    }

    public List getStops(String schoolName, long busId) {
        List stops = null;
        Session session = HibarnateSupporter.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("select s.stopName from " +
                "SchoolBusEntity b, SchoolBusStopsEntity stops left join StopEntity s on (b.id=stops.schoolBusId and stops.stopId=s.id) " +
                "where " +
                "b.schoolName=:schoolName and b.id=:busId and stops.schoolBusId=:busId");
        query.setParameter("schoolName", schoolName);
        query.setParameter("busId", busId);
        stops = query.list();
        session.close();
        return stops;
    }
}
