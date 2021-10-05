package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      List<Car> cars = user.getCar();
      for (Car t : cars) {
         t.setUser(user);
      }
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByModel(String model) {
      Car car = (Car) sessionFactory.getCurrentSession().createQuery("from Car where model = :model").setParameter("model", model).uniqueResult();
      return car.getUser();
   }

   @Override
   public void cleanDb() {
      sessionFactory.getCurrentSession().createQuery("delete from User").executeUpdate();
      sessionFactory.getCurrentSession().createQuery("delete from Car").executeUpdate();
   }

   @Override
   public void removeUserById(long id) {
      Session session = sessionFactory.getCurrentSession();
      User user = (User) session.createQuery("from User where id = :id").setParameter("id", id).uniqueResult();
      session.delete(user);

   }



}
