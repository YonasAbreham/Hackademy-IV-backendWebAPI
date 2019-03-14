package io.orten.nano.util;

import io.orten.nano.model.User;
import io.orten.nano.model.Organization;
import io.orten.nano.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Creates and manages connections with and transactions to the database
 */
public class Database {

    private static SessionFactory sessionFactory;

    private static void init() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
                .build();
        MetadataSources mds = new MetadataSources(registry);
        Metadata md = mds.buildMetadata();
        sessionFactory = md.buildSessionFactory();
        //Make sure that the service registry is destroyed on shutdown by adding a shutdown hook to the runtime
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            StandardServiceRegistryBuilder.destroy(registry);
        }));
    }

    /**
     * saves an organization object to the database
     */
    public static boolean saveOrganization(Organization org) {
        if (sessionFactory == null)
            init();
        try (Session s = sessionFactory.openSession()) {
            s.beginTransaction();
            Long orgId = org.getOrganizationId();
            String orgNo= org.getOrganizationNumber();
            boolean flag = Pattern.matches("\\w{6}-\\w{4}",orgNo);
            if ((getOrganization(orgId) == null) && (flag)) {
                s.save(org);
                s.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * updates an organization object already saved in saved in the database
     */
    public static void updateOrganization(Organization org) {
        if (sessionFactory == null)
            init();
        try (Session s = sessionFactory.openSession()) {
            s.beginTransaction();
            s.update(org);
            s.getTransaction().commit();
        }
    }

    /**
     * gets one organization object from the database based on its ID
     */
    public static Organization getOrganization(Long orgId) {
        if (sessionFactory == null)
            init();
        try (Session s = sessionFactory.openSession()) {
            List<Organization> list = new ArrayList<>();
            Query q = s.createQuery("from Organization as org where org.organizationId = :orgId");
            q.setParameter("orgId", orgId);
            list = q.getResultList();
            if (list.isEmpty()) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    /**
     * gets all the organizations' objects from the database
     */
    public static List<Organization> getAllOrganizations() {
        List<Organization> list = new ArrayList<>();
        if (sessionFactory == null)
            init();
        try (Session s = sessionFactory.openSession()) {
            Query q = s.createQuery("from Organization");
            list = q.getResultList();
            return list;
        }
    }

    /**
     * delets an organization object from the database
     */
    public static boolean deleteOrganization(Long orgId) {
        if (sessionFactory == null)
            init();
        try (Session s = sessionFactory.openSession()) {
            s.beginTransaction();
            Query q = s.createQuery("from Organization org where org.organizationId = :orgId");
            q.setParameter("orgId", orgId);
            List<Organization> list = q.getResultList();
            if (!list.isEmpty()) {
                s.delete(list.get(0));
                s.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * belongs to ProjectService class
     */
    public static Session getSession() throws Exception {
        if (sessionFactory == null) {
            init();
        }
        Session session = sessionFactory.openSession();
        return session;
    }
    /* Method  return sum of donated amount for each project based on
 * based on Project ID and calculate it's percentage
 */
    public static double getSumOfAmountFunded(int projectID)  {

        if(sessionFactory == null){
            init();
        }
        double result=0.0, amoutToBeRaised=0.0,progressPerPercentage=0.0;
        try(Session s=sessionFactory.openSession()){
            s.getTransaction();
            String sumHql = "SELECT SUM(t.amount) FROM  Transaction t WHERE t.project.projectID = :projectID";
            Query sumQuery = s.createQuery(sumHql);
            sumQuery.setParameter("projectID",projectID);
            result= (Double)sumQuery.list().get(0);
            try {
                progressPerPercentage= ( result/ searchOneProject(projectID).getAmountToBeRaised()) * 100;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return progressPerPercentage;
    }
    ///Method for search specific project base on project_ID and display
    public static Project searchOneProject(int projectID) throws  Exception{

        if(sessionFactory==null) {
            init();
        }
        Project result = null;
        try(Session s=sessionFactory.openSession()){
            s.beginTransaction();
            Project model=(Project)s.get(Project.class,projectID);
            result=model;
        }
        return result;
    }
    //Method for displaying all list  projects
    public static  List<User> getListOfTransaction() throws Exception {

        if(sessionFactory == null) {
            init();
        }
        List<User> users = null;
        try(Session s=sessionFactory.openSession()){
            s.getTransaction();
            String hql = "from User d";
            users = s.createQuery(hql).list();
        }
        return users;

    }
}