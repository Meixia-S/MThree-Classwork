package com.sg.jdbctcomplexexample;

import com.sg.jdbctcomplexexample.controller.MeetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author kylerudy
 */
@SpringBootApplication
public class App implements CommandLineRunner {
    
    @Autowired
    MeetingController controller;

    public static void main(String args[]) {
        try {
            SpringApplication.run(App.class, args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void run(String... args) throws Exception {
        controller.run();
    }
    
}
