package impl;


import dao.UserDAO;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;


public class UserDaoImpl implements UserDAO {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public void createUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = null;
        User user = null;
        criteria = session.createCriteria(User.class);
        Criterion criterion = (Criterion) Restrictions.eq("id", id);
        criteria.add(criterion);
        criteria.setMaxResults(1);
        user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User getUserByUsernameAndPwd(String userName, String pwd) {
        Session session = sessionFactory.openSession();
        Criteria criteria = null;
        User user = null;
        criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.and(Restrictions.eq("userName", userName), Restrictions.eq("pwd", pwd)));
        criteria.setMaxResults(1);
        user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User getUserByMail(String email) {
        Session session = sessionFactory.openSession();
        User user = null;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.setMaxResults(1);
        user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        session.delete(id);
        session.close();
    }
}









