package com.wixia.hexagonal.infrastructure.configuration;

import com.wixia.hexagonal.service.DomainOwnerService;
import com.wixia.hexagonal.repository.OwnerRepository;
import com.wixia.hexagonal.service.OwnerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfiguration {

    @Bean
    OwnerService ownerService(OwnerRepository ownerRepository) {
        return new DomainOwnerService(ownerRepository);
    }
}
