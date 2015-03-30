package com.base.persistance;

import com.base.persistance.entityes.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cooper on 26.03.2015.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static HibernateUtil instance;

    private static ServiceRegistry serviceRegistry;

    public static Map<String, String> connectionSettings = new HashMap<String, String>();

    public static void addAnnotatedClasses(Configuration config) {
        config.addAnnotatedClass(User.class);
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }

        return sessionFactory;
    }

    private static void createSessionFactory()
            throws ExceptionInInitializerError {
        try {
            Date d1 = new Date();
            System.out.println("HibernateUtil: Opening DB connection.");
            Configuration config = new Configuration();
            HibernateUtil.addAnnotatedClasses(config);
            config.configure();

            connectionSettings.put("url",
                    config.getProperty("hibernate.connection.url"));
            connectionSettings.put("username",
                    config.getProperty("hibernate.connection.username"));
            connectionSettings.put("password",
                    config.getProperty("hibernate.connection.password"));

            System.out.println("URL: " + connectionSettings.get("url"));
            System.out.println("USER: " + connectionSettings.get("username"));
            System.out.println("PASSWORD: "
                    + connectionSettings.get("password"));

            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();

            sessionFactory = config.buildSessionFactory(serviceRegistry);

            checkConnection(d1);
        } catch (Exception ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
        }
    }

    public static void checkConnection() {
        Session s = sessionFactory.openSession();
        s.getTransaction().begin();
        s.close();
        s = null;

    }

    private static void checkConnection(Date d1) {
        try {
            checkConnection();
        } catch (Exception e) {
            System.out.println("Opening a DB connection... Failed");
            System.out.println(e);
            return;
        }

        System.out.println(String.format(
                "Connection was successfully opened in %d seconds",
                (new Date().getTime() - d1.getTime()) / 1000));
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }

        return instance;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }

}
