package com.example.EmployeeManagement.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner (EmployeeRepository repository){
        return args -> {
            Employee John = new Employee(
                    "John",
                    "John@gmail.com",
                    "9090909090",
                    18
            );
            Employee Alex = new Employee(
                    "Alex",
                    "Alex@gmail.com",
                    "9090909090",
                    23
            );
            repository.saveAll(
                    List.of(
                            John,
                            Alex
                    )
            );
        };
    }
}
