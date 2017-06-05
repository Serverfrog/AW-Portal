package de.serverfrog.awportal.eao;

import de.serverfrog.awportal.common.AwPortal;
import de.serverfrog.awportal.common.Persistable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Serverfrog on 05.06.17.
 */

@Stateless
@NoArgsConstructor
@Log
public class Eao<T> {


    @Inject
    @Getter
    @AwPortal
    private EntityManager em;


    private Class<T> entityClass;

    public Eao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(Object id) {
        if (id == null) return null;
        return em.find(entityClass, id);
    }

    public Persistable store(Persistable p) {
        log.info("Storing " + p);
        if(findById(p.getId()) == null){
             em.persist(p);
            return p;
        }

        return em.merge(p);
    }


    public T findById(Object id, LockModeType lockModeType) {
        if (id == null) return null;
        return em.find(entityClass, id, lockModeType);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    public List<T> findAll(int start, int amount) {
        javax.persistence.criteria.CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).setFirstResult(start).setMaxResults(amount).getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult().intValue();
    }
}
