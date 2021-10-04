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


      Car car1 = new Car("Ford", 111);
      Car car2 = new Car("BMW", 2222);
      Car car3 = new Car("KIA", 3333);
      Car car4 = new Car("Dodge", 4444);

      User user1  = new User("User1", "Lastname1", "user1@mail.ru", car1);
      car1.setUser(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      car2.setUser(user2);
      User user3  = new User("User3", "Lastname3", "user3@mail.ru", car3);
      car3.setUser(user3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
      car4.setUser(user4);

      /*userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);*/


      /*System.out.println(userService.getUserByModel("Ford"));
      System.out.println(userService.getUserByModel("BMW"));
      System.out.println(userService.getUserByModel("KIA"));
      System.out.println(userService.getUserByModel("Dodge"));*/

      String carModel = "Dodge";
      User userData = userService.getUserByModel(carModel);
      System.out.println();
      System.out.println("Owner of Car = " + carModel);
      System.out.println("Id = " + userData.getId());
      System.out.println("First Name = "+userData.getFirstName());
      System.out.println("Last Name = "+userData.getLastName());
      System.out.println("Email = "+userData.getEmail());
      System.out.println();



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
