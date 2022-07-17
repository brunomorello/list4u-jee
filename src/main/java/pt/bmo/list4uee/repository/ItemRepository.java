package pt.bmo.list4uee.repository;

import pt.bmo.list4uee.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ItemRepository {

    @PersistenceContext(unitName = "list4UPU")
    private EntityManager em;

    public Item find(@NotNull @Min(1) Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item ORDER BY i.name", Item.class)
                .getResultList();
    }

    public Long countAll() {
        return em.createQuery("SELECT COUNT(i) FROM Item", Long.class)
                .getSingleResult();
    }

    @Transactional(REQUIRED)
    public Item create(@NotNull  Item item) {
        em.persist(item);
        return item;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Item item) {
        em.remove(em.getReference(Item.class, item.getId()));
    }
}
