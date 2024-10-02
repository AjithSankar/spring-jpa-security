package dev.ak.springjpasecurity;

import dev.ak.springjpasecurity.model.Post;
import dev.ak.springjpasecurity.model.User;
import dev.ak.springjpasecurity.repository.PostRepository;
import dev.ak.springjpasecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringJpaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PostRepository posts, UserRepository users, PasswordEncoder encoder) {
        return args -> {
            users.save(new User("user", encoder.encode("password"), "ROLE_USER"));
            users.save(new User("admin", encoder.encode("password"), "ROLE_ADMIN, ROLE_USER"));
            posts.save(new Post("Hello, World!","hello-world","Welcome to my new blog!","Ajith Kumar"));
        };

    }

}
