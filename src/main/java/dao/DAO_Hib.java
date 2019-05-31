package dao;

import dao.abs.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Property;
import org.hibernate.service.ServiceRegistry;
import unit.Unit;

import java.util.List;

public class DAO_Hib {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";

    private final SessionFactory sessionFactory;

    public DAO_Hib() {
        Configuration configuration = getPostgresqlConfig();
        sessionFactory = createSessionFactory(configuration);
    }

    public void insertUser(Unit unit) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(unit);
            transaction.commit();
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public void updateUser(Unit unit) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(unit);
            transaction.commit();
        } catch (Exception e) {
            throw new DBException(e);
        }
    }


    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration getPostgresqlConfig() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Unit.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/test_sbis");
        configuration.setProperty("hibernate.connection.username", "test_sbis");
        configuration.setProperty("hibernate.connection.password", "test_sbis");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }
}