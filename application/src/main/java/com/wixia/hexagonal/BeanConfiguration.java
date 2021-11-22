package com.wixia.hexagonal;

import com.wixia.hexagonal.ports.DomainOwnerService;
import com.wixia.hexagonal.ports.OwnerRepository;
import com.wixia.hexagonal.ports.OwnerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OwnerService ownerService(OwnerRepository ownerRepository) {
        return new DomainOwnerService(ownerRepository);
    }
}
