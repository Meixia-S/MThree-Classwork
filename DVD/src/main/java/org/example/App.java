package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
//    DVDDAO dvddao = new DVDDAO();
//    DVDController dvdController = new DVDController(dvddao);
//    DVDView dvdView = new DVDView(dvdController);
//    dvdView.run();

    ApplicationContext ctx =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    DVDView view =
            ctx.getBean("view", DVDView.class);
    view.run();
  }
}