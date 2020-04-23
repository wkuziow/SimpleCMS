package pl.coderslab.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract public class Dao<B> {
    private Class<B> Bclass;

    private B b;

    @PersistenceContext
    public EntityManager entityManager;

    public void save(B b) {
        entityManager.persist(b);
    }

    public B findById(long id) {
        return entityManager.find(Bclass, id);
    }

    public void update(B b) {
        entityManager.merge(b);
    }

    public void delete(B b) {
        entityManager.remove(entityManager.contains(b) ?
                b : entityManager.merge(b));
    }
}
