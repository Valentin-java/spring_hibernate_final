package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
/*      Car car1 = new Car("Ford", 111);
      Car car2 = new Car("BMW", 2222);
      Car car3 = new Car("KIA", 3333);
      Car car4 = new Car("Dodge", 4444);

      List<Car> listCars1 = new ArrayList<>();
      listCars1.add(car1);
      listCars1.add(car2);

      List<Car> listCars2 = new ArrayList<>();
      listCars2.add(car3);
      listCars2.add(car4);


      User user1  = new User("User1", "Lastname1", "user1@mail.ru", listCars1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", listCars2);

      userService.add(user1);
      userService.add(user2);*/

      //userService.removeUserById(1);

      User userDb = userService.getUserByModelAndSeries("Ford", 111);
      System.out.println("Id = " + userDb.getId());
      System.out.println("First Name = " + userDb.getFirstName());
      System.out.println("Last Name = " + userDb.getLastName());
      System.out.println("Email = " + userDb.getEmail());
      System.out.println();



      /*List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }*/

      context.close();
   }
}
