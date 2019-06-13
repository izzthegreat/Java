package com.win.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.win.practice.domain.User;
import com.win.practice.domain.UserRepository;
import org.springframework.context.annotation.Bean;

import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootApplication
public class PracticeApplication {
    private static final Logger log = Logger.getLogger(PracticeApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner practice(UserRepository repository) {
        return args -> {
            log.setLevel(Level.SEVERE);

            repository.save(new User("Bill", "Clinton"));
            repository.save(new User("Barak", "Obama"));
            repository.save(new User("John", "Kennedy"));
            repository.save(new User("John", "Favreau"));
            repository.save(new User("Robert", "Downey"));
            repository.save(new User("Chris", "Hemsworth"));
            repository.save(new User("Scarlett", "Johanssen"));
            repository.save(new User("Elizabeth", "Olsen"));

            //read all Users
            log.severe("Users found with findAll():");
            log.severe("---------------------------");
            for(User user: repository.findAll()) {
                log.severe(user.toString());
            }
            log.severe("");

            // read an individual user by UserID
            repository.findById(1L).ifPresent(user -> {
                log.severe("Users found with findByID (iL):");
                log.severe("-------------------------------");
                log.severe(user.toString());
                log.severe("");
            });
        };
    }

}
