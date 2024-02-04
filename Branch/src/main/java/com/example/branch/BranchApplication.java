package com.example.branch;

import com.example.branch.entities.Branch;
import com.example.branch.repositories.BranchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BranchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BranchApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BranchRepository branchRepository){
        return args -> {
            Branch branch1=Branch.builder()
                    .coordinator("georges")
                    .name("ASEDS")
                    .build();

            Branch branch2=Branch.builder()
                    .coordinator("PHIL")
                    .name("Cloud")
                    .build();
            branchRepository.save(branch1);
        branchRepository.save(branch2);
        };

        }
}
