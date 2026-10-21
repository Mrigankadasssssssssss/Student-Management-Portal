package com.mriganka.TeachingKnights.config;

import com.mriganka.TeachingKnights.models.Users;
import com.mriganka.TeachingKnights.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner createDefaultAdmin(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return (args) -> {
            if(userRepo.findByUsername("admin").isEmpty()){
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setEmail("admin@admin.com");
                admin.setActive(true);
                userRepo.save(admin);
                System.out.println("Default admin user created.");
            }
            else {
                System.out.println("Admin user already exists.");
            }
        };
    }
}
