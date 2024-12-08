package com.tombari.observabilityspringboot;

import com.tombari.observabilityspringboot.entities.Product;
import com.tombari.observabilityspringboot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class ObservabilitySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilitySpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            log.info("================= Initialization ================");
            List<Product> products = List.of(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Computer")
                            .price(3200)
                            .quantity(11)
                            .build(),
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Printer")
                            .price(1299)
                            .quantity(10)
                            .build(),
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Smart Phone")
                            .price(5400)
                            .quantity(8)
                            .build()
            );
            productRepository.saveAll(products);
            log.info("Products saved successfully: {}", products);

            productRepository.findAll().forEach(p->{
                System.out.println("======================");
                System.out.println(p.getId());
                System.out.println(p.getName());
                System.out.println(p.getPrice());
                System.out.println(p.getQuantity());
                System.out.println("=======================");
            });
        };
    }
}
