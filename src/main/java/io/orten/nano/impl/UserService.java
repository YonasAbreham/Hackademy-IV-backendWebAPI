package io.orten.nano.impl;

import io.orten.nano.model.User;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class UserService {

        public static List<User> userList = new ArrayList<User>();

    /**
     *
     * @param userId
     * @return user
     * @throws Exception
     */
    public static User getUserById(long userId) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            User user = session.get(User.class, userId);
            session.close();
            return user;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

     /**
     *
     * @return list of users
     * @throws Exception
     */
    public static List<User> getUsers() throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            List users = session.createQuery("from User").list();
            session.close();
            return users;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param  userName
     * @return Search Users
     * @throws Exception
     */
        public static List getUsersByUserName(String userName) throws Exception {
            Session session = null;
            try {
                session = Database.getSession();
                Query query = session.createQuery("from User where userName like :userName");
                query.setParameter("userName", "%" + userName + "%");
                List<User> users = query.list();
                session.close();
                return users;
            } catch (HibernateException e) {
                throw e;
            } finally {
                if (session != null) session.close();
            }
        }

    /**
     *
     * @param user
     * @return Save User
     * @throws Exception
     */
        public static void saveUser(User user) throws Exception {
            Session session = null;
            Transaction tx = null;
            try {
                session = Database.getSession();
                tx = session.beginTransaction();
                session.save(user);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
            if (session != null) session.close();
            }
    }

    /**
     *
     * @param user
     * @return Upsate User
     * @throws Exception
     */
        public static void updateUser(User user) throws Exception {
            Session session = null;
            Transaction tx = null;
            try {
                session = Database.getSession();
                tx = session.beginTransaction();

                session.update(user);

                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                throw e;
            } finally {
                if (session != null) session.close();
        }
    }

    /**
     *
     * @param userId
     * @return delete User
     * @throws Exception
     */
    public static void deleteUser(Long userId) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            User user = session.get(User.class, userId);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }
}