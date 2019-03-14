package io.orten.nano.impl;

import io.orten.nano.model.Event;
import io.orten.nano.util.Database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    public static List<Event> eventList = new ArrayList<Event>();

    /**
     *
     * @param eventId
     * @return event
     * @throws Exception
     */
    public static Event getEventByEventId(long eventId) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            Event event = session.get(Event.class, eventId);
            session.close();
            return event;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param projectId
     * @return event
     * @throws Exception
     */
    public static List<Event> getEventsByProjectId(long projectId) throws Exception {

        Session session = null;
        try {
            session = Database.getSession();
            Query query = session.createQuery("from Event where projectId = :projectId");
            query.setParameter("projectId", projectId);
            List<Event> events = query.list();
            session.close();
            return events;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @return list of Events
     * @throws Exception
     */
    public static List<Event> getListOfEvents() throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            List Events = session.createQuery("from Event").list();
            session.close();
            return Events;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param eventTitle
     * @return Search Events
     * @throws Exception
     */
    public static List getEventsByEventTitle(String eventTitle) throws Exception {
        Session session = null;
        try {
            session = Database.getSession();
            Query query = session.createQuery("from Event where eventTitle like :eventTitle");
            query.setParameter("eventTitle", "%" + eventTitle + "%");
            List<Event> events = query.list();
            session.close();
            return events;
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    public static void saveEvent(Event event) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            session.save(event);
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
     * @param event
     * @throws Exception
     */
    public static void updateEvent(Event event) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();

            session.update(event);

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
     * @param eventId
     * @throws Exception
     */
    public static void deleteEvent(Long eventId) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = Database.getSession();
            tx = session.beginTransaction();
            Event event = session.get(Event.class, eventId);
            session.delete(event);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }
}