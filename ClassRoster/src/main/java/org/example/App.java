package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException, ClassRosterException {
//    UserIOLab myIo = new UserIOLab();
//    ClassRosterView myView = new ClassRosterView(myIo);
//    ClassRosterDAO myDao = new ClassRosterDAO();
//    ClassAuditDao myAuditDao = new ClassAuditDao();
//    ClassRosterServiceLayer myService =
//            new ClassRosterServiceLayer(myDao, myAuditDao);
//    ClassRosterController controller =
//            new ClassRosterController(myService, myView);
//    controller.run();

    ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    ClassRosterController controller =
            ctx.getBean("controller", ClassRosterController.class);
    controller.run();
  }
}