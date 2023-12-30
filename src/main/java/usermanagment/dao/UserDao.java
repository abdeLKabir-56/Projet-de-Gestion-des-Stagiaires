package usermanagment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mysql.cj.util.StringUtils;

import usermanagment.model.User;
import usermanagment.util.HibernateUtil;
import AdminOperations.Stagiaire; // Import Stagiaire class

public class UserDao {
    
    // Other methods remain unchanged

    public void saveStagiaire(Stagiaire stagiaire) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(stagiaire);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateStagiaire(Stagiaire stagiaire) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(stagiaire);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStagiaire(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Stagiaire stagiaire = session.get(Stagiaire.class, id);
            if (stagiaire != null) {
                session.delete(stagiaire);
                System.out.println("Stagiaire is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Stagiaire getStagiaire(int id) {
        Transaction transaction = null;
        Stagiaire stagiaire = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            stagiaire = session.get(Stagiaire.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return stagiaire;
    }

    @SuppressWarnings("unchecked")
    public List<Stagiaire> getAllStagiaire() {
        Transaction transaction = null;
        List<Stagiaire> listOfStagiaire = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfStagiaire = session.createQuery("from Stagiaire").getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfStagiaire;
    }
    
    public List<Stagiaire> searchStagiaire(String search) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Search SessionFactory obtained successfully");
            Transaction transaction = null;
            List<Stagiaire> listOfStagiaire = null;
            if (StringUtils.isNullOrEmpty(search)) {
                // Return all Stagiaires if no search parameter provided
                return session.createQuery("from Stagiaire", Stagiaire.class).getResultList();
            }
            // Build dynamic query based on search parameter
            String queryString = "from Stagiaire s where s.nom like :search or s.prenom like :search or s.CIN like :search";
            Query query = session.createQuery(queryString);
            query.setParameter("search", "%" + search + "%");
            return query.getResultList();
        }
    }

    public int countStagiaires() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("SessionFactory obtained successfully");
            Transaction transaction = null;
            
            // Build dynamic query based on search parameter
            String queryString = "select count(*) from Stagiaire";
            Query query = session.createQuery(queryString);
            
            Integer count = ((Number) query.uniqueResult()).intValue();
            return count;
        }
    }

}
