package knowledgebase.dao;

import knowledgebase.domain.Catalog;
import knowledgebase.domain.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogDAOImpl implements CatalogDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Catalog c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Catalog> list() {
        Session session = this.sessionFactory.openSession();
        List<Catalog> catalogList = session.createQuery("FROM Catalog").list();
        session.close();
        return catalogList;
    }

    @Override
    public void renameCatalog(Integer id, String title) {
        Session session = this.sessionFactory.openSession();
        String hql = "UPDATE Catalog SET title = :title "  +
                "WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("title", title);
        query.setParameter("id", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    public String getUrlById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Catalog.class);
        criteria.add(Restrictions.eq("id", id));
        // TODO: ЗАПРОС ДОДЕЛАТЬ
        session.close();
        return "HOHOHO";
    }
}
