package abstractFacade;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

public abstract class AbstractFacade<T> implements IDao<T>{
    
    protected abstract Class<T> getEntityClass();

    private String getEntityClassName() {
        return getEntityClass().getSimpleName();
    }
    
    @Override
    public boolean create(T o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean update(T o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(T o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public T getById(int id) {
        T entity = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        entity = (T) session.get(getEntityClass(), id);
        session.getTransaction().commit();
        return entity;
    }
    
    @Override
    public List<T> getAll() {
        List<T> entities = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        entities = session.createQuery("from " + getEntityClassName()).list();
        session.getTransaction().commit();
        return entities;
    }

}
