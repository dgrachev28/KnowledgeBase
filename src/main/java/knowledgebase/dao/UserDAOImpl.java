package knowledgebase.dao;

import knowledgebase.domain.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByLoginPassword(String login, String password) {
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("password", password));
        List<User> users = criteria.list();
        session.close();
        if (users.isEmpty()) {
            return null;
        }
        if (users.size() == 1) {
            return users.get(0);
        } else {
//            TODO: выбросить исключение (одинаковые логины в базе)
            return null;
        }
    }
}
