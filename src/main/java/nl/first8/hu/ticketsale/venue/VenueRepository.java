package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final EntityManager entityManager;

    @Autowired
    public VenueRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Concert> findConcertById(Long concertId) {
        return Optional.ofNullable(entityManager.find(Concert.class, concertId));
    }

    public List<Concert> findConcertByArtist(String name) {
        String jpql = "SELECT c " +
                "FROM Concert c " +
                "WHERE c.artist.name = :name";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Concert> findConcertByGenre(String genre) {
        String jpql = "SELECT c " +
                "FROM Concert c " +
                "WHERE c.artist.genre = :genre";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    public List<Concert> findConcertByLocation(String location) {
        String jpql = "SELECT c " +
                "FROM Concert c " +
                "WHERE c.location.name = :location";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("location", location);
        return query.getResultList();
    }
}
